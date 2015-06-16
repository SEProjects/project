package de.autovermietung.dto;

import de.autovermietung.entities.Kunde;



public class KundenLoginResponse extends ReturncodeResponse {

	private static final long serialVersionUID = -3173158310918408228L;

	private int session;
	
	
	public KundenLoginResponse(){
		
		
	}

	public int getSession() {
		return session;
	}

	public void setSession(int session) {
		this.session = session;
	}




}
