package de.autovermietung.entities;

import java.io.Serializable;
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
 * @author Kevin Haase
 * The Class Schaden.
 */
@Entity
public class Schaden implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The sid. */
	@Id @GeneratedValue
	private int sid;
	
	/** The kunde. */
	@ManyToOne(optional=false)
	private Kunde kunde;
	
	/** The auto. */
	@ManyToOne(optional=false)
	private Auto auto;
	
	/** The beschreibung. */
	private String beschreibung;
	
	/** The timestamp. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP",nullable=false,updatable = false, insertable = false)
	private Date timestamp;
	
	/**
	 * Instantiates a new schaden.
	 */
	public Schaden(){
		
	}
	
	/**
	 * Instantiates a new schaden.
	 *
	 * @param kunde the kunde
	 * @param auto the auto
	 * @param beschreibung the beschreibung
	 */
	public Schaden(Kunde kunde, Auto auto, String beschreibung) {
		super();
		this.kunde = kunde;
		this.auto = auto;
		this.beschreibung = beschreibung;
		
	
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
	 * Gets the sid.
	 *
	 * @return the sid
	 */
	public int getSid() {
		return sid;
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
