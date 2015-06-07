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
import de.autovermietung.dto.AlleAutosResponse;
import de.autovermietung.dto.AlleKundenResponse;
import de.autovermietung.dto.AlleMarkenResponse;
import de.autovermietung.dto.InsertException;
import de.autovermietung.dto.KundeEditResponse;
import de.autovermietung.dto.KundeResponse;
import de.autovermietung.dto.KundenLoginResponse;
import de.autovermietung.dto.MarkeResponse;
import de.autovermietung.dto.UpdateResponse;
import de.autovermietung.dto.neueMarkeResponse;
import de.autovermietung.entities.Kunde;
import de.autovermietung.entities.Marke;
import de.autovermietung.entities.Session;
import de.autovermietung.exceptions.InvalidLoginException;
import de.autovermietung.exceptions.KeineAutosException;
import de.autovermietung.exceptions.KeineKundenException;
import de.autovermietung.exceptions.KeineMarkenException;
import de.autovermietung.exceptions.KeineSessioException;
import de.autovermietung.exceptions.KundeNichtVorhandenException;
import de.autovermietung.exceptions.NichtVorhandenException;
import de.autovermietung.exceptions.OnlineIntegrationExceptions;
import de.autovermietung.exceptions.SessionabgelaufenException;
import de.autovermietung.util.DtoAssembler;

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
	@EJB
	private DtoAssembler dto;
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
			
			if (kunden.isEmpty() == false) {
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
    
    public KundeResponse getKunde(@WebParam(name="Sessionid") int session,@WebParam(name="Kundeemail") String id){
       KundeResponse kr = new KundeResponse();
    	try {
    		Session Nsession = getSession(session);
			Kunde kunde = dao.findKundebyEmail(id);	
			
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
    public KundeEditResponse saveKunde(@WebParam(name="Sessionid") int session,@WebParam(name="Kundeemail") String id,
    		@WebParam(name="kvorname") String kvorname,@WebParam(name="knachname") String knachname,@WebParam(name="fsnummer") String fsnummer,
    		@WebParam(name="pan") String pan,@WebParam(name="saf") boolean saf,@WebParam(name="admin") boolean admin){
    	KundeEditResponse ker = new KundeEditResponse();
    	try {
    		Session Nsession = getSession(session);
			Kunde kunde = dao.findKundebyEmail(id);	
			
			if (kunde != null) {
				kunde.setEmail(id);
				kunde.setKvorname(kvorname);
				kunde.setKnachname(knachname);
				kunde.setFsnummer(fsnummer);
				kunde.setPan(pan);
				kunde.setSaf(saf);
				kunde.setAdmin(admin);
				ker.setSuccessful(true);
					
			}
			else {
				
				throw new KundeNichtVorhandenException("Kunde nicht vorhanden");
			}
		}
		catch (OnlineIntegrationExceptions e) {
			ker.setReturnCode(e.getErrorCode());
			ker.setMessage(e.getMessage());
			ker.setSuccessful(false);
		}
    	
    	
    	
    	
    	return ker;
    }
    public AlleAutosResponse getAllAutos(@WebParam(name="Sessionid") int session){
    	
    	AlleAutosResponse aar = new AlleAutosResponse();
    	try {
    		Session Nsession = getSession(session);
			List<Object[]> autos = this.dao.getAllAutos();	
	
			if (autos.isEmpty() == false) {
				aar.setAutos(autos);
			}
			else {
				
				throw new KeineAutosException("Es sind noch keine Autos vorhanden");
			}
		}
		catch (OnlineIntegrationExceptions e) {
			aar.setReturnCode(e.getErrorCode());
			aar.setMessage(e.getMessage());
		}
    	 	
    	
    	
    	
    	return aar;
    }
   public AlleMarkenResponse getAllMarken(@WebParam(name="Sessionid") int session){
    	
    	AlleMarkenResponse amr = new AlleMarkenResponse();
    	try {
    		Session Nsession = getSession(session);
			List<Object[]> marken = this.dao.getAllMarken();	
	
			if (marken.isEmpty() == false) {
				amr.setMarken(marken);
			}
			else {
				
				throw new KeineMarkenException("Es sind noch keine Marken vorhanden");
			}
		}
		catch (OnlineIntegrationExceptions e) {
			amr.setReturnCode(e.getErrorCode());
			amr.setMessage(e.getMessage());
		}
    	 	
    	
    	
    	
    	return amr;
    }
   public neueMarkeResponse createMarke(@WebParam(name="Sessionid") int session,@WebParam(name="Markenname") String Marke){
	   neueMarkeResponse nmr = new neueMarkeResponse();
	   try {
   		Session Nsession = getSession(session);
   		Marke marke = dao.createMarke(Marke);
			
			if (marke != null) {
				nmr.setSuccessful(true);
			}
			else {
				nmr.setSuccessful(false);
				throw new InsertException("Einfügen der Marke ist fehlgeschlagen");
			}
		}
		catch (OnlineIntegrationExceptions e) {
			nmr.setReturnCode(e.getErrorCode());
			nmr.setMessage(e.getMessage());
		}
	   
	   
	   
	   
	   
	   return nmr;  
	   
	   
   }
  public MarkeResponse getMarke(@WebParam(name="Sessionid") int session,@WebParam(name="MarkenId") int Id){
	  MarkeResponse mr = new MarkeResponse();
	  
	   try {
	   		Session Nsession = getSession(session);
	   		Marke marke = dao.findMarkebyID(Id);
				logger.info(Id);
				if (marke != null) {
					mr.setMarkeid(marke.getMarkeid());
					mr.setMarkenname(marke.getMarkenname());
				}
				else {
					
					throw new NichtVorhandenException("Die Marke ist nicht vorhanden");
				}
			}
			catch (OnlineIntegrationExceptions e) {
				mr.setReturnCode(e.getErrorCode());
				mr.setMessage(e.getMessage());
			}
		   
	  
	  
	  return mr;
  }
  public UpdateResponse saveMarke(@WebParam(name="Sessionid") int session,@WebParam(name="MarkenId") int Id,@WebParam(name="Markenname") String Marke){
	  UpdateResponse ur = new UpdateResponse();
	  try {
	   		Session Nsession = getSession(session);
	   		Marke marke = dao.findMarkebyID(Id);
				
				if (marke != null) {
					marke.setMarkenname(Marke);
					ur.setSuccessful(true);
				}
				else {
					ur.setSuccessful(false);
					throw new NichtVorhandenException("Die Marke ist nicht vorhanden");
				}
			}
			catch (OnlineIntegrationExceptions e) {
				ur.setReturnCode(e.getErrorCode());
				ur.setMessage(e.getMessage());
				ur.setSuccessful(false);
			}
		   
	  return ur;
  }

}
