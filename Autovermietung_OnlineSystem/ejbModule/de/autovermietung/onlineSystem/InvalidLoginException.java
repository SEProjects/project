package de.autovermietung.onlineSystem;

public class InvalidLoginException extends Exception {
	private static final long serialVersionUID = 8759021636475023682L;
	private static final int errorCode = 20;

	public InvalidLoginException(String message) {
		super(message);
	}


	

	public int getErrorCode() {
		return errorCode;
	}


}
