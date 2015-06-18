package de.autovermietung.onlineSystem;

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
import de.autovermietung.dto.AutoResponse;
import de.autovermietung.dto.EditResponse;
import de.autovermietung.dto.KundeResponse;
import de.autovermietung.dto.KundenLoginResponse;
import de.autovermietung.dto.RechnungsResponse;
import de.autovermietung.dto.ReturncodeResponse;
import de.autovermietung.entities.Auto;
import de.autovermietung.entities.Bezahlmethode;
import de.autovermietung.entities.Kunde;
import de.autovermietung.entities.PLZ;
import de.autovermietung.entities.Rechnung;
import de.autovermietung.entities.Session;
import de.autovermietung.exceptions.InvalidLoginException;
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
 			}
 			else {
 				
 				throw new KundeNichtVorhandenException("Kunde nicht vorhanden");
 			}
 		}
 		catch (OnlineIntegrationExceptions e) {
 			kr.setReturnCode(e.getErrorCode());
 			kr.setMessage(e.getMessage());
 		}
     	
     	
     	return kr;
     
     }
    
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
					}
					else {
						
						throw new NichtVorhandenException("Auto ist nicht vorhanden");
					}
				}
				catch (OnlineIntegrationExceptions e) {
					ar.setReturnCode(e.getErrorCode());
					ar.setMessage(e.getMessage());
				}
			   
		  
		  
		  return ar;
		
		
	}
    
    private Session getSession(int Id) throws SessionabgelaufenException, KeineSessioException{
 	   Session session = dao.findSessionbyId(Id);
 	   if(session == null )
 		   throw new KeineSessioException("Bitte loggen Sie sich zuerst ein.");
 	   else
 	   {
 		   Date created  = session.getTimestamp();
 		   long startTime = created.getTime();
 			long jetzt = new Date().getTime();
 			long seconds=jetzt-startTime;
 		   
 		   logger.info(seconds*0.001);
 		   if(seconds > 300000){
 			   dao.deleteSession(session);
 			   throw new SessionabgelaufenException("Ihre Session ist leider abgelaufen. Bitte loggen sie sich erneurt ein");
 		   }		   
 		   else
 		   {
 		   
 			   session.updateTimestamp();
 			   return session;
 		   }
 	      
 	   }
  	   
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
}
