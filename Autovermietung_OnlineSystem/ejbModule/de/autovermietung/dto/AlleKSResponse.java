package de.autovermietung.dto;

import java.util.List;

public class AlleKSResponse extends ReturncodeResponse {

	private static final long serialVersionUID = -3173158310918408228L;
	private List<Object[]> ks;
	
	public AlleKSResponse(){
		
	}

	public List<Object[]> getKs() {
		return ks;
	}

	public void setKs(List<Object[]> ks) {
		this.ks = ks;
	}




	
}
