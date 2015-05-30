package de.autovermietung.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;



@Entity
public class Autoart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int Aaid;
	@Column(nullable=false)
	private String Beschreibung;
	private int PS;
	private int Sitzanzahl;
	private int Kofferraumvolumen;
	private String Bildlink;
	private double Kraftstoffverbrauch;
	@Column(nullable=false)
	private BigDecimal PJK; 
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="autoart") @MapKey
	private Map<Integer,Auto> Autos;

	@ManyToOne(optional = false)
	private Kraftstoff KS;
	@ManyToOne(optional = false)
	private Marke marke;
	
	public Autoart()
	{
		
	}
	
	
	public Autoart(String beschreibung, int pS, int sitzanzahl,
			int kofferraumvolumen, String bildlink, double kraftstoffverbrauch,
			BigDecimal pJK,  Kraftstoff kS, Marke marke) {
		super();
		Beschreibung = beschreibung;
		PS = pS;
		Sitzanzahl = sitzanzahl;
		Kofferraumvolumen = kofferraumvolumen;
		Bildlink = bildlink;
		Kraftstoffverbrauch = kraftstoffverbrauch;
		PJK = pJK;
		Autos = new HashMap<>();
		KS = kS;
		this.marke = marke;
	}


	public Marke getMarke() {
		return marke;
	}


	public void setMarke(Marke marke) {
		this.marke = marke;
	}


	public BigDecimal getPJK() {
		return PJK;
	}


	public void setPJK(BigDecimal pJK) {
		PJK = pJK;
	}


	public String getBeschreibung() {
		return Beschreibung;
	}


	public void setBeschreibung(String beschreibung) {
		Beschreibung = beschreibung;
	}


	public int getPS() {
		return PS;
	}


	public void setPS(int pS) {
		PS = pS;
	}


	public int getSitzanzahl() {
		return Sitzanzahl;
	}


	public void setSitzanzahl(int sitzanzahl) {
		Sitzanzahl = sitzanzahl;
	}


	public int getKofferraumvolumen() {
		return Kofferraumvolumen;
	}


	public void setKofferraumvolumen(int kofferraumvolumen) {
		Kofferraumvolumen = kofferraumvolumen;
	}


	public int getAaid() {
		return Aaid;
	}


	public void setAaid(int aaid) {
		Aaid = aaid;
	}


	public Map<Integer, Auto> getAutos() {
		return Autos;
	}


	public void setAutos(Map<Integer, Auto> autos) {
		Autos = autos;
	}


	public Kraftstoff getKS() {
		return KS;
	}


	public void setKS(Kraftstoff kS) {
		KS = kS;
	}


	


	public String getBildlink() {
		return Bildlink;
	}


	public void setBildlink(String bildlink) {
		Bildlink = bildlink;
	}


	public double getKraftstoffverbrauch() {
		return Kraftstoffverbrauch;
	}


	public void setKraftstoffverbrauch(double kraftstoffverbrauch) {
		Kraftstoffverbrauch = kraftstoffverbrauch;
	}
	

	
}
