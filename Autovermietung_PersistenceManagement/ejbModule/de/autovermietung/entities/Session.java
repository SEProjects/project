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
 * The Class Session.
 */
@Entity
public class Session implements Serializable  {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The kunde. */
	@ManyToOne(optional=false)
	private Kunde kunde;
	
	/** The sid. */
	@Id @GeneratedValue
	private int sid;

	/** The timestamp. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP",nullable=false,insertable = false)
	private Date timestamp;
	
	/**
	 * Instantiates a new session.
	 */
	public Session(){
		
	}
	
	/**
	 * Instantiates a new session.
	 *
	 * @param kunde the kunde
	 */
	public Session(Kunde kunde) {
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
	 * Gets the sid.
	 *
	 * @return the sid
	 */
	public int getSid() {
		return sid;
	}
	
	/**
	 * Sets the sid.
	 *
	 * @param sid the new sid
	 */
	public void setSid(int sid) {
		this.sid = sid;
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
	 * Update timestamp.
	 */
	public void updateTimestamp(){
		
		Date jetzt = new Date();
		timestamp = jetzt;
	}
	
	
	
	
}
