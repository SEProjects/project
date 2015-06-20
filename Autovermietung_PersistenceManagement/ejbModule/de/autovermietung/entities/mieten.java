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

// TODO: Auto-generated Javadoc
/**
 * The Class mieten.
 */
@Entity
public class mieten implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The mid. */
	@Id @GeneratedValue
	private int mid;
	
	/** The anfangskm. */
	@Column(nullable=false)
	private double anfangskm;
	
	/** The endkm. */
	private double endkm;
	
	
	/** The auto. */
	@ManyToOne(optional=false)
	private Auto auto;
	
	/** The kunde. */
	@ManyToOne(optional=false)
	private Kunde kunde;





	/** The rechnung. */
	@ManyToOne()
	private Rechnung rechnung;
	
	/** The diff. */
	private BigDecimal diff;
	
	/** The timestamp. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP",nullable=false,updatable = false, insertable = false)
	private Date timestamp;
	
	/** The abgerechnet. */
	private boolean abgerechnet;
	
	/**
	 * Checks if is abgerechnet.
	 *
	 * @return true, if is abgerechnet
	 */
	public boolean isAbgerechnet() {
		return abgerechnet;
	}
	
	/**
	 * Gets the diff.
	 *
	 * @return the diff
	 */
	public BigDecimal getDiff() {
		return diff;
	}



	/**
	 * Sets the diff.
	 *
	 * @param diff the new diff
	 */
	public void setDiff(BigDecimal diff) {
		this.diff = diff;
	}




	/**
	 * Sets the abgerechnet.
	 *
	 * @param abgerechnet the new abgerechnet
	 */
	public void setAbgerechnet(boolean abgerechnet) {
		this.abgerechnet = abgerechnet;
	}






	/**
	 * Instantiates a new mieten.
	 */
	public mieten(){
		
	}



	/**
	 * Instantiates a new mieten.
	 *
	 * @param anfangskm the anfangskm
	 * @param auto the auto
	 * @param kunde the kunde
	 */
	public mieten(double anfangskm, Auto auto, Kunde kunde) {
		super();
		this.anfangskm = anfangskm;
	
		this.auto = auto;
		this.kunde = kunde;
	
		
	}



	/**
	 * Gets the anfangskm.
	 *
	 * @return the anfangskm
	 */
	public double getAnfangskm() {
		return anfangskm;
	}



	/**
	 * Sets the anfangskm.
	 *
	 * @param anfangskm the new anfangskm
	 */
	public void setAnfangskm(double anfangskm) {
		this.anfangskm = anfangskm;
	}



	/**
	 * Gets the endkm.
	 *
	 * @return the endkm
	 */
	public double getEndkm() {
		return endkm;
	}



	/**
	 * Sets the endkm.
	 *
	 * @param endkm the new endkm
	 */
	public void setEndkm(double endkm) {
		this.endkm = endkm;
		this.diff = new BigDecimal(endkm).subtract(new BigDecimal(anfangskm));
	
		
	}




	/**
	 * Gets the auto.
	 *
	 * @return the auto
	 */
	public Auto getAuto() {
		return auto;
	}



	/**
	 * Sets the auto.
	 *
	 * @param auto the new auto
	 */
	public void setAuto(Auto auto) {
		this.auto = auto;
	}



	/**
	 * Gets the kunde.
	 *
	 * @return the kunde
	 */
	public Kunde getKunde() {
		return kunde;
	}



	/**
	 * Sets the kunde.
	 *
	 * @param kunde the new kunde
	 */
	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}



	/**
	 * Gets the rechnung.
	 *
	 * @return the rechnung
	 */
	public Rechnung getRechnung() {
		return rechnung;
	}



	/**
	 * Sets the rechnung.
	 *
	 * @param rechnung the new rechnung
	 */
	public void setRechnung(Rechnung rechnung) {
		this.rechnung = rechnung;
	}



	/**
	 * Gets the mid.
	 *
	 * @return the mid
	 */
	public int getMid() {
		return mid;
	}



	
	
	/**
	 * Gets the timestamp.
	 *
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}
	
}
