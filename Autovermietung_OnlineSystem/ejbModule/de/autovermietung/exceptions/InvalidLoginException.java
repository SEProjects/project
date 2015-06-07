package de.autovermietung.exceptions;

public class InvalidLoginException extends OnlineIntegrationExceptions {
	private static final long serialVersionUID = 8759021636475023682L;
	private static final int errorCode = 20;

	public InvalidLoginException(String message) {
		super(errorCode,message);
	}


	

	public int getErrorCode() {
		return errorCode;
	}


}
