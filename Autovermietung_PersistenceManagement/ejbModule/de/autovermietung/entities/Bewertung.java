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
 * The Class Bewertung.
 */
@Entity
public class Bewertung implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The bid. */
	@Id @GeneratedValue
	private int bid;
	
	/** The kunde. */
	@ManyToOne(optional=false)
	private Kunde kunde;
	
	/** The auto. */
	@ManyToOne(optional=false)
	private Auto auto;
	
	/** Note von 1 bis 3. */
	private int note;
	
	/** The timestamp. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP",nullable=false,updatable = false, insertable = false)
	private Date timestamp;
	
	/**
	 * Instantiates a new bewertung.
	 */
	public Bewertung(){
		
	}
	
	/**
	 * Instantiates a new bewertung.
	 *
	 * @param kunde the kunde
	 * @param auto the auto
	 * @param note the note
	 */
	public Bewertung(Kunde kunde, Auto auto, int note) {
		super();
		this.kunde = kunde;
		this.auto = auto;
		this.note = note;
		
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
	 * Gets the note.
	 *
	 * @return the note
	 */
	public int getNote() {
		return note;
	}
	
	/**
	 * Sets the note.
	 *
	 * @param note the new note
	 */
	public void setNote(int note) {
		this.note = note;
	}
	
	/**
	 * Gets the timestamp.
	 *
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}
	
	/**
	 * Gets the bid.
	 *
	 * @return the bid
	 */
	public int getBid() {
		return bid;
	}
	
}
