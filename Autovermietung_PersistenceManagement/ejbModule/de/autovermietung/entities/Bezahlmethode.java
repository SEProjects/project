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
	private int bmid;
	private static final long serialVersionUID = 1L;
	@ManyToOne(optional=false)
	private Kunde kunde;
	
	public Bezahlmethode(){
		
	}

	public Bezahlmethode( Kunde kunde) {
		super();
		
		this.kunde = kunde;
	}


	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	public int getBmid() {
		return bmid;
	}

	public void setBmid(int bmid) {
		this.bmid = bmid;
	}

	
}
