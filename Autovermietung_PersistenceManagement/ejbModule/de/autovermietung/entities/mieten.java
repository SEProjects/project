package de.autovermietung.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class mieten implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int mid;
	@Column(nullable=false)
	private double anfangskm;
	private double endkm;
	
	
	@ManyToOne(optional=false)
	private Auto auto;
	
	@ManyToOne(optional=false)
	private Kunde kunde;





	@ManyToOne()
	private Rechnung rechnung;
	private BigDecimal diff;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP",nullable=false,updatable = false, insertable = false)
	private Date timestamp;
	private boolean abgerechnet;
	
	public boolean isAbgerechnet() {
		return abgerechnet;
	}
	public BigDecimal getDiff() {
		return diff;
	}



	public void setDiff(BigDecimal diff) {
		this.diff = diff;
	}




	public void setAbgerechnet(boolean abgerechnet) {
		this.abgerechnet = abgerechnet;
	}






	public mieten(){
		
	}



	public mieten(double anfangskm, Auto auto, Kunde kunde) {
		super();
		this.anfangskm = anfangskm;
	
		this.auto = auto;
		this.kunde = kunde;
	
		
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
		this.diff = new BigDecimal(endkm).subtract(new BigDecimal(anfangskm));
	
		
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



	
	
	public Date getTimestamp() {
		return timestamp;
	}
	
}
