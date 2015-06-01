package de.autovermietung.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Auto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int aid;
	@Column(nullable=false)
	private String position;
	@Column(nullable=false)
	private String bez;
	
	@ManyToOne(optional=false)
	private Autoart autoart;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="auto") 
	private List<mieten> gemietet;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="auto") 
	private List<Schaden> schaden;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="auto")
	private List<Bewertung> bewertungen;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="auto") 
	private List<Dreck> dreck;
	
	public Auto(){
		
	
	}
	
	
	public Auto( String position, String bez, Autoart autoart) {
		super();
		this.position = position;
		this.bez = bez;
		this.autoart = autoart;
		this.gemietet = new ArrayList<>();
		this.schaden = new ArrayList<>();
		this.bewertungen = new ArrayList<>();
		this.dreck = new ArrayList<>();
	}
	
	public void addMieten(mieten miet){
		gemietet.add(miet);
	}
	public void addSchaden(Schaden schaden){
		this.schaden.add(schaden);
	}
	public void addBewertung(Bewertung bewertung){
		this.bewertungen.add(bewertung);
	}
	public void addDreck(Dreck dreck){
		this.dreck.add(dreck);
	}

	



	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public String getBez() {
		return bez;
	}


	public void setBez(String bez) {
		this.bez = bez;
	}


	public Autoart getAutoart() {
		return autoart;
	}


	public void setAutoart(Autoart autoart) {
		this.autoart = autoart;
	}


	public List<Schaden> getSchaden() {
		return schaden;
	}


	public void setSchaden(List<Schaden> schaden) {
		this.schaden = schaden;
	}


	public List<Bewertung> getBewertungen() {
		return bewertungen;
	}


	public void setBewertungen(List<Bewertung> bewertungen) {
		this.bewertungen = bewertungen;
	}


	public List<Dreck> getDreck() {
		return dreck;
	}


	public void setDreck(List<Dreck> dreck) {
		this.dreck = dreck;
	}


	public int getAid() {
		return aid;
	}


	public void setGemietet(List<mieten> gemietet) {
		this.gemietet = gemietet;
	}


	public List<mieten> getGemietet() {
		return gemietet;
	}

	
	
}
