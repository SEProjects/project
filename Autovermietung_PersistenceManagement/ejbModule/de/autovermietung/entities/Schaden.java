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
public class Schaden implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int sid;
	@ManyToOne(optional=false)
	private Kunde kunde;
	@ManyToOne(optional=false)
	private Auto auto;
	private String beschreibung;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP",nullable=false,updatable = false, insertable = false)
	private Date timestamp;
	public Schaden(){
		
	}
	public Schaden(Kunde kunde, Auto auto, String beschreibung) {
		super();
		this.kunde = kunde;
		this.auto = auto;
		this.beschreibung = beschreibung;
		
	
	}
	public Kunde getKunde() {
		return kunde;
	}
	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}
	public Auto getAuto() {
		return auto;
	}
	public void setAuto(Auto auto) {
		this.auto = auto;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	
	public int getSid() {
		return sid;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	
		
}
