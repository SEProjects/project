package de.autovermietung.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class PLZ implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String plz;
	
	private String Wohnort;

	private List<Kunde> kunden;
	
	public PLZ(){
		
	}
	

	public PLZ(String plz, String wohnort) {
		super();
		this.plz = plz;
		Wohnort = wohnort;
		this.kunden = new ArrayList<>();
	}


	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getWohnort() {
		return Wohnort;
	}

	public void setWohnort(String wohnort) {
		Wohnort = wohnort;
	}

	public List<Kunde> getKunden() {
		return kunden;
	}

	public void setKunden(List< Kunde> kunden) {
		this.kunden = kunden;
	}
	public void addKunde(Kunde kunde){
		kunden.add(kunde);
	}
	

	




}
