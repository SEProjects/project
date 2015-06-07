package de.autovermietung.dto;

import java.util.List;


public class AlleAutosResponse extends ReturncodeResponse {

	private static final long serialVersionUID = -3173158310918408228L;
	private List<Object[]> autos;
	
	
	public AlleAutosResponse(){

	}


	public List<Object[]> getAutos() {
		return autos;
	}


	public void setAutos(List<Object[]> autos) {
		this.autos = autos;
	}



}
