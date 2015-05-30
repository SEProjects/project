package de.autovermietung.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class mieten implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int Mid;
	@Column(nullable=false)
	private double Anfangskm;
	@Column(nullable=false)
	private double Endkm;
	@Column(nullable=false)
	private BigDecimal Vorpreis;
	@Column(nullable=false)
	private BigDecimal Rabatt;
	@Column(nullable=false)
	private BigDecimal Endpreis;
	
	@ManyToOne(optional=false)
	private Auto auto;
	
	@ManyToOne(optional=false)
	private Kunde kunde;
	
	@ManyToOne(optional=false)
	private Rechnung rechnung;
	
	
	
	public mieten(){
		
	}

	public mieten(double anfangskm, double endkm, BigDecimal vorpreis,
			BigDecimal rabatt, BigDecimal endpreis, Auto auto, Kunde kunde,
			Rechnung rechnung) {
		super();
		Anfangskm = anfangskm;
		Endkm = endkm;
		Vorpreis = vorpreis;
		Rabatt = rabatt;
		Endpreis = endpreis;
		this.auto = auto;
		this.kunde = kunde;
		this.rechnung = rechnung;
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
		return Mid;
	}

	public void setMid(int mid) {
		Mid = mid;
	}

	public double getAnfangskm() {
		return Anfangskm;
	}

	public void setAnfangskm(double anfangskm) {
		Anfangskm = anfangskm;
	}

	public double getEndkm() {
		return Endkm;
	}

	public void setEndkm(double endkm) {
		Endkm = endkm;
	}

	public BigDecimal getVorpreis() {
		return Vorpreis;
	}

	public void setVorpreis(BigDecimal vorpreis) {
		Vorpreis = vorpreis;
	}

	public BigDecimal getRabatt() {
		return Rabatt;
	}

	public void setRabatt(BigDecimal rabatt) {
		Rabatt = rabatt;
	}

	public BigDecimal getEndpreis() {
		return Endpreis;
	}

	public void setEndpreis(BigDecimal endpreis) {
		Endpreis = endpreis;
	}


}
