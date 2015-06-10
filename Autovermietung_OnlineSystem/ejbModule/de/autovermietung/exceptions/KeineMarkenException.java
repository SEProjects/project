package de.autovermietung.exceptions;


public class KeineMarkenException extends OnlineIntegrationExceptions {
	private static final long serialVersionUID = 8759021636475023682L;
	private static final int errorCode = 14;

	public KeineMarkenException(String message) {
		super(errorCode,message);
	}


	

	public int getErrorCode() {
		return errorCode;
	}
	
}