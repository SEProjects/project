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

import de.autovermietung.dao.AutovermietungDAOAdminLocal;
import de.autovermietung.dao.Databuilder;
import de.autovermietung.dto.AlleKundenResponse;
import de.autovermietung.dto.KundenLoginResponse;
import de.autovermietung.entities.Kunde;
import de.autovermietung.entities.Session;
import de.autovermietung.exceptions.InvalidLoginException;
import de.autovermietung.exceptions.KeineKundenException;
import de.autovermietung.exceptions.KeineSessioException;
import de.autovermietung.exceptions.OnlineIntegrationExceptions;
import de.autovermietung.exceptions.SessionabgelaufenException;

/**
 * Session Bean implementation class OnlineAdminIntegration
 */
@Stateless
@WebService
public class OnlineAdminIntegration {

    /**
     * Default constructor. 
     */
	@EJB(beanName = "AutovermietungDAO", beanInterface = de.autovermietung.dao.AutovermietungDAOAdminLocal.class)
	private AutovermietungDAOAdminLocal dao;
	@Resource
	private WebServiceContext wsContext;
	private static final Logger logger = Logger.getLogger(Databuilder.class);
    public OnlineAdminIntegration() {
        // TODO Auto-generated constructor stub
    }
    
    public KundenLoginResponse Adminlogin(@WebParam(name="email") String email, @WebParam(name="password") String password)   {
       
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
   private Session getSession(int Id) throws SessionabgelaufenException, KeineSessioException{
	   Session session = dao.findSessionbyId(Id);
	   if(session == null )
		   throw new KeineSessioException("Bitte loggen Sie sich zuerst ein.");
	   else
	   {
		   Date created  = session.getTimestamp();
		   long startTime = created.getTime() * 1000000;;
		   long estimatedTime = System.nanoTime() - startTime;
		   double seconds = (double)estimatedTime / 1000000000.0;
		   
		   if(seconds > 300){
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
    
    public String test(@WebParam(name="Sessionid") int session)   {
    	
    	try{
    	Session Nsession = getSession(session);
    	return "ja";
    	}
    	catch (OnlineIntegrationExceptions e)
    	{
    		return "nein";
    	}
    }
    public AlleKundenResponse getAllKunden(@WebParam(name="Sessionid") int session){
    	AlleKundenResponse akr = new AlleKundenResponse();
    	try {
    		Session Nsession = getSession(session);
			List<Object[]> kunden = this.dao.getAllKunden();	
			
			if (kunden != null) {
				akr.setKunden(kunden);
			}
			else {
				
				throw new KeineKundenException("Es sind noch keine Kunden vorhanden");
			}
		}
		catch (OnlineIntegrationExceptions e) {
			akr.setReturnCode(e.getErrorCode());
			akr.setMessage(e.getMessage());
		}
    	
    	
    	return akr;
    }
  

}
