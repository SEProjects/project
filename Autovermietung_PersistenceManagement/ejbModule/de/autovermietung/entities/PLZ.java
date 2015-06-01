package de.autovermietung.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
	private String plz;
	@Column(nullable=false)
	private String Wohnort;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="kplz") @MapKey
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
