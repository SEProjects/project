package de.autovermietung.onlineSystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;

import de.autovermietung.dao.AutovermietungDAOLocal;
import de.autovermietung.dao.Databuilder;
import de.autovermietung.dto.AlleAutosResponse;
import de.autovermietung.dto.AutoArtResponse;
import de.autovermietung.dto.AutoListResponse;
import de.autovermietung.dto.AutoResponse;
import de.autovermietung.dto.EditResponse;
import de.autovermietung.dto.KSResponse;
import de.autovermietung.dto.KundeResponse;
import de.autovermietung.dto.KundenLoginResponse;
import de.autovermietung.dto.MarkeResponse;
import de.autovermietung.dto.RechnungsResponse;
import de.autovermietung.dto.ReturncodeResponse;
import de.autovermietung.entities.Auto;
import de.autovermietung.entities.Autoart;
import de.autovermietung.entities.Bezahlmethode;
import de.autovermietung.entities.Kraftstoff;
import de.autovermietung.entities.Kunde;
import de.autovermietung.entities.Marke;
import de.autovermietung.entities.PLZ;
import de.autovermietung.entities.Rechnung;
import de.autovermietung.entities.Session;
import de.autovermietung.exceptions.InvalidLoginException;
import de.autovermietung.exceptions.KeineAutosException;
import de.autovermietung.exceptions.KeineSessioException;
import de.autovermietung.exceptions.KundeNichtVorhandenException;
import de.autovermietung.exceptions.NichtVorhandenException;
import de.autovermietung.exceptions.OnlineIntegrationExceptions;
import de.autovermietung.exceptions.SessionabgelaufenException;
import de.autovermietung.util.DtoAssembler;

/**
 * Session Bean implementation class OnlineIntegration
 */
@Stateless
@WebService
public class OnlineIntegration {

	@EJB(beanName = "AutovermietungDAO", beanInterface = de.autovermietung.dao.AutovermietungDAOLocal.class)
	private AutovermietungDAOLocal dao;
	@Resource
	private WebServiceContext wsContext;
	@EJB
	private DtoAssembler dto;
	private static final Logger logger = Logger.getLogger(Databuilder.class);
    /**
     * Default constructor. 
     */
    public OnlineIntegration() {
        // TODO Auto-generated constructor stub
    }
    
    private Session getSession(int Id) throws SessionabgelaufenException, KeineSessioException{
  	   Session session = dao.findSessionbyId(Id);
  	   if(session == null)
  		   throw new KeineSessioException("Bitte loggen Sie sich zuerst ein.");
  	   else {
  		   Date created  = session.getTimestamp();
  		   long startTime = created.getTime();
  			long jetzt = new Date().getTime();
  			long seconds=jetzt-startTime;
  		   
  		   logger.info(seconds*0.001);
  		   if(seconds > 300000){
  			   dao.deleteSession(session);
  			   throw new SessionabgelaufenException("Ihre Session ist leider abgelaufen. Bitte loggen sie sich erneurt ein");
  		   } else {
  		   
  			   session.updateTimestamp();
  			   return session;
  		   }  
  	   }
     }
    
    public KundenLoginResponse login(@WebParam(name="email") String email, @WebParam(name="password") String password)   {
        
    	KundenLoginResponse klr = new KundenLoginResponse();
    	
		try {
			Kunde kunde = this.dao.findKundebyEmail(email);	
			
			if (kunde != null && kunde.getKpassword().equals(password)) {
				Session session = dao.createSession(kunde);
				klr.setSession(session.getSid());
			}
			else {
				throw new InvalidLoginException("Login fehlgeschlagen, da Kunde unbekannt oder Passwort falsch. username=" + email + " " + password);
			}
		}
		catch (InvalidLoginException e) {
			klr.setReturnCode(e.getErrorCode());
			klr.setMessage(e.getMessage());
		}
		return klr;
	    
    }
    
