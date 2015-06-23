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
// TODO: Auto-generated Javadoc

/**
 * @author Kevin Haase
 * The Class PLZ.
 */
@Entity
public class PLZ implements Serializable{
	

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The plz. */
	@Id 
	private String plz;
	
	/** The Wohnort. */
	@Column(nullable=false)
	private String Wohnort;
	
	/** The kunden. */
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="kplz") @MapKey
	private List<Kunde> kunden;
	
	/**
	 * Instantiates a new plz.
	 */
	public PLZ(){
		
	}
	

	/**
	 * Instantiates a new plz.
	 *
	 * @param plz the plz
	 * @param wohnort the wohnort
	 */
	public PLZ(String plz, String wohnort) {
		super();
		this.plz = plz;
		Wohnort = wohnort;
		this.kunden = new ArrayList<>();
	}


	/**
	 * Gets the plz.
	 *
	 * @return the plz
	 */
	public String getPlz() {
		return plz;
	}

	/**
	 * Sets the plz.
	 *
	 * @param plz the new plz
	 */
	public void setPlz(String plz) {
		this.plz = plz;
	}

	/**
	 * Gets the wohnort.
	 *
	 * @return the wohnort
	 */
	public String getWohnort() {
		return Wohnort;
	}

	/**
	 * Sets the wohnort.
	 *
	 * @param wohnort the new wohnort
	 */
	public void setWohnort(String wohnort) {
		Wohnort = wohnort;
	}

	/**
	 * Gets the kunden.
	 *
	 * @return the kunden
	 */
	public List<Kunde> getKunden() {
		return kunden;
	}

	/**
	 * Sets the kunden.
	 *
	 * @param kunden the new kunden
	 */
	public void setKunden(List< Kunde> kunden) {
		this.kunden = kunden;
	}
	
	/**
	 * Adds the kunde.
	 *
	 * @param kunde the kunde
	 */
	public void addKunde(Kunde kunde){
		kunden.add(kunde);
	}
	

	




}
