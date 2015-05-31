package de.autovermietung.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Schaden implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int Sid;
	@ManyToOne(optional=false)
	private Kunde kunde;
	@ManyToOne(optional=false)
	private Auto auto;
	private String Beschreibung;
	private Date Time;
	public Schaden(){
		
	}
	
	public Schaden(Kunde kunde, Auto auto, String beschreibung, Date time) {
		super();
		this.kunde = kunde;
		this.auto = auto;
		Beschreibung = beschreibung;
		Time = time;
	}

	public int getSid() {
		return Sid;
	}
	public void setSid(int sid) {
		Sid = sid;
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
		return Beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		Beschreibung = beschreibung;
	}
	public Date getTime() {
		return Time;
	}
	public void setTime(Date time) {
		Time = time;
	}
		
}
