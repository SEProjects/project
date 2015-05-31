package de.autovermietung.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Bewertung implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int Bid;
	@ManyToOne(optional=false)
	private Kunde kunde;
	@ManyToOne(optional=false)
	private Auto auto;
	private int Note;
	private Date Time;
	public Bewertung(){
		
	}
	public Bewertung(int bid, Kunde kunde, Auto auto, int note, Date time) {
		super();
		Bid = bid;
		this.kunde = kunde;
		this.auto = auto;
		Note = note;
		Time = time;
	}
	public int getBid() {
		return Bid;
	}
	public void setBid(int bid) {
		Bid = bid;
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
		return Note;
	}
	public void setNote(int note) {
		Note = note;
	}
	public Date getTime() {
		return Time;
	}
	public void setTime(Date time) {
		Time = time;
	}
	
}
