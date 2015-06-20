package de.autovermietung.dto;

// TODO: Auto-generated Javadoc
/**
 * The Class neuerEintragResponse.
 */
public class neuerEintragResponse extends ReturncodeResponse {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3173158310918408228L;
	
	/** The successful. */
	private boolean successful; 
	
	/**
	 * Instantiates a new neuer eintrag response.
	 */
	public neuerEintragResponse(){
		
	}
	
	/**
	 * Checks if is successful.
	 *
	 * @return true, if is successful
	 */
	public boolean isSuccessful() {
		return successful;
	}
	
	/**
	 * Sets the successful.
	 *
	 * @param successful the new successful
	 */
	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}
	
}
