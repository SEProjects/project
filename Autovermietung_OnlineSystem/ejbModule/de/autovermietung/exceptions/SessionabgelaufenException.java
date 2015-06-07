package de.autovermietung.exceptions;

public class SessionabgelaufenException extends OnlineIntegrationExceptions{
	
	private static final long serialVersionUID = 8759021636475023682L;
	private static final int errorCode = 10;

	public SessionabgelaufenException(String message) {
		super(errorCode,message);
	}


	

	public int getErrorCode() {
		return errorCode;
	}
}
