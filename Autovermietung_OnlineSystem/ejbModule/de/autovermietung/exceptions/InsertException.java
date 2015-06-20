package de.autovermietung.exceptions;


// TODO: Auto-generated Javadoc
/**
 * @author Kevin Haase
 * Wird von allen Savemethoden geworfen
 */
public class InsertException extends OnlineIntegrationExceptions {
	
	/** serialVersionUID. */
	private static final long serialVersionUID = 8759021636475023682L;
	
	/**  errorCode. */
	private static final int errorCode = 21;

	/**
	 * Instantiates a new insert exception.
	 *
	 * @param message the message
	 */
	public InsertException(String message) {
		super(errorCode,message);
	}


	

	/* (non-Javadoc)
	 * @see de.autovermietung.exceptions.OnlineIntegrationExceptions#getErrorCode()
	 */
	public int getErrorCode() {
		return errorCode;
	}
	
}
