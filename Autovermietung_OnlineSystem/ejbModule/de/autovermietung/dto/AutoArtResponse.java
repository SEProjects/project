package de.autovermietung.dto;

import java.math.BigDecimal;

// TODO: Auto-generated Javadoc
/**
 * @author Kevin Haase
 *  Responseklasse für den Aufruf getAA
 * {@link de.autovermietung.onlineSystem.OnlineAdminIntegration#getAA(int, int) getAA}
 */
public class AutoArtResponse extends ReturncodeResponse {
	
	/** Autoart ID */
	private int aaid;
	
	/** Die Beschreibung. */
	private String beschreibung;
	
	/** Ps. */
	private int ps;
	
	/** Sitzanzahl. */
	private int sitzanzahl;
	
	/** Kofferraumvolumen. */
	private int kofferraumvolumen;
	
	/** Bildlink. */
	private String bildlink;
	
	/** Kraftstoffverbrauch. */
	private double kraftstoffverbrauch;
	
	/** Preis je KM */
	private BigDecimal pjk; 
	
	/** Markenid. */
	private int marke;
	
	/** KraftstoffArt ID */
	private int ks;
	
	/**
	 * Instantiates a new auto art response.
	 */
	public AutoArtResponse() {	}
	
	/**
	 * Liefert  AutoartID.
	 *
	 * @return  aaid
	 */
	public int getAaid() {
		return aaid;
	}
	
	/**
	 * Setzt Autoartid in der Response.
	 *
	 * @param aaid  neue AutoartID
	 */
	public void setAaid(int aaid) {
		this.aaid = aaid;
	}
	
	/**
	 * Gets Beschreibung.
	 *
	 * @return Beschreibung
	 */
	public String getBeschreibung() {
		return beschreibung;
	}
	
	/**
	 * Sets Beschreibung in der Response.
	 *
	 * @param beschreibung neue Beschreibung der Response
	 */
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	
	/**
	 * Gets PS.
	 *
	 * @return  ps
	 */
	public int getPs() {
		return ps;
	}
	
	/**
	 * Sets  ps in der Response.
	 *
	 * @param ps neue ps
	 */
	public void setPs(int ps) {
		this.ps = ps;
	}
	
	/**
	 * Gets  sitzanzahl.
	 *
	 * @return  sitzanzahl
	 */
	public int getSitzanzahl() {
		return sitzanzahl;
	}
	
	/**
	 * Sets  sitzanzahl in der Response.
	 *
	 * @param sitzanzahl neue sitzanzahl
	 */
	public void setSitzanzahl(int sitzanzahl) {
		this.sitzanzahl = sitzanzahl;
	}
	
	/**
	 * Gets  kofferraumvolumen.
	 *
	 * @return  kofferraumvolumen
	 */
	public int getKofferraumvolumen() {
		return kofferraumvolumen;
	}
	
	/**
	 * Sets kofferraumvolumen in der Response.
	 *
	 * @param kofferraumvolumen neuer kofferraumvolumen
	 */
	public void setKofferraumvolumen(int kofferraumvolumen) {
		this.kofferraumvolumen = kofferraumvolumen;
	}
	
	/**
	 * Gets  bildlink .
	 *
	 * @return bildlink
	 */
	public String getBildlink() {
		return bildlink;
	}
	
	/**
	 * Sets  bildlink in der Response.
	 *
	 * @param bildlink neue bildlink
	 */
	public void setBildlink(String bildlink) {
		this.bildlink = bildlink;
	}
	
	/**
	 * Gets  kraftstoffverbrauch .
	 *
	 * @return  kraftstoffverbrauch
	 */
	public double getKraftstoffverbrauch() {
		return kraftstoffverbrauch;
	}
	
	/**
	 * Sets  kraftstoffverbrauch in der Response.
	 *
	 * @param kraftstoffverbrauch neue kraftstoffverbrauch
	 */
	public void setKraftstoffverbrauch(double kraftstoffverbrauch) {
		this.kraftstoffverbrauch = kraftstoffverbrauch;
	}
	
	/**
	 * Gets Preis je KM.
	 *
	 * @return pjk
	 */
	public BigDecimal getPjk() {
		return pjk;
	}
	
	/**
	 * Sets Preis je KM.
	 *
	 * @param pjk neue pjk
	 */
	public void setPjk(BigDecimal pjk) {
		this.pjk = pjk;
	}
	
	/**
	 * Gets Kraftstoffid.
	 *
	 * @return  ks
	 */
	public int getKs() {
		return ks;
	}
	
	/**
	 * Sets Kraftstoffid in der Response.
	 *
	 * @param ks neue ksid
	 */
	public void setKs(int ks) {
		this.ks = ks;
	}
	
	/**
	 * Gets MarkenID.
	 *
	 * @return  marke
	 */
	public int getMarke() {
		return marke;
	}
	
	/**
	 * Sets Marke in der Response.
	 *
	 * @param marke neue marke
	 */
	public void setMarke(int marke) {
		this.marke = marke;
	}
	
	
}
