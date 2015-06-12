package de.autovermietung.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;

public class mieten implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int mid;
	
	private double anfangskm;
	private double endkm;
	private BigDecimal vorpreis;
	private BigDecimal rabatt;
	private BigDecimal endpreis;
	private Auto auto;
	private Kunde kunde;
	private Rechnung rechnung;
	private Date zeit;
	
	public mieten(){
		
	}



	public mieten(double anfangskm, Auto auto, Kunde kunde) {
		super();
		this.anfangskm = anfangskm;
	
		this.auto = auto;
		this.kunde = kunde;
	
		Calendar currenttime = Calendar.getInstance();
	    this.zeit = new Date((currenttime.getTime()).getTime());

	}



	public double getAnfangskm() {
		return anfangskm;
	}



	public void setAnfangskm(double anfangskm) {
		this.anfangskm = anfangskm;
	}



	public double getEndkm() {
		return endkm;
	}



	public void setEndkm(double endkm) {
		this.endkm = endkm;
	}



	public BigDecimal getVorpreis() {
		return vorpreis;
	}



	public void setVorpreis(BigDecimal vorpreis) {
		this.vorpreis = vorpreis;
	}



	public BigDecimal getRabatt() {
		return rabatt;
	}



	public void setRabatt(BigDecimal rabatt) {
		this.rabatt = rabatt;
	}



	public BigDecimal getEndpreis() {
		return endpreis;
	}



	public void setEndpreis(BigDecimal endpreis) {
		this.endpreis = endpreis;
	}



	public Auto getAuto() {
		return auto;
	}



	public void setAuto(Auto auto) {
		this.auto = auto;
	}



	public Kunde getKunde() {
		return kunde;
	}



	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}



	public Rechnung getRechnung() {
		return rechnung;
	}



	public void setRechnung(Rechnung rechnung) {
		this.rechnung = rechnung;
	}



	public int getMid() {
		return mid;
	}



	public Date getZeit() {
		return zeit;
	}
	
	
	
}
