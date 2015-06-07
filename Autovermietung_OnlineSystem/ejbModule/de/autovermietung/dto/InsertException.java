package de.autovermietung.dto;

import de.autovermietung.exceptions.OnlineIntegrationExceptions;

public class InsertException extends OnlineIntegrationExceptions {
	private static final long serialVersionUID = 8759021636475023682L;
	private static final int errorCode = 21;

	public InsertException(String message) {
		super(errorCode,message);
	}


	

	public int getErrorCode() {
		return errorCode;
	}
	
}
