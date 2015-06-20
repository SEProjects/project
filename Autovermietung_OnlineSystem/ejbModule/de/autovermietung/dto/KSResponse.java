package de.autovermietung.dto;

import javax.persistence.Column;

// TODO: Auto-generated Javadoc
/**
 * The Class KSResponse.
 */
public class KSResponse extends ReturncodeResponse {
	
	/** The ksid. */
	private int ksid;
	
	/** The bezeichnung. */
	private String bezeichnung;
	
	/**
	 * Instantiates a new KS response.
	 */
	public KSResponse(){
		
	}
	
	/**
	 * Gets the ksid.
	 *
	 * @return the ksid
	 */
	public int getKsid() {
		return ksid;
	}
	
	/**
	 * Sets the ksid.
	 *
	 * @param ksid the new ksid
	 */
	public void setKsid(int ksid) {
		this.ksid = ksid;
	}
	
	/**
	 * Gets the bezeichnung.
	 *
	 * @return the bezeichnung
	 */
	public String getBezeichnung() {
		return bezeichnung;
	}
	
	/**
	 * Sets the bezeichnung.
	 *
	 * @param bezeichnung the new bezeichnung
	 */
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	
}
