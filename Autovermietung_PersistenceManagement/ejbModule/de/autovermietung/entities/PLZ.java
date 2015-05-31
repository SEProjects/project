package de.autovermietung.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
@Entity
public class PLZ implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	private String PLZ;
	@Column(nullable=false)
	private String Wohnort;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="Kplz") @MapKey
	private Map<String,Kunde> Kunden;
	
	public PLZ(){
		
	}

	



	public PLZ(String pLZ, String wohnort) {
		super();
		PLZ = pLZ;
		Wohnort = wohnort;
		Kunden = new HashMap<>();
	}





	public String getPLZ() {
		return PLZ;
	}



	public void setPLZ(String pLZ) {
		PLZ = pLZ;
	}





	@Override
	public String toString() {
		return "PLZ [PLZ=" + PLZ + ", Wohnort=" + Wohnort + "]";
	}





	public Map<String, Kunde> getKunden() {
		return Kunden;
	}





	public void setKunden(Map<String, Kunde> kunden) {
		Kunden = kunden;
	}





	public String getWohnort() {
		return Wohnort;
	}

	public void setWohnort(String wohnort) {
		Wohnort = wohnort;
	}


}
