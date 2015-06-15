package de.autovermietung.dto;

import java.math.BigDecimal;

public class RechnungsrabattResponse extends ReturncodeResponse {

	private BigDecimal rabatt;
	
	public RechnungsrabattResponse(){
		
	}

	public BigDecimal getRabatt() {
		return rabatt;
	}

	public void setRabatt(BigDecimal rabatt) {
		this.rabatt = rabatt;
	}
	
	
	

}
