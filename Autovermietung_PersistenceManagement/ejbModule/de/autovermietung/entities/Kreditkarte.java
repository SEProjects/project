package de.autovermietung.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

// TODO: Auto-generated Javadoc
/**
 * @Kevin Haase
 * The Class Kreditkarte.
 */
@Entity
public class Kreditkarte extends Bezahlmethode implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The kartentyp. */
	@Column(nullable=false)
	private String kartentyp;
	
	/** The kknummer. */
	@Column(nullable=false)
	private int kknummer;
	
	/** The ablaufdatum. */
	@Column(nullable=false)
	private int ablaufdatum;
	
	/** The kpn. */
	@Column(nullable=false)
	private int kpn;
	
	/**
	 * Instantiates a new kreditkarte.
	 */
	public Kreditkarte(){
	
	}
	
	/**
	 * Instantiates a new kreditkarte.
	 *
	 * @param kartentyp the kartentyp
	 * @param kKnummer the k knummer
	 * @param ablaufdatum the ablaufdatum
	 * @param kPN the k pn
	 * @param kunde the kunde
	 */
	public Kreditkarte(String kartentyp, int kKnummer, int ablaufdatum, int kPN,Kunde kunde) {
		super(kunde);
		this.kartentyp = kartentyp;
		kknummer = kKnummer;
		this.ablaufdatum = ablaufdatum;
		kpn = kPN;
	}

	/**
	 * Gets the kartentyp.
	 *
	 * @return the kartentyp
	 */
	public String getKartentyp() {
		return kartentyp;
	}

	/**
	 * Sets the kartentyp.
	 *
	 * @param kartentyp the new kartentyp
	 */
	public void setKartentyp(String kartentyp) {
		this.kartentyp = kartentyp;
	}

	/**
	 * Gets the kknummer.
	 *
	 * @return the kknummer
	 */
	public int getKknummer() {
		return kknummer;
	}

	/**
	 * Sets the kknummer.
	 *
	 * @param kknummer the new kknummer
	 */
	public void setKknummer(int kknummer) {
		this.kknummer = kknummer;
	}

	/**
	 * Gets the ablaufdatum.
	 *
	 * @return the ablaufdatum
	 */
	public int getAblaufdatum() {
		return ablaufdatum;
	}

	/**
	 * Sets the ablaufdatum.
	 *
	 * @param ablaufdatum the new ablaufdatum
	 */
	public void setAblaufdatum(int ablaufdatum) {
		this.ablaufdatum = ablaufdatum;
	}

	/**
	 * Gets the kpn.
	 *
	 * @return the kpn
	 */
	public int getKpn() {
		return kpn;
	}

	/**
	 * Sets the kpn.
	 *
	 * @param kpn the new kpn
	 */
	public void setKpn(int kpn) {
		this.kpn = kpn;
	}
	

	
}
