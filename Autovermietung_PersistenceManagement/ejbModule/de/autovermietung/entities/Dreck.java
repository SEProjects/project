package de.autovermietung.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Dreck implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int Did;
	@ManyToOne(optional=false)
	private Kunde kunde;
	@ManyToOne(optional=false)
	private Auto auto;
	private Date Time;
	public Dreck() {
		
	}
	
	public Dreck(int did, Kunde kunde, Auto auto, Date time) {
		super();
		Did = did;
		this.kunde = kunde;
		this.auto = auto;
		Time = time;
	}

	public int getDid() {
		return Did;
	}
	public void setDid(int did) {
		Did = did;
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
	public Date getTime() {
		return Time;
	}
	public void setTime(Date time) {
		Time = time;
	}
	
}
