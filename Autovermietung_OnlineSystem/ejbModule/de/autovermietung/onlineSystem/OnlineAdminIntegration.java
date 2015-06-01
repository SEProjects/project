package de.autovermietung.onlineSystem;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import de.autovermietung.dao.AutovermietungDAOAdminLocal;
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
	@EJB
	AutovermietungDAOAdminLocal dao;
	@Resource
	private WebServiceContext wsContext;
	
    public OnlineAdminIntegration() {
        // TODO Auto-generated constructor stub
    }
    
    public KundenLoginResponse Adminlogin(String email, String password)   {
    	Kunde kunde = dao.findKundebyEmail(email);
    	if(kunde.getKpassword() == password)
    	{
    		HttpSession session = findSession();
    		session.setAttribute("kunde", kunde);
    		return new KundenLoginResponse();
    	}
    	else
    	return null;
    }
    public String test(){
    	return "hello";
    }
    private HttpSession findSession(){
    	MessageContext mc = wsContext.getMessageContext();
    	Object request= mc.get(MessageContext.SERVLET_REQUEST);
    	return ((HttpServletRequest) request).getSession();
    }

}
