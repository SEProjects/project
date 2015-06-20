package de.autovermietung.dto;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import de.autovermietung.entities.Auto;
import de.autovermietung.entities.Kraftstoff;
import de.autovermietung.entities.Marke;

// TODO: Auto-generated Javadoc
/**
 * The Class AutoArtResponse.
 */
public class AutoArtResponse extends ReturncodeResponse {
	
	/** The aaid. */
	private int aaid;
	
	/** The beschreibung. */
	private String beschreibung;
	
	/** The ps. */
	private int ps;
	
	/** The sitzanzahl. */
	private int sitzanzahl;
	
	/** The kofferraumvolumen. */
	private int kofferraumvolumen;
	
	/** The bildlink. */
	private String bildlink;
	
	/** The kraftstoffverbrauch. */
	private double kraftstoffverbrauch;
	
	/** The pjk. */
	private BigDecimal pjk; 
	
	/** The ks. */
	private int ks;
	
	/** The marke. */
	private int marke;
	
	/**
	 * Instantiates a new auto art response.
	 */
	public AutoArtResponse(){
		
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
	 * Sets the aaid.
	 *
	 * @param aaid the new aaid
	 */
	public void setAaid(int aaid) {
		this.aaid = aaid;
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
	 * Gets the bildlink.
	 *
	 * @return the bildlink
	 */
	public String getBildlink() {
		return bildlink;
	}
	
	/**
	 * Sets the bildlink.
	 *
	 * @param bildlink the new bildlink
	 */
	public void setBildlink(String bildlink) {
		this.bildlink = bildlink;
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
	public int getKs() {
		return ks;
	}
	
	/**
	 * Sets the ks.
	 *
	 * @param ks the new ks
	 */
	public void setKs(int ks) {
		this.ks = ks;
	}
	
	/**
	 * Gets the marke.
	 *
	 * @return the marke
	 */
	public int getMarke() {
		return marke;
	}
	
	/**
	 * Sets the marke.
	 *
	 * @param marke the new marke
	 */
	public void setMarke(int marke) {
		this.marke = marke;
	}
	
	
}
