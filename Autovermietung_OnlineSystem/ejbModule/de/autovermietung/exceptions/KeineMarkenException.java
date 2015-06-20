package de.autovermietung.exceptions;


// TODO: Auto-generated Javadoc
/**
 * @author Kevin Haase
 * Wird von getAllMarken  geworfen wenn keine Autos vorhanden
 */
public class KeineMarkenException extends OnlineIntegrationExceptions {
	
	/** SerialVersionUID. */
	private static final long serialVersionUID = 8759021636475023682L;
	
	/** errorCode. */
	private static final int errorCode = 14;

	/**
	 * Instantiates a new keine marken exception.
	 *
	 * @param message Nachricht an den Benutzer
	 */
	public KeineMarkenException(String message) {
		super(errorCode,message);
	}


	

	/* (non-Javadoc)
	 * @see de.autovermietung.exceptions.OnlineIntegrationExceptions#getErrorCode()
	 */
	public int getErrorCode() {
		return errorCode;
	}
	
}
