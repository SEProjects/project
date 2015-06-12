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

public class AutoArtResponse extends ReturncodeResponse {
	private int aaid;
	private String beschreibung;
	private int ps;
	private int sitzanzahl;
	private int kofferraumvolumen;
	private String bildlink;
	private double kraftstoffverbrauch;
	
	private BigDecimal pjk; 
	private int ks;
	private int marke;
	public AutoArtResponse(){
		
	}
	public int getAaid() {
		return aaid;
	}
	public void setAaid(int aaid) {
		this.aaid = aaid;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	public int getPs() {
		return ps;
	}
	public void setPs(int ps) {
		this.ps = ps;
	}
	public int getSitzanzahl() {
		return sitzanzahl;
	}
	public void setSitzanzahl(int sitzanzahl) {
		this.sitzanzahl = sitzanzahl;
	}
	public int getKofferraumvolumen() {
		return kofferraumvolumen;
	}
	public void setKofferraumvolumen(int kofferraumvolumen) {
		this.kofferraumvolumen = kofferraumvolumen;
	}
	public String getBildlink() {
		return bildlink;
	}
	public void setBildlink(String bildlink) {
		this.bildlink = bildlink;
	}
	public double getKraftstoffverbrauch() {
		return kraftstoffverbrauch;
	}
	public void setKraftstoffverbrauch(double kraftstoffverbrauch) {
		this.kraftstoffverbrauch = kraftstoffverbrauch;
	}
	public BigDecimal getPjk() {
		return pjk;
	}
	public void setPjk(BigDecimal pjk) {
		this.pjk = pjk;
	}
	public int getKs() {
		return ks;
	}
	public void setKs(int ks) {
		this.ks = ks;
	}
	public int getMarke() {
		return marke;
	}
	public void setMarke(int marke) {
		this.marke = marke;
	}
	
	
}
