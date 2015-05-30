package de.autovermietung.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Bezahlmethode implements Serializable{
	/**
	 * 
	 */
	@Id @GeneratedValue
	private int BMid;
	private static final long serialVersionUID = 1L;
	@ManyToOne(optional=false)
	private Kunde kunde;
	
	public Bezahlmethode(){
		
	}

	public Bezahlmethode( Kunde kunde) {
		super();
		
		this.kunde = kunde;
	}

	public int getBMid() {
		return BMid;
	}

	public void setBMid(int bMid) {
		BMid = bMid;
	}

	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	
}
