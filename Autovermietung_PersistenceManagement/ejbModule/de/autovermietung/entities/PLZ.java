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
	public PLZ(String pLZ, String wohnort, Map<Integer, Kunde> kunden) {
		super();
		PLZ = pLZ;
		Wohnort = wohnort;
		Kunden = kunden;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	private String PLZ;
	@Column(nullable=false)
	private String Wohnort;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="Kplz") @MapKey
	private Map<Integer,Kunde> Kunden;
	
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



	public Map<Integer, Kunde> getKunden() {
		return Kunden;
	}



	public void setKunden(Map<Integer, Kunde> kunden) {
		Kunden = kunden;
	}



	public String getWohnort() {
		return Wohnort;
	}

	public void setWohnort(String wohnort) {
		Wohnort = wohnort;
	}


}
