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
@Entity
public class Session implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne(optional=false)
	private Kunde kunde;
	@Id @GeneratedValue
	private int sid;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP",nullable=false,insertable = false)
	private Date timestamp;
	public Session(){
		
	}
	public Session(Kunde kunde) {
		super();
		this.kunde = kunde;
				
	}
	public Kunde getKunde() {
		return kunde;
	}
	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void updateTimestamp(){
		
		Date jetzt = new Date();
		timestamp = jetzt;
	}
	
	
	
	
}
