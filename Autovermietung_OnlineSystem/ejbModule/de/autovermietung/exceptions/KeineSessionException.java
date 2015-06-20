package de.autovermietung.exceptions;


// TODO: Auto-generated Javadoc
/**
 * @author Kevin Haase
 * Wird von Allen Methoden  geworfen wenn keine Session vorhanden
 */
public class KeineSessionException extends OnlineIntegrationExceptions{
	
	/** SerialVersionUID. */
	private static final long serialVersionUID = 8759021636475023682L;
	
	/** ErrorCode. */
	private static final int errorCode = 10;

	/**
	 * Instantiates a new keine session exception.
	 *
	 * @param message Nachricht an den Benutzer
	 */
	public KeineSessionException(String message) {
		super(errorCode,message);
	}


	

	/* (non-Javadoc)
	 * @see de.autovermietung.exceptions.OnlineIntegrationExceptions#getErrorCode()
	 */
	public int getErrorCode() {
		return errorCode;
	}
}
