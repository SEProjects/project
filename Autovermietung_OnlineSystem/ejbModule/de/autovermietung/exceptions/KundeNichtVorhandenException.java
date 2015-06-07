package de.autovermietung.exceptions;


public class KundeNichtVorhandenException extends OnlineIntegrationExceptions {
	private static final long serialVersionUID = 8759021636475023682L;
	private static final int errorCode = 12;

	public KundeNichtVorhandenException(String message) {
		super(errorCode,message);
	}


	

	public int getErrorCode() {
		return errorCode;
	}
}
