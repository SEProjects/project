package de.autovermietung.onlineSystem;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.jboss.logging.Logger;

import de.autovermietung.dao.AutovermietungDAOAdminLocal;
import de.autovermietung.dao.Databuilder;
import de.autovermietung.dto.KundenLoginResponse;
import de.autovermietung.entities.Kunde;

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
    
    public KundenLoginResponse Adminlogin(String email, String password)   {
       	logger.info(email + " " + password);
    	
    	
		try {
			Kunde user = this.dao.findKundebyEmail(email);		
			if (user != null && user.getKpassword().equals(password)) {
				
				
			}
			else {
				
				throw new InvalidLoginException("Login fehlgeschlagen, da Kunde unbekannt oder Passwort falsch. username=");
			}
		}
		catch (InvalidLoginException e) {

		}
		return null;
	
    	/**
    	Kunde kunde = dao.findKundebyEmail(email);
    	if(kunde.getKpassword() == password)
    	{
    		
    		return new KundenLoginResponse();
    	}
    	else
    	return null;
    	*/
    }
    public  KundenLoginResponse test(String email){
    	KundenLoginResponse KLR = new KundenLoginResponse();
    	KLR.setSessionId(2);
    	return KLR;
    }
    
    
    private HttpSession findSession(){
    	MessageContext mc = wsContext.getMessageContext();
    	Object request= mc.get(MessageContext.SERVLET_REQUEST);
    	return ((HttpServletRequest) request).getSession();
    }

}
