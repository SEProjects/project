package de.autovermietung.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;

public class Bewertung implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int bid;
	
	private Kunde kunde;
	
	private Auto auto;
	private int note;
	private Date time;
	public Bewertung(){
		
	}
	public Bewertung(Kunde kunde, Auto auto, int note) {
		super();
		this.kunde = kunde;
		this.auto = auto;
		this.note = note;
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
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getBid() {
		return bid;
	}
	
}
