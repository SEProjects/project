package de.autovermietung.dto;

// TODO: Auto-generated Javadoc
/**
 * @author Kevin Haase
 *  Responseklasse für den Aufrufe mit Create
 * @see  de.autovermietung.onlineSystem.OnlineAdminIntegration#createAllRechungen(int)
 * @see  de.autovermietung.onlineSystem.OnlineAdminIntegration#createAuto(int, String, int)
 * @see  de.autovermietung.onlineSystem.OnlineAdminIntegration#createKS(int, String)
 * @see  de.autovermietung.onlineSystem.OnlineAdminIntegration#createMarke(int, String)
 *  @see  de.autovermietung.onlineSystem.OnlineAdminIntegration#createAA(int, String, int, String, int, int, double, int, int)
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
