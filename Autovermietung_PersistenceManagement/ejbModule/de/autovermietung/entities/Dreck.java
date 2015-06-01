package de.autovermietung.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Dreck implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int did;
	@ManyToOne(optional=false)
	private Kunde kunde;
	@ManyToOne(optional=false)
	private Auto auto;
	private Date time;
	public Dreck() {
		
	}
	public Dreck( Kunde kunde, Auto auto, Date time) {
		super();
		
		this.kunde = kunde;
		this.auto = auto;
		Calendar currenttime = Calendar.getInstance();
		 this.time = new Date((currenttime.getTime()).getTime());
		
		
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
	public Date getTime() {
		return time;
	}
	
	
}
