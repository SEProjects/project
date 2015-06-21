package de.autovermietung.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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



/**
 * The Class Autoart.
 *
 * @author Kevin Haase
 * Autoart Entity
 */
@Entity
public class Autoart implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** Autoartid. */
	@Id @GeneratedValue
	private int aaid;
	
	/** Beschreibung. */
	@Column(nullable=false)
	private String beschreibung;
	
	/** Ps. */
	private int ps;
	
	/** Sitzanzahl. */
	private int sitzanzahl;
	
	/** Kofferraumvolumen. */
	private int kofferraumvolumen;
	
	/** Bild. */
	@Column(length=50000000)
	private String bildLink;
	
	/** Kraftstoffverbrauch. */
	private double kraftstoffverbrauch;
	
	/** Preis je Km. */
	@Column(nullable=false)
	private BigDecimal pjk; 
	
	/**  Autos dieser Autoart. */
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="autoart") 
	private List<Auto> autos;

	/**  Kraftstoffart. */
	@ManyToOne(optional = false)
	private Kraftstoff ks;
	
	/** Marke. */
	@ManyToOne(optional = false)
	private Marke marke;
	
	/**
	 * Instantiates a new autoart.
	 */
	public Autoart()
	{
		
	}

	/**
	 * Instantiates a new autoart.
	 *
	 * @param beschreibung Beschreibung
	 * @param ps Ps
	 * @param sitzanzahl Sitzanzahl
	 * @param kofferraumvolumen the kofferraumvolumen
	 * @param kraftstoffverbrauch the kraftstoffverbrauch
	 * @param pjk Preis je KM
	 * @param ks Kraftstoffart
	 * @param marke Marke
	 */
	public Autoart(String beschreibung, int ps, int sitzanzahl,
			int kofferraumvolumen, double kraftstoffverbrauch,
			BigDecimal pjk,  Kraftstoff ks, Marke marke) {
		super();
		this.beschreibung = beschreibung;
		this.ps = ps;
		this.sitzanzahl = sitzanzahl;
		this.kofferraumvolumen = kofferraumvolumen;
	
		this.kraftstoffverbrauch = kraftstoffverbrauch;
		this.pjk = pjk;
		this.autos = new ArrayList<>();
		this.ks = ks;
		this.marke = marke;
	}


	/**
	 * Gets the bild.
	 *
	 * @return the bild
	 */
	public String getBild() {
		return bildLink;
	}

	/**
	 * Sets the bild.
	 *
	 * @param bild the new bild
	 */
	public void setBild(String bildLink) {
		this.bildLink = bildLink;
	}

	/**
	 * Adds the auto.
	 *
	 * @param auto the auto
	 */
	public void addAuto(Auto auto){
		autos.add(auto);
	}

	/**
	 * Gets the beschreibung.
	 *
	 * @return the beschreibung
	 */
	public String getBeschreibung() {
		return beschreibung;
	}

	/**
	 * Sets the beschreibung.
	 *
	 * @param beschreibung the new beschreibung
	 */
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	/**
	 * Gets the ps.
	 *
	 * @return the ps
	 */
	public int getPs() {
		return ps;
	}

	/**
	 * Sets the ps.
	 *
	 * @param ps the new ps
	 */
	public void setPs(int ps) {
		this.ps = ps;
	}

	/**
	 * Gets the sitzanzahl.
	 *
	 * @return the sitzanzahl
	 */
	public int getSitzanzahl() {
		return sitzanzahl;
	}

	/**
	 * Sets the sitzanzahl.
	 *
	 * @param sitzanzahl the new sitzanzahl
	 */
	public void setSitzanzahl(int sitzanzahl) {
		this.sitzanzahl = sitzanzahl;
	}

	/**
	 * Gets the kofferraumvolumen.
	 *
	 * @return the kofferraumvolumen
	 */
	public int getKofferraumvolumen() {
		return kofferraumvolumen;
	}

	/**
	 * Sets the kofferraumvolumen.
	 *
	 * @param kofferraumvolumen the new kofferraumvolumen
	 */
	public void setKofferraumvolumen(int kofferraumvolumen) {
		this.kofferraumvolumen = kofferraumvolumen;
	}

	

	/**
	 * Gets the kraftstoffverbrauch.
	 *
	 * @return the kraftstoffverbrauch
	 */
	public double getKraftstoffverbrauch() {
		return kraftstoffverbrauch;
	}

	/**
	 * Sets the kraftstoffverbrauch.
	 *
	 * @param kraftstoffverbrauch the new kraftstoffverbrauch
	 */
	public void setKraftstoffverbrauch(double kraftstoffverbrauch) {
		this.kraftstoffverbrauch = kraftstoffverbrauch;
	}

	/**
	 * Gets the pjk.
	 *
	 * @return the pjk
	 */
	public BigDecimal getPjk() {
		return pjk;
	}

	/**
	 * Sets the pjk.
	 *
	 * @param pjk the new pjk
	 */
	public void setPjk(BigDecimal pjk) {
		this.pjk = pjk;
	}


	/**
	 * Gets the ks.
	 *
	 * @return the ks
	 */
	public Kraftstoff getKs() {
		return ks;
	}

	/**
	 * Sets the ks.
	 *
	 * @param ks the new ks
	 */
	public void setKs(Kraftstoff ks) {
		this.ks = ks;
	}

	/**
	 * Gets the marke.
	 *
	 * @return the marke
	 */
	public Marke getMarke() {
		return marke;
	}

	/**
	 * Sets the marke.
	 *
	 * @param marke the new marke
	 */
	public void setMarke(Marke marke) {
		this.marke = marke;
	}

	/**
	 * Gets the aaid.
	 *
	 * @return the aaid
	 */
	public int getAaid() {
		return aaid;
	}

	/**
	 * Gets the autos.
	 *
	 * @return the autos
	 */
	public List<Auto> getAutos() {
		return autos;
	}

	/**
	 * Sets the autos.
	 *
	 * @param autos the new autos
	 */
	public void setAutos(List<Auto> autos) {
		this.autos = autos;
	}
	
	
	
}
