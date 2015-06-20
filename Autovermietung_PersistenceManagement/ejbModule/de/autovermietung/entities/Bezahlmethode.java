package de.autovermietung.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
// TODO: Auto-generated Javadoc

/**
 * The Class Bezahlmethode.
 */
@Entity
public class Bezahlmethode implements Serializable{
	
	/** The bmid. */
	@Id @GeneratedValue
	private int bmid;
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The kunde. */
	@ManyToOne(optional=false)
	private Kunde kunde;
	
	/**
	 * Instantiates a new bezahlmethode.
	 */
	public Bezahlmethode(){
		
	}

	/**
	 * Instantiates a new bezahlmethode.
	 *
	 * @param kunde the kunde
	 */
	public Bezahlmethode( Kunde kunde) {
		super();
		
		this.kunde = kunde;
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
	 * Gets the bmid.
	 *
	 * @return the bmid
	 */
	public int getBmid() {
		return bmid;
	}

	/**
	 * Sets the bmid.
	 *
	 * @param bmid the new bmid
	 */
	public void setBmid(int bmid) {
		this.bmid = bmid;
	}


	
}
