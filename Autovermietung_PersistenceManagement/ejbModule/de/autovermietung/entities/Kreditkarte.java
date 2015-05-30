package de.autovermietung.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Kreditkarte extends Bezahlmethode implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(nullable=false)
	private String Kartentyp;
	@Column(nullable=false)
	private int KKnummer;
	@Column(nullable=false)
	private int Ablaufdatum;
	@Column(nullable=false)
	private int KPN;
	public Kreditkarte(){
	
	}
	
	public Kreditkarte(String kartentyp, int kKnummer, int ablaufdatum, int kPN,Kunde kunde) {
		super(kunde);
		Kartentyp = kartentyp;
		KKnummer = kKnummer;
		Ablaufdatum = ablaufdatum;
		KPN = kPN;
	}

	public String getKartentyp() {
		return Kartentyp;
	}
	public void setKartentyp(String kartentyp) {
		Kartentyp = kartentyp;
	}
	public int getKKnummer() {
		return KKnummer;
	}
	public void setKKnummer(int kKnummer) {
		KKnummer = kKnummer;
	}
	public int getAblaufdatum() {
		return Ablaufdatum;
	}
	public void setAblaufdatum(int ablaufdatum) {
		Ablaufdatum = ablaufdatum;
	}
	public int getKPN() {
		return KPN;
	}
	public void setKPN(int kPN) {
		KPN = kPN;
	}


}