    public ReturncodeResponse logout(@WebParam(name="sessionId") int sessionId) {
    	Session session;
		try {
			session = getSession(sessionId);
			dao.deleteSession(session);
		} catch (SessionabgelaufenException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeineSessioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ReturncodeResponse response = new ReturncodeResponse();
		logger.info("Logout erfolgreich. Session=" + sessionId);
		return response;
	}
    
    public KundeResponse getKunde(@WebParam(name="Sessionid") int session,@WebParam(name="Kundeemail") String email){
        KundeResponse kr = new KundeResponse();
     	try {
     		Session sessionId = getSession(session);
 			Kunde kunde = dao.findKundebyEmail(email);
 			if (kunde != null) {
 				kr = dto.makeDTO(kunde);
 			} else {
 				throw new KundeNichtVorhandenException("Kunde nicht vorhanden");
 			}
 		}
 		catch (OnlineIntegrationExceptions e) {
 			kr.setReturnCode(e.getErrorCode());
 			kr.setMessage(e.getMessage());
 		}
     	return kr;
     }
    /**
     * ########## For Auto Use-Cases
     */
    /**
     * 
     * @param session
     * @param autoid
     * @return AutoResponse
     */
    
    public AutoResponse getAuto(@WebParam(name="Sessionid") int session,@WebParam(name="Autoid") int autoid){
		AutoResponse ar = new AutoResponse();
		try {
			Session Nsession = getSession(session);
		   	Auto auto = dao.findAutobyID(autoid);	
			if (auto != null) {
				ar.setAid(auto.getAid());
				ar.setBez(auto.getBez());
				ar.setAa(auto.getAutoart().getAaid());
				ar.setPosition(auto.getPosition());
			} else {						
				throw new NichtVorhandenException("Auto ist nicht vorhanden");
			}
		} catch (OnlineIntegrationExceptions e) {
			ar.setReturnCode(e.getErrorCode());
			ar.setMessage(e.getMessage());
		}  
		return ar;
	}
    
    public MarkeResponse getMarke(@WebParam(name="Sessionid")int session, @WebParam(name="MarkeId")int markeId) {
    	MarkeResponse mR = new MarkeResponse();
    	try {
			Session sessionId = getSession(session);
			Marke marke = dao.findMarkebyID(markeId);
			if(marke != null) {
				mR.setMarkeid(marke.getMarkeid());
				mR.setMarkenname(marke.getMarkenname());
			} else {
				throw new NichtVorhandenException("Marke ist nict vorhanden");
			}
    	} catch (OnlineIntegrationExceptions e) {
			mR.setReturnCode(e.getErrorCode());
			mR.setMessage(e.getMessage());
		}  
    	return mR;
    }
    
    public KSResponse getKraftstoff(@WebParam(name="Sessionid")int session, @WebParam(name="KsId")int ksId) {
    	KSResponse kR = new KSResponse();
    	try {
			Session sessionId = getSession(session);
			Kraftstoff kraftstoff = dao.findKsbyId(ksId);
			if(kraftstoff != null) {
				kR.setKsid(kraftstoff.getKsid());
				kR.setBezeichnung(kraftstoff.getKsbezeichnung());
			} else {
				throw new NichtVorhandenException("Marke ist nict vorhanden");
			}
    	} catch (OnlineIntegrationExceptions e) {
			kR.setReturnCode(e.getErrorCode());
			kR.setMessage(e.getMessage());
		}  
    	return kR;
    }
    
    public AutoListResponse getAllAutos(@WebParam(name="Sessionid") int session){	
    	AutoListResponse aar = new AutoListResponse();
    	try {
    		Session sessionId = getSession(session);
    		//logger.info("Test" + dao.getAllAutos().get(0).getClass().getName());
    		List<Integer> aId = dao.getAllAutosA();
    		List<Auto> autoList = new ArrayList<>();
    		for(int i = 0; i < aId.size(); i++) {
    			Auto auto = dao.findAutobyID(aId.get(i));
    			autoList.add(auto);
    		}
    		aar.setAutoList(dto.makeDTO(autoList));
		} catch (OnlineIntegrationExceptions e) {
			//logger.info("Test" + dao.getAllAutos().get(0).getClass().getName());
			aar.setReturnCode(e.getErrorCode());
			aar.setMessage(e.getMessage());
		}
    	return aar;
    }
    public AutoArtResponse getAutoArt(@WebParam(name="Sessionid") int sessionId, @WebParam(name="AutoArtId") int id) {
    	AutoArtResponse aar = new AutoArtResponse();
    	try {
			Session sessionid = getSession(sessionId);  
	    	Autoart autoArt = dao.findAutoartbyID(id);
	    	if(autoArt != null) {
	    		aar.setAaid(id);
	    		aar.setBeschreibung(autoArt.getBeschreibung());
	    		aar.setKofferraumvolumen(autoArt.getKofferraumvolumen());
	    		aar.setPjk(autoArt.getPjk());
	    		aar.setPs(autoArt.getPs());
	    		aar.setSitzanzahl(autoArt.getSitzanzahl());
	    		aar.setKs(autoArt.getKs().getKsid());
	    		aar.setMarke(autoArt.getMarke().getMarkeid());
	    	}
		} catch (OnlineIntegrationExceptions e) {
			aar.setReturnCode(e.getErrorCode());
			aar.setMessage(e.getMessage());
		}
    	return aar;
    }
    
    public RechnungsResponse rechnung(@WebParam(name="Sessionid") int session,@WebParam(name="Rechnungsid") int rid){
		RechnungsResponse rechung = new RechnungsResponse();
		
		 try {
			 Session Nsession = getSession(session);
		   		
		   		Rechnung rechn = dao.findRechnungbyID(rid);
				
					if (rechn != null) {
						rechung.setGesamtpreis(rechn.getGesamtpreis());
						rechung.setMwst(rechn.getMwst());
						rechung.setRechnungspositionen(rechn.getRechnungspositionen());
						rechung.setKunde(rechn.getKunde());
					}
					else {
						
						throw new NichtVorhandenException("Rechnung ist nicht vorhanden");
					}
				}
				catch (OnlineIntegrationExceptions e) {
					rechung.setReturnCode(e.getErrorCode());
					rechung.setMessage(e.getMessage());
				}
			   
		  
		  
		  return rechung;
		
		
	}
    public EditResponse updateKunde(@WebParam(name="Sessionid") int session,@WebParam(name="email") String Email,
    		@WebParam(name="Passwort") String kpassword,
    		@WebParam(name="Nachname")String knachname,
    		@WebParam(name="Strasse")String strasse,
    		@WebParam(name="PLZ")PLZ plz){
		EditResponse up = new EditResponse();
		
		 try {
			 Session Nsession = getSession(session);
		   		
		   		Kunde k = dao.findKundebyEmail(Email);
				
					if (k != null) {
						k.setKpassword(kpassword);
						k.setKnachname(knachname);
						k.setStrasse(strasse);
						k.setKplz(plz);
						up.setSuccessful(true);
					}
					else {
						
						throw new NichtVorhandenException("Kunde ist nicht vorhanden");
					}
				}
				catch (OnlineIntegrationExceptions e) {
					up.setReturnCode(e.getErrorCode());
					up.setMessage(e.getMessage());
				}
			   
		  
		  
		  return up;
		
		
	}
    public EditResponse rechnungBezahlen(@WebParam(name="Sessionid") int session,@WebParam(name="Rechnungsid") int rid){
    	EditResponse response = new EditResponse();
		 try {
			 Session Nsession = getSession(session);
		   		
		   		Rechnung rechn = dao.findRechnungbyID(rid);
				
					if (rechn != null) {
						rechn.setAbgerechnet(true);
						response.setSuccessful(true);
						
					}
					else {
						
						throw new NichtVorhandenException("Rechnung ist nicht vorhanden");
					}
				}
				catch (OnlineIntegrationExceptions e) {
					response.setReturnCode(e.getErrorCode());
					response.setMessage(e.getMessage());
				}
		  
		  return response;
	
	}
    public EditResponse addBezahlmethode(@WebParam(name="Sessionid") int session,@WebParam(name="email") String email,
    		@WebParam(name="addBezmeth") Bezahlmethode bezmeth){
		EditResponse edit = new EditResponse();
		
		 try {
			 Session Nsession = getSession(session);
		   		Kunde kunde = dao.findKundebyEmail(email);
					if (kunde != null) {
						kunde.addBezahlmethoden(bezmeth);
						edit.setSuccessful(true);
					}
					else {
						throw new NichtVorhandenException("Kunde ist nicht vorhanden");
					}
				}
				catch (OnlineIntegrationExceptions e) {
					edit.setReturnCode(e.getErrorCode());
					edit.setMessage(e.getMessage());
				}
	 	  
		  return edit;
		
		
	}
    public EditResponse regisKunde(@WebParam(name="Sessionid") int session,
    		@WebParam(name="email") String Email,
    		@WebParam(name="Passwort") String kpassword,
    		@WebParam(name="Nachname")String knachname,
    		@WebParam(name="Vorname")String kvorname,
    		@WebParam(name="Strasse")String strasse,
    		@WebParam(name="PLZ")PLZ kplz,
    		@WebParam(name="fsn")String fsn,
    		@WebParam(name="pan")String pan){
		EditResponse up = new EditResponse();
		
		 try {
			 Session Nsession = getSession(session);
		   		
		   		Kunde k = dao.findKundebyEmail(Email);
				
					if (k == null) {
						k = new Kunde();
						k.setEmail(Email);
						k.setKpassword(kpassword);
						k.setKvorname(kvorname);
						k.setKnachname(knachname);
						k.setStrasse(strasse);
						k.setKplz(kplz);
						k.setFsnummer(fsn);
						k.setPan(pan);
						up.setSuccessful(true);
					}
					else {
						
						throw new NichtVorhandenException("Kunde ist nicht vorhanden");
					}
				}
				catch (OnlineIntegrationExceptions e) {
					up.setReturnCode(e.getErrorCode());
					up.setMessage(e.getMessage());
				}
			   
		  
		  
		  return up;
    }
    
}
