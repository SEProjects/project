package de.autovermietung.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



// TODO: Auto-generated Javadoc
/**
 * The Class Auto.
 *
 * @author Kevin Haase
 * Entity Auto.
 */
@Entity
public class Auto implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** Autoid. */
	@Id @GeneratedValue
	private int aid;
	
	/** Position. */
	@Column(nullable=false)
	private String position;
	
	/** Bezeichung. */
	@Column(nullable=false)
	private String bez;
	
	/** Autoart. */
	@ManyToOne(optional=false)
	private Autoart autoart;
	
	/** Gemietet. */
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="auto") 
	private List<mieten> gemietet;
	
	/** Schaden. */
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="auto") 
	private List<Schaden> schaden;
	
	/** Bewertungen. */
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="auto")
	private List<Bewertung> bewertungen;
	
	/** Dreck. */
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="auto") 
	private List<Dreck> dreck;
	
	/**
	 * Instantiates a new auto.
	 */
	public Auto(){
		
	
	}
	
	
	/**
	 * Instantiates a new auto.
	 *
	 * @param position des Autos
	 * @param bez Bezeichnung des Autos
	 * @param autoart Autoart
	 */
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
	
	/**
	 * Adds Mieten.
	 *
	 * @param miet mieten object
	 */
	public void addMieten(mieten miet){
		gemietet.add(miet);
	}
	
	/**
	 * Adds the schaden.
	 *
	 * @param schaden schadenobject
	 */
	public void addSchaden(Schaden schaden){
		this.schaden.add(schaden);
	}
	
	/**
	 * Adds the bewertung.
	 *
	 * @param bewertung object
	 */
	public void addBewertung(Bewertung bewertung){
		this.bewertungen.add(bewertung);
	}
	
	/**
	 * Adds the dreck.
	 *
	 * @param dreck Dreck object
	 */
	public void addDreck(Dreck dreck){
		this.dreck.add(dreck);
	}

	



	/**
	 * Gets the position.
	 *
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}


	/**
	 * Sets the position.
	 *
	 * @param position the new position
	 */
	public void setPosition(String position) {
		this.position = position;
	}


	/**
	 * Gets the bez.
	 *
	 * @return the bez
	 */
	public String getBez() {
		return bez;
	}


	/**
	 * Sets the bez.
	 *
	 * @param bez the new bez
	 */
	public void setBez(String bez) {
		this.bez = bez;
	}


	/**
	 * Gets the autoart.
	 *
	 * @return the autoart
	 */
	public Autoart getAutoart() {
		return autoart;
	}


	/**
	 * Sets the autoart.
	 *
	 * @param autoart the new autoart
	 */
	public void setAutoart(Autoart autoart) {
		this.autoart = autoart;
	}


	/**
	 * Gets the schaden.
	 *
	 * @return the schaden
	 */
	public List<Schaden> getSchaden() {
		return schaden;
	}


	/**
	 * Sets the schaden.
	 *
	 * @param schaden the new schaden
	 */
	public void setSchaden(List<Schaden> schaden) {
		this.schaden = schaden;
	}


	/**
	 * Gets the bewertungen.
	 *
	 * @return the bewertungen
	 */
	public List<Bewertung> getBewertungen() {
		return bewertungen;
	}


	/**
	 * Sets the bewertungen.
	 *
	 * @param bewertungen the new bewertungen
	 */
	public void setBewertungen(List<Bewertung> bewertungen) {
		this.bewertungen = bewertungen;
	}


	/**
	 * Gets the dreck.
	 *
	 * @return the dreck
	 */
	public List<Dreck> getDreck() {
		return dreck;
	}


	/**
	 * Sets the dreck.
	 *
	 * @param dreck the new dreck
	 */
	public void setDreck(List<Dreck> dreck) {
		this.dreck = dreck;
	}


	/**
	 * Gets the aid.
	 *
	 * @return the aid
	 */
	public int getAid() {
		return aid;
	}


	/**
	 * Sets the gemietet.
	 *
	 * @param gemietet the new gemietet
	 */
	public void setGemietet(List<mieten> gemietet) {
		this.gemietet = gemietet;
	}


	/**
	 * Gets the gemietet.
	 *
	 * @return the gemietet
	 */
	public List<mieten> getGemietet() {
		return gemietet;
	}

	
	
}
