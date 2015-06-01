package de.autovermietung.dto;



public class KundenLoginResponse extends ReturncodeResponse {

	private static final long serialVersionUID = -3173158310918408228L;

	private int sessionId;
	
	public KundenLoginResponse(){
		
	}

	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

}