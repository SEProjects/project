package de.autovermietung.exceptions;

// TODO: Auto-generated Javadoc
/**
* @author Kevin Haase
 * Wird von allen Methoden geworfen wenn Session aelter als 5 minuten
 */
public class SessionabgelaufenException extends OnlineIntegrationExceptions{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8759021636475023682L;
	
	/** The Constant errorCode. */
	private static final int errorCode = 10;

	/**
	 * Instantiates a new sessionabgelaufen exception.
	 *
	 * @param message Nachricht an den Benutzer
	 */
	public SessionabgelaufenException(String message) {
		super(errorCode,message);
	}


	

	/* (non-Javadoc)
	 * @see de.autovermietung.exceptions.OnlineIntegrationExceptions#getErrorCode()
	 */
	public int getErrorCode() {
		return errorCode;
	}
}
