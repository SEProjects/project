package de.autovermietung.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;

public class Schaden implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int sid;

	private Kunde kunde;
	
	private Auto auto;
	private String beschreibung;
	private Date time;
	public Schaden(){
		
	}
	public Schaden(Kunde kunde, Auto auto, String beschreibung, Date time) {
		super();
		this.kunde = kunde;
		this.auto = auto;
		this.beschreibung = beschreibung;
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
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getSid() {
		return sid;
	}
	
	
		
}
