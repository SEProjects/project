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
public class Dreck implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int did;
	@ManyToOne(optional=false)
	private Kunde kunde;
	@ManyToOne(optional=false)
	private Auto auto;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP",nullable=false,updatable = false, insertable = false)
	private Date timestamp;
	public Dreck() {
		
	}
	public Dreck( Kunde kunde, Auto auto) {
		super();
		
		this.kunde = kunde;
		this.auto = auto;
		
		
		
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
	public int getDid() {
		return did;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	
	
	
}