package de.autovermietung.dto;

import de.autovermietung.entities.Kunde;



// TODO: Auto-generated Javadoc
/**
  * @author Kevin Haase
 *  Responseklasse für den Aufruf  {@link de.autovermietung.onlineSystem.OnlineAdminIntegration#Adminlogin(String, String) Adminlogin}
 */
public class KundenLoginResponse extends ReturncodeResponse {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3173158310918408228L;

	/** Sessionid */
	private int session;
	
	/**
	 * Instantiates a new kunden login response.
	 */
	public KundenLoginResponse(){
		
		
	}

	/**
	 * Gets sessionid.
	 *
	 * @return the session
	 */
	public int getSession() {
		return session;
	}

	/**
	 * Sets session in der Response.
	 *
	 * @param session neue session
	 */
	public void setSession(int session) {
		this.session = session;
	}




}
