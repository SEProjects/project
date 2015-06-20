package de.autovermietung.exceptions;

// TODO: Auto-generated Javadoc
/**
* @author Kevin Haase
 * Wird von getAllKunden  geworfen wenn keine Autos vorhanden
 */
public class KeineKundenException extends OnlineIntegrationExceptions {
	
	/** serialVersionUID. */
	private static final long serialVersionUID = 8759021636475023682L;
	
	/**  errorCode. */
	private static final int errorCode = 15;

	/**
	 * Instantiates a new keine kunden exception.
	 *
	 * @param message tNachricht an den Benutzer
	 */
	public KeineKundenException(String message) {
		super(errorCode,message);
	}


	

	/* (non-Javadoc)
	 * @see de.autovermietung.exceptions.OnlineIntegrationExceptions#getErrorCode()
	 */
	public int getErrorCode() {
		return errorCode;
	}
}
