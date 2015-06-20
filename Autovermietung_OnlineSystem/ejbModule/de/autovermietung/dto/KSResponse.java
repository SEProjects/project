package de.autovermietung.dto;

import javax.persistence.Column;

// TODO: Auto-generated Javadoc
/**
  * @author Kevin Haase
 *  Responseklasse für den Aufruf  {@link de.autovermietung.onlineSystem.OnlineAdminIntegration#getKS(int, int) getKS}
 */
public class KSResponse extends ReturncodeResponse {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** KraftstoffID. */
	private int ksid;
	
	/** Kraftstoffbezeichnung. */
	private String bezeichnung;
	
	/**
	 * Instantiates a new KS response.
	 */
	public KSResponse(){
		
	}
	
	/**
	 * Gets KraftstoffID.
	 *
	 * @return ksid
	 */
	public int getKsid() {
		return ksid;
	}
	
	/**
	 * Sets ksid in der Response.
	 *
	 * @param ksid neue ksid
	 */
	public void setKsid(int ksid) {
		this.ksid = ksid;
	}
	
	/**
	 * Gets Kraftstoffbezeichnung.
	 *
	 * @return bezeichnung
	 */
	public String getBezeichnung() {
		return bezeichnung;
	}
	
	/**
	 * Sets  Kraftstoffbezeichnung in der Response.
	 *
	 * @param bezeichnung  bezeichnung
	 */
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	
}
