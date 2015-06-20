package de.autovermietung.exceptions;


// TODO: Auto-generated Javadoc
/**
 * The Class KeineSessioException.
 */
public class KeineSessioException extends OnlineIntegrationExceptions{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8759021636475023682L;
	
	/** The Constant errorCode. */
	private static final int errorCode = 10;

	/**
	 * Instantiates a new keine sessio exception.
	 *
	 * @param message the message
	 */
	public KeineSessioException(String message) {
		super(errorCode,message);
	}


	

	/* (non-Javadoc)
	 * @see de.autovermietung.exceptions.OnlineIntegrationExceptions#getErrorCode()
	 */
	public int getErrorCode() {
		return errorCode;
	}
}
