package de.autovermietung.dto;

// TODO: Auto-generated Javadoc
/**
 * @author Kevin Haase
 * Responseklasse für den Aufruf für alle save Aufrufe
 * @see de.autovermietung.onlineSystem.OnlineAdminIntegration#saveAA(int, int, String, int, String, int, int, double, int, int)
 * @see de.autovermietung.onlineSystem.OnlineAdminIntegration#saveAABild(int, int, String)
 * @see de.autovermietung.onlineSystem.OnlineAdminIntegration#saveAuto(int, int, String, int)
 * @see de.autovermietung.onlineSystem.OnlineAdminIntegration#saveKS(int, int, String)
 * @see de.autovermietung.onlineSystem.OnlineAdminIntegration#saveKunde(int, String, String, String, String, String, boolean, boolean)
 * @see de.autovermietung.onlineSystem.OnlineAdminIntegration#saveMarke(int, int, String)
 * @see de.autovermietung.onlineSystem.OnlineAdminIntegration#saveRechnungsRabatt(int, int, double)
  */
public class EditResponse extends ReturncodeResponse {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3173158310918408228L;
	
	/** Speichert ob Erfolgreich als true oder false */
	private boolean successful; 
	
	/**
	 * Instantiates a new edits the response.
	 */
	public EditResponse(){
		
	}
	
	/**
	 * Checks if is successful.
	 *
	 * @return true, if Edit is successful
	 */
	public boolean isSuccessful() {
		return successful;
	}
	
	/**
	 * Sets  successful.
	 *
	 * @param successful the new successful
	 */
	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}
	
}
