package de.autovermietung.dto;

import java.math.BigDecimal;

// TODO: Auto-generated Javadoc
/**
* @author Kevin Haase
 *  Responseklasse für den Aufruf  {@link de.autovermietung.onlineSystem.OnlineAdminIntegration#getRechnungsRabatt(int, int) getRechnungsRabatt}
 */
public class RechnungsrabattResponse extends ReturncodeResponse {

	/** Rabatt in Prozent*/	
	private BigDecimal rabatt;
	
	/**
	 * Instantiates a new rechnungsrabatt response.
	 */
	public RechnungsrabattResponse(){
		
	}

	/**
	 * Gets  rabatt.
	 *
	 * @return rabatt
	 */
	public BigDecimal getRabatt() {
		return rabatt;
	}

	/**
	 * Sets rabatt in der Response.
	 *
	 * @param rabatt neuer rabatt
	 */
	public void setRabatt(BigDecimal rabatt) {
		this.rabatt = rabatt;
	}
	
	
	

}
