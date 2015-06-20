package de.autovermietung.dto;

import de.autovermietung.entities.Kunde;



// TODO: Auto-generated Javadoc
/**
 * The Class KundenLoginResponse.
 */
public class KundenLoginResponse extends ReturncodeResponse {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3173158310918408228L;

	/** The session. */
	private int session;
	
	/**
	 * Instantiates a new kunden login response.
	 */
	public KundenLoginResponse(){
		
		
	}

	/**
	 * Gets the session.
	 *
	 * @return the session
	 */
	public int getSession() {
		return session;
	}

	/**
	 * Sets the session.
	 *
	 * @param session the new session
	 */
	public void setSession(int session) {
		this.session = session;
	}




}
