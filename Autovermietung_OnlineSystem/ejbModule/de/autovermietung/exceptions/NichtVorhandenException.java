package de.autovermietung.exceptions;


// TODO: Auto-generated Javadoc
/**
 * @author Kevin Haase
 * Wird von allen Methoden geworfen eine Entity nicht vorhanden ist
 */
public class NichtVorhandenException extends OnlineIntegrationExceptions {
	
	/** SerialVersionUID. */
	private static final long serialVersionUID = 8759021636475023682L;
	
	/** ErrorCode. */
	private static final int errorCode = 12;

	/**
	 * Instantiates a new nicht vorhanden exception.
	 *
	 * @param message Nachricht an den Benutzer
	 */
	public NichtVorhandenException(String message) {
		super(errorCode,message);
	}


	

	/* (non-Javadoc)
	 * @see de.autovermietung.exceptions.OnlineIntegrationExceptions#getErrorCode()
	 */
	public int getErrorCode() {
		return errorCode;
	}
}
