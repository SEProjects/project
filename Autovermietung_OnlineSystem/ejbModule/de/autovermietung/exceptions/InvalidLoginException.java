package de.autovermietung.exceptions;

// TODO: Auto-generated Javadoc
/**
* @author Kevin Haase
 * Wird von bei falschen Logindaten geworfen
 */
public class InvalidLoginException extends OnlineIntegrationExceptions {
	
	/** serialVersionUID. */
	private static final long serialVersionUID = 8759021636475023682L;
	
	/** errorCode. */
	private static final int errorCode = 20;

	/**
	 * Instantiates a new invalid login exception.
	 *
	 * @param message message
	 */
	public InvalidLoginException(String message) {
		super(errorCode,message);
	}


	

	/* (non-Javadoc)
	 * @see de.autovermietung.exceptions.OnlineIntegrationExceptions#getErrorCode()
	 */
	public int getErrorCode() {
		return errorCode;
	}


}
