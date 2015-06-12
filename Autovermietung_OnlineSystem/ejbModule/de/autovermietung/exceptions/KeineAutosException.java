package de.autovermietung.exceptions;


public class KeineAutosException extends OnlineIntegrationExceptions {
	private static final long serialVersionUID = 8759021636475023682L;
	private static final int errorCode = 14;

	public KeineAutosException(String message) {
		super(errorCode,message);
	}


	

	public int getErrorCode() {
		return errorCode;
	}
	

}
