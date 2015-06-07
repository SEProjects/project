package de.autovermietung.dto;

import java.util.List;


public class AlleMarkenResponse extends ReturncodeResponse {

	private static final long serialVersionUID = -3173158310918408228L;
	private List<Object[]> marken;
	

	public AlleMarkenResponse(){

	}
	public List<Object[]> getMarken() {
		return marken;
	}


	public void setMarken(List<Object[]> marken) {
		this.marken = marken;
	}






}
