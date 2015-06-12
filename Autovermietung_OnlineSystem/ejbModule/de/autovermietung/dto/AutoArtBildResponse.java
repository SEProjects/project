package de.autovermietung.dto;

public class AutoArtBildResponse extends ReturncodeResponse {
	private String Bild;
	public AutoArtBildResponse(){
		
	}
	public String getBild() {
		return Bild;
	}
	public void setBild(String bild) {
		Bild = bild;
	}
	
}
