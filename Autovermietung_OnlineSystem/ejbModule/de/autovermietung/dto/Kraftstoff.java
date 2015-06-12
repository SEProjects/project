package de.autovermietung.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Kraftstoff implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int ksid;
	
	private String ksbezeichnung;
	
	private List<Autoart> autoart;
	public Kraftstoff(){
	
	}
	public Kraftstoff(String ksbezeichnung) {
		super();
		this.ksbezeichnung = ksbezeichnung;
		this.autoart = new ArrayList<>();
	}
	public void addAutoart(Autoart autoart){
		this.autoart.add(autoart);
	}
	public String getKsbezeichnung() {
		return ksbezeichnung;
	}
	public void setKsbezeichnung(String ksbezeichnung) {
		this.ksbezeichnung = ksbezeichnung;
	}
	public List<Autoart> getAutoart() {
		return autoart;
	}
	public void setAutoart(List<Autoart> autoart) {
		this.autoart = autoart;
	}
	public int getKsid() {
		return ksid;
	}
	
	
}
