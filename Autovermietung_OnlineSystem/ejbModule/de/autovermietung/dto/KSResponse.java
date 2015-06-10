package de.autovermietung.dto;

import javax.persistence.Column;

public class KSResponse extends ReturncodeResponse {
	private int ksid;
	private String bezeichnung;
	public KSResponse(){
		
	}
	public int getKsid() {
		return ksid;
	}
	public void setKsid(int ksid) {
		this.ksid = ksid;
	}
	public String getBezeichnung() {
		return bezeichnung;
	}
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	
}
