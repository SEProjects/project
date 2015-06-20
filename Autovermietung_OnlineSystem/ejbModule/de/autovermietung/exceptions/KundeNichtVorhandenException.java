package de.autovermietung.exceptions;


// TODO: Auto-generated Javadoc
/**
 * @author Kevin Haase
 * Wird von getKunde geworfen wenn Kunde nicht  vorhanden
 */
public class KundeNichtVorhandenException extends OnlineIntegrationExceptions {
	
	/** SerialVersionUID. */
	private static final long serialVersionUID = 8759021636475023682L;
	
	/** ErrorCode. */
	private static final int errorCode = 12;

	/**
	 * Instantiates a new kunde nicht vorhanden exception.
	 *
	 * @param message Nachricht an den Benutzer
	 */
	public KundeNichtVorhandenException(String message) {
		super(errorCode,message);
	}


	

	/* (non-Javadoc)
	 * @see de.autovermietung.exceptions.OnlineIntegrationExceptions#getErrorCode()
	 */
	public int getErrorCode() {
		return errorCode;
	}
}
