package de.autovermietung.dto;

import de.autovermietung.entities.FSA;
import de.autovermietung.entities.PLZ;

// TODO: Auto-generated Javadoc
/**
 * The Class KundeResponse.
 */
public class KundeResponse extends ReturncodeResponse {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3173158310918408228L;
	
	/** The email. */
	private String email;
		
	/** The kvorname. */
	private String kvorname;
	
	/** The knachname. */
	private String knachname;
	
	/** The fsnummer. */
	private String fsnummer;
	
	/** The pan. */
	private String pan;
	
	/** The straße. */
	private String straße;

	/** The saf. */
	private boolean saf;
	
	/** The admin. */
	private boolean admin;
	//Objekt FSA
	/** The fsa name. */
	private String fsaName;
	//Objekt PLZ
	/** The plz. */
	private String plz;
	
	/** The wohnort. */
	private String wohnort;

	/**
	 * Instantiates a new kunde response.
	 */
	public KundeResponse() { }
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the kvorname.
	 *
	 * @return the kvorname
	 */
	public String getKvorname() {
		return kvorname;
	}
	
	/**
	 * Sets the kvorname.
	 *
	 * @param kvorname the new kvorname
	 */
	public void setKvorname(String kvorname) {
		this.kvorname = kvorname;
	}
	
	/**
	 * Gets the knachname.
	 *
	 * @return the knachname
	 */
	public String getKnachname() {
		return knachname;
	}
	
	/**
	 * Sets the knachname.
	 *
	 * @param knachname the new knachname
	 */
	public void setKnachname(String knachname) {
		this.knachname = knachname;
	}

	/**
	 * Gets the fsnummer.
	 *
	 * @return the fsnummer
	 */
	public String getFsnummer() {
		return fsnummer;
	}
	
	/**
	 * Sets the fsnummer.
	 *
	 * @param fsnummer the new fsnummer
	 */
	public void setFsnummer(String fsnummer) {
		this.fsnummer = fsnummer;
	}
	
	/**
	 * Gets the pan.
	 *
	 * @return the pan
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
	
	/**
	 * Gets the straße.
	 *
	 * @return the straße
	 */
	public String getStraße() {
		return this.straße;
	}
	
	/**
	 * Sets the straße.
	 *
	 * @param straße the new straße
	 */
	public void setStraße(String straße) {
		this.straße = straße;
	}

	/**
	 * Checks if is saf.
	 *
	 * @return true, if is saf
	 */
	public boolean isSaf() {
		return saf;
	}
	
	/**
	 * Sets the saf.
	 *
	 * @param saf the new saf
	 */
	public void setSaf(boolean saf) {
		this.saf = saf;
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
	 * Gets the fsa name.
	 *
	 * @return the fsa name
	 */
	public String getFsaName() {
		return this.fsaName;
	}
	
	/**
	 * Sets the fsa name.
	 *
	 * @param fsaName the new fsa name
	 */
	public void setFsaName(String fsaName) {
		this.fsaName = fsaName;
	}

	/**
	 * Gets the plz.
	 *
	 * @return the plz
	 */
	public String getPlz() {
		return this.plz;
	}
	
	/**
	 * Sets the plz.
	 *
	 * @param plz the new plz
	 */
	public void setPlz(String plz) {
		this.plz = plz;
	}
	
	/**
	 * Gets the wohnort.
	 *
	 * @return the wohnort
	 */
	public String getWohnort() {
		return this.wohnort;
	}
	
	/**
	 * Sets the wohnort.
	 *
	 * @param wohnort the new wohnort
	 */
	public void setWohnort(String wohnort) {
		this.wohnort = wohnort;
	}
}
