package de.autovermietung.onlineSystem;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

import org.jboss.logging.Logger;

import de.autovermietung.dao.AutovermietungDAOAdminLocal;
import de.autovermietung.dao.Databuilder;
import de.autovermietung.dto.AutoResponse;
import de.autovermietung.dto.KundenLoginResponse;
import de.autovermietung.entities.Auto;
import de.autovermietung.entities.Kunde;
import de.autovermietung.entities.Session;
import de.autovermietung.exceptions.InvalidLoginException;
import de.autovermietung.exceptions.NichtVorhandenException;
import de.autovermietung.exceptions.OnlineIntegrationExceptions;
import de.autovermietung.util.DtoAssembler;

/**
 * Session Bean implementation class OnlineIntegration
 */
@Stateless
@WebService
public class OnlineIntegration {

	@EJB(beanName = "AutovermietungDAO", beanInterface = de.autovermietung.dao.AutovermietungDAOAdminLocal.class)
	private AutovermietungDAOAdminLocal dao;
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
    public AutoResponse getAuto(@WebParam(name="Sessionid") int session,@WebParam(name="Autoid") int autoid){
		AutoResponse ar = new AutoResponse();
		
		 try {
		   		
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
}
