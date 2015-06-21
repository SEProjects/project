package de.autovermietung.dto;

public class DeleteResponse extends ReturncodeResponse {
	
private static final long serialVersionUID = -3173158310918408228L;
	
	/** successful true if succesfull */
	private boolean successful; 
	
	/**
	 * Instantiates a new delete response.
	 */
	public DeleteResponse(){
		
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
