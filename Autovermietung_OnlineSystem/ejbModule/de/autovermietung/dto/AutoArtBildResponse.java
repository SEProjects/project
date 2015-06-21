package de.autovermietung.dto;


/**
 * @author Kevin Haase
 * Responseklasse für den Aufruf getAABild
 * {@link de.autovermietung.onlineSystem.OnlineAdminIntegration#getAABild(int, int) getAABild}
 */
public class AutoArtBildResponse extends ReturncodeResponse {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** Bild als Base64 encoded Bytestring */
	private String bild;
	
	/**
	 * Instantiates a new auto art bild response.
	 */
	public AutoArtBildResponse(){
		
	}
	
	/**
	 * leifert das Bild als Base64 encoded Bytestring.
	 *
	 * @return  bild
	 */
	public String getBild() {
		return bild;
	}
	
	/**
	 * Sets  bild in der Response .
	 *
	 * @param bild neues bild
	 */
	public void setBild(String bild) {
		this.bild = bild;
	}
	
}
