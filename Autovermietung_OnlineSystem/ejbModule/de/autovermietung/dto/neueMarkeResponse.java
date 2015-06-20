package de.autovermietung.dto;


// TODO: Auto-generated Javadoc
/**
 * The Class neueMarkeResponse.
 */
public class neueMarkeResponse extends ReturncodeResponse {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3173158310918408228L;
	
	/** The successful. */
	private boolean successful; 
	
	/**
	 * Instantiates a new neue marke response.
	 */
	public neueMarkeResponse(){
		
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
