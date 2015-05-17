package de.fhm.autovermietung.session;


import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import de.fhm.autovermietung.client.Kunde;

/**
 * Session Bean implementation class Session
 */
@Stateless
public class Session {
	 @Resource private WebServiceContext wsContext;
    /**
     * Default constructor. 
     */
    public Session() {
        // TODO Auto-generated constructor stub
    }
   
    private HttpSession findSession() {
    MessageContext mc = wsContext.getMessageContext();
    Object request = mc.get(MessageContext.SERVLET_REQUEST);
    return ((HttpServletRequest)request).getSession();
    }
    public Kunde getKunde()
    {
    	HttpSession session = findSession();
    	Kunde ku = (Kunde) session.getAttribute("kunde");
    	return ku;
        	    }
}
