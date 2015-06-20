package de.autovermietung.dto;


// TODO: Auto-generated Javadoc
/**
* @author Kevin Haase
 *  Responseklasse für den Aufrufe mit Save
 *   @see de.autovermietung.onlineSystem.OnlineAdminIntegration#saveAA(int, int, String, int, String, int, int, double, int, int)
 *   @see de.autovermietung.onlineSystem.OnlineAdminIntegration#saveAABild(int, int, String)
 *   @see de.autovermietung.onlineSystem.OnlineAdminIntegration#saveAuto(int, int, String, int)
 *   @see de.autovermietung.onlineSystem.OnlineAdminIntegration#saveKS(int, int, String)
 *   @see de.autovermietung.onlineSystem.OnlineAdminIntegration#saveKunde(int, String, String, String, String, String, boolean, boolean)
 *   @see de.autovermietung.onlineSystem.OnlineAdminIntegration#saveMarke(int, int, String)
 *   @see de.autovermietung.onlineSystem.OnlineAdminIntegration#saveRechnungsRabatt(int, int, double)
 */
public class UpdateResponse extends ReturncodeResponse {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3173158310918408228L;
	
	/** successful true if succesfull */
	private boolean successful; 
	
	/**
	 * Instantiates a new update response.
	 */
	public UpdateResponse(){
		
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
