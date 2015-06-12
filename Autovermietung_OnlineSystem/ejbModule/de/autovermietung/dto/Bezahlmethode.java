package de.autovermietung.dto;

import java.io.Serializable;

public class Bezahlmethode implements Serializable{
	/**
	 * 
	 */
	
	private int bmid;
	private static final long serialVersionUID = 1L;

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
