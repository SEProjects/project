package de.autovermietung.dto;


import java.util.List;

import de.autovermietung.entities.FSA;
import de.autovermietung.entities.PLZ;

// TODO: Auto-generated Javadoc
/**
 * @author Kevin Haase
 *  Responseklasse für den Aufruf  {@link de.autovermietung.onlineSystem.OnlineAdminIntegration#getKunde(int, String) getKunde}
 */
public class KundeResponse extends ReturncodeResponse {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3173158310918408228L;
	
	/** Kundenemail */
	private String email;
		
	/** Kundenvorname. */
	private String kvorname;
	
	/** Kundennachname. */
	private String knachname;
	
	/** Fuehrerscheinnummer. */
	private String fsnummer;
	
	/** Personalausweissnummer */
	private String pan;
	
	/** Straße. */
	private String strasse;

	

	private boolean aktive;
	
	/** adminrechte */
	private boolean admin;
	//Objekt FSA
	/** Fueherscheinname. */
	private String fsaName;
	//Objekt PLZ
	/** PLZ */
	private String plz;
	
	/** Wohnort. */
	private String wohnort;
	
	private List<Integer> gemietet;

	/**
	 * Instantiates a new kunde response.
	 */
	public KundeResponse() { }
	
	/**
	 * Gets Kundenemail.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets Kundenemail in der Response.
	 *
	 * @param email neue email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets Kundenvorname.
	 *
	 * @return kvorname
	 */
	public String getKvorname() {
		return kvorname;
	}
	
	/**
	 * Sets Kundenvorname in der Response.
	 *
	 * @param kvorname neuer kvorname
	 */
	public void setKvorname(String kvorname) {
		this.kvorname = kvorname;
	}
	
	/**
	 * Gets Kundennachname.
	 *
	 * @return knachname
	 */
	public String getKnachname() {
		return knachname;
	}
	
	/**
	 * Sets Kundennachname in der Response.
	 *
	 * @param knachname neuer knachname
	 */
	public void setKnachname(String knachname) {
		this.knachname = knachname;
	}

	/**
	 * Gets Führerscheinnummer.
	 *
	 * @return fsnummer
	 */
	public String getFsnummer() {
		return fsnummer;
	}
	
	/**
	 * Sets fsnummer in der Response .
	 *
	 * @param fsnummer neue fsnummer
	 */
	public void setFsnummer(String fsnummer) {
		this.fsnummer = fsnummer;
	}
	
	/**
	 * Gets Personalausweißnummer.
	 *
	 * @return pan
	 */
	public String getPan() {
		return pan;
	}
	
	/**
	 * Sets the pan.
	 *
	 * @param pan the new pan
	 */
	public void setPan(String pan) {
		this.pan = pan;
	}
	
	
	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	
	/**
	 * Checks if is admin.
	 *
	 * @return true, if is admin
	 */
	public boolean isAdmin() {
		return admin;
	}
	
	/**
	 * Sets the admin.
	 *
	 * @param admin the new admin
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	/**
	 * Gets Fueherscheinartbezeichung.
	 *
	 * @return the fsa name
	 */
	public String getFsaName() {
		return this.fsaName;
	}
	
	/**
	 * Sets fsa name in der Response.
	 *
	 * @param fsaName neuer fsa name
	 */
	public void setFsaName(String fsaName) {
		this.fsaName = fsaName;
	}

	/**
	 * Gets  plz.
	 *
	 * @return plz
	 */
	public String getPlz() {
		return this.plz;
	}
	
	/**
	 * Sets  plz in der Response.
	 *
	 * @param plz neuer plz
	 */
	public void setPlz(String plz) {
		this.plz = plz;
	}
	
	/**
	 * Gets  wohnort.
	 *
	 * @return wohnort
	 */
	public String getWohnort() {
		return this.wohnort;
	}
	
	/**
	 * Sets wohnort in der Response.
	 *
	 * @param wohnort neuer wohnort
	 */
	public void setWohnort(String wohnort) {
		this.wohnort = wohnort;
	}
	public boolean isAktive() {
		return aktive;
	}

	public void setAktive(boolean aktive) {
		this.aktive = aktive;
	}

	/**
	 * @return the gemietet
	 */
	public List<Integer> getGemietet() {
		return gemietet;
	}

	/**
	 * @param gemietet the gemietet to set
	 */
	public void setGemietet(List<Integer> gemietet) {
		this.gemietet = gemietet;
	}
}
