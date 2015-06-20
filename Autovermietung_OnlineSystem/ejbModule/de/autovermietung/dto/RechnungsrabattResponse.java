package de.autovermietung.dto;

import java.math.BigDecimal;

// TODO: Auto-generated Javadoc
/**
 * The Class RechnungsrabattResponse.
 */
public class RechnungsrabattResponse extends ReturncodeResponse {

	/** The rabatt. */
	private BigDecimal rabatt;
	
	/**
	 * Instantiates a new rechnungsrabatt response.
	 */
	public RechnungsrabattResponse(){
		
	}

	/**
	 * Gets the rabatt.
	 *
	 * @return the rabatt
	 */
	public BigDecimal getRabatt() {
		return rabatt;
	}

	/**
	 * Sets the rabatt.
	 *
	 * @param rabatt the new rabatt
	 */
	public void setRabatt(BigDecimal rabatt) {
		this.rabatt = rabatt;
	}
	
	
	

}
