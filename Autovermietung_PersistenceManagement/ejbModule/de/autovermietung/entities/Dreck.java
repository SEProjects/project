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
 * @Kevin Haase
 * The Class Dreck.
 */
@Entity
public class Dreck implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The did. */
	@Id @GeneratedValue
	private int did;
	
	/** The kunde. */
	@ManyToOne(optional=false)
	private Kunde kunde;
	
	/** The auto. */
	@ManyToOne(optional=false)
	private Auto auto;
	
	/** The timestamp. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP",nullable=false,updatable = false, insertable = false)
	private Date timestamp;
	
	/**
	 * Instantiates a new dreck.
	 */
	public Dreck() {
		
	}
	
	/**
	 * Instantiates a new dreck.
	 *
	 * @param kunde the kunde
	 * @param auto the auto
	 */
	public Dreck( Kunde kunde, Auto auto) {
		super();
		
		this.kunde = kunde;
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
	 * Gets the did.
	 *
	 * @return the did
	 */
	public int getDid() {
		return did;
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
