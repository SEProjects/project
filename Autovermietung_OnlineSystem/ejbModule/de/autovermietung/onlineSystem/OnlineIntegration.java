package de.autovermietung.onlineSystem;

import java.math.BigDecimal;
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

import de.autovermietung.dao.AutovermietungDAOLocal;
import de.autovermietung.dao.Databuilder;
import de.autovermietung.dto.AutoArtBildResponse;
import de.autovermietung.dto.AutoArtResponse;
import de.autovermietung.dto.AutoListResponse;
import de.autovermietung.dto.AutoResponse;
import de.autovermietung.dto.EditResponse;
import de.autovermietung.dto.KSResponse;
import de.autovermietung.dto.KundeResponse;
import de.autovermietung.dto.KundenLoginResponse;
import de.autovermietung.dto.MarkeResponse;
import de.autovermietung.dto.MietenListResponse;
import de.autovermietung.dto.MietenResponse;
import de.autovermietung.dto.RechnungsResponse;
import de.autovermietung.dto.ReturncodeResponse;
import de.autovermietung.dto.UpdateResponse;
import de.autovermietung.dto.neuerEintragResponse;
import de.autovermietung.entities.Auto;
import de.autovermietung.entities.Autoart;
import de.autovermietung.entities.Bezahlmethode;
import de.autovermietung.entities.Kraftstoff;
import de.autovermietung.entities.Kunde;
import de.autovermietung.entities.Marke;	    		
import de.autovermietung.entities.Mieten;
import de.autovermietung.entities.PLZ;
import de.autovermietung.entities.Rechnung;
import de.autovermietung.entities.Session;
import de.autovermietung.exceptions.InsertException;
import de.autovermietung.exceptions.InvalidLoginException;
import de.autovermietung.exceptions.KeineSessionException;
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
    
    private Session getSession(int Id) throws SessionabgelaufenException, KeineSessionException{
  	   Session session = dao.findSessionbyId(Id);
  	   if(session == null)
  		   throw new KeineSessionException("Bitte loggen Sie sich zuerst ein.");
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
			
			if (kunde != null && kunde.getKpassword().equals(password) ) {
				if(kunde.isAktive() == true ){
					if(kunde.getLink().equals("true")){
					Session session = dao.createSession(kunde);
					klr.setSession(session.getSid());
					}
					else
					{
						throw new InvalidLoginException("Login fehlgeschlagen, da Email noch nicht bestätigt. username=" + email + " " + password);	
					}
				}
				else
					{
					throw new InvalidLoginException("Login fehlgeschlagen, da Kunde gesperrt. username=" + email + " " + password);
					}
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
		} catch (KeineSessionException e) {
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
				List<Integer> mId = dao.getAllMietenId();
				List<Integer> mieten = new ArrayList<Integer>();
				for(int i = 0; i < mId.size(); i++) {
					Mieten m = dao.findMietenbyID(mId.get(i));
					if(m != null)
						mieten.add(m.getMid());
				}
				ar.setGemietet(mieten);
				//TODO DRECK und SCHADEN
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
	    		aar = dto.makeDTO(autoArt);
	    	}
		} catch (OnlineIntegrationExceptions e) {
			aar.setReturnCode(e.getErrorCode());
			aar.setMessage(e.getMessage());
		}
    	return aar;
    }
    
    public AutoArtBildResponse getAABild(@WebParam(name="Sessionid") int session,@WebParam(name="Aaid") int aaid){
		AutoArtBildResponse aar = new AutoArtBildResponse(); 
		 try {
		   		Session Nsession = getSession(session);
		   		Autoart aa = dao.findAutoartbyID(aaid);
				
					if (aa != null) {
						aar.setBild(aa.getBild());
					} else {
						throw new NichtVorhandenException("Die Autoart ist nicht vorhanden");
					}
				}
				catch (OnlineIntegrationExceptions e) {
					aar.setReturnCode(e.getErrorCode());
					aar.setMessage(e.getMessage());
				}
			   
		return aar;
	}
    
    public neuerEintragResponse saveMieten(@WebParam(name="Sessionid")int session, @WebParam(name="Anfangskm") double anfangskm,
    									   @WebParam(name="Autoid")int autoId, @WebParam(name="Kundeemail")String kundeEmail) {
    	neuerEintragResponse neu = new neuerEintragResponse();
    	try {
    		Session Nsession = getSession(session);
				if (dao.findAutobyID(autoId) != null && dao.findKundebyEmail(kundeEmail) != null) {
					Auto auto = dao.findAutobyID(autoId);
					Kunde kunde = dao.findKundebyEmail(kundeEmail);
			    	Mieten mieten = dao.createMieten(anfangskm, auto, kunde);
			    	
			    	if (mieten != null) {
						neu.setSuccessful(true);
					}
					else {
						neu.setSuccessful(false);
						throw new InsertException("Einfügen des Mieten ist fehlgeschlagen");
					}
				} else {
					throw new NichtVorhandenException("Kunde oder Auto nicht vorhanden");
				}
		} catch (OnlineIntegrationExceptions e) {
			neu.setReturnCode(e.getErrorCode());
			neu.setMessage(e.getMessage());
			neu.setSuccessful(false);
		}
    	return neu;
    }
    
    public MietenResponse getMieten(@WebParam(name="Sessionid")int session, @WebParam(name="Mietenid") int mid) {
    	MietenResponse mr = new MietenResponse();
    	try {
    		Session Nsession = getSession(session);
			Mieten m = dao.findMietenbyID(mid);
				if (m != null) {
					mr.setMid(mid);
					mr.setAnfangskm(m.getAnfangskm());
					mr.setEndkm(m.getEndkm());
					mr.setDiff(m.getDiff());
					mr.setAutoId(m.getAuto().getAid());
					mr.setKundeEmail(m.getKunde().getEmail());
					mr.setTimestamp(m.getTimestamp().toString());
					//TODO Rechnungen
				} else {
					throw new NichtVorhandenException("Die Miete ist nicht vorhanden");
				}
		} catch (OnlineIntegrationExceptions e) {
			mr.setReturnCode(e.getErrorCode());
			mr.setMessage(e.getMessage());
		}
    	return mr;
    }
    public MietenListResponse getAllMieten(@WebParam(name="Sessionid") int session){	
    	MietenListResponse aar = new MietenListResponse();
    	try {
    		Session sessionId = getSession(session);
    		//logger.info("Test" + dao.getAllAutos().get(0).getClass().getName());
    		List<Integer> mId = dao.getAllMietenId();
    		List<Mieten> mietenList = new ArrayList<>();
    		for(int i = 0; i < mId.size(); i++) {
    			Mieten mieten = dao.findMietenbyID(mId.get(i));
    			mietenList.add(mieten);
    		}
    		aar.setMietenList(dto.makeDto(mietenList));
		} catch (OnlineIntegrationExceptions e) {
			//logger.info("Test" + dao.getAllAutos().get(0).getClass().getName());
			aar.setReturnCode(e.getErrorCode());
			aar.setMessage(e.getMessage());
		}
    	return aar;
    }
    //TODO erst abgerechnet ohne Rechnung
    public UpdateResponse updateMieten(@WebParam(name="Sessionid")int session, @WebParam(name="Mietenid") int mid, 
    								   @WebParam(name="Endkilometer") double endKm) {
    	UpdateResponse uM = new UpdateResponse();
    	try {
    		Session Nsession = getSession(session);
			Mieten m = dao.findMietenbyID(mid);
				if (m != null) {
					m.setEndkm(endKm);
					
				
					//TODO Rechnungen
					uM.setSuccessful(true);
				} else {
					throw new NichtVorhandenException("Die Miete ist nicht vorhanden");
				}
			}
			catch (OnlineIntegrationExceptions e) {
				uM.setReturnCode(e.getErrorCode());
				uM.setMessage(e.getMessage());
				uM.setSuccessful(false);
			}
    	return uM;
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
    /*
     * Aktualisierung der Kunden Daten
     */
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
    
    /*
     * Rechnung auf bezahlt setzen
     */
    public EditResponse rechnungBezahlen(@WebParam(name="Sessionid") int session,@WebParam(name="Rechnungsid") int rid){
    	EditResponse response = new EditResponse();
		 try {
			 Session Nsession = getSession(session);
		   		
		   		Rechnung rechn = dao.findRechnungbyID(rid);
				
					if (rechn != null) {
						rechn.setBezahlt(true);
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
    /*
     * Bezahlmethode hinzufügen
     */
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
    public Kunde showKunde(@WebParam(name="Sessionid") int session, @WebParam(name="email") String Email) throws NichtVorhandenException{
    	
    	
    		Kunde k = dao.findKundebyEmail(Email);
    		
    		if(k != null){
    			k.getEmail();
    			k.getFsnummer();
    			k.getBezahlmethoden();
    			k.getGemietet();
    			k.getKnachname();
    			k.getKplz();
    			k.getKvorname();
    			k.getPan();
    			k.getRechnungen();
    			k.getStrasse();
    			k.getSchaden();
    	}
    		else {
				
				throw new NichtVorhandenException("Kunde ist nicht vorhanden");
			}
		
    	
    	
    	return k;
    	
    	}
    	
   
    /*
     * register Kunde
     */
    public EditResponse regisKunde(@WebParam(name="Sessionid") int session,
    		@WebParam(name="email") String Email,
    		@WebParam(name="Passwort") String kpassword,
    		@WebParam(name="Nachname")String knachname,
    		@WebParam(name="Vorname")String kvorname,
    		@WebParam(name="Strasse")String strasse,
    		@WebParam(name="PLZ")String kplz,
    		@WebParam(name="fsn")String fsn,
    		@WebParam(name="pan")String pan){
		EditResponse up = new EditResponse();
		
		 try {
			 Session Nsession = getSession(session);
		   		
		   		Kunde k = dao.findKundebyEmail(Email);
				
					if (k == null) {
						dao.createKunde(kvorname, knachname, Email, kpassword, fsn, pan, strasse, dao.findPlzByID(kplz));
					
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
