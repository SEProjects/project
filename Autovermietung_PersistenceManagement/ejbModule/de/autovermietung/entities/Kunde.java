package de.autovermietung.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

// TODO: Auto-generated Javadoc
/**
 * The Class Kunde.
 */
@Entity
public class Kunde implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The email. */
	@Id
	private String email;
	
	/** The kvorname. */
	@Column(nullable=false)
	private String kvorname;
	
	/** The knachname. */
	@Column(nullable=false)
	private String knachname;
	
	/** The kpassword. */
	@Column(nullable=false)
	private String kpassword;
	
	/** The fsnummer. */
	@Column(nullable=false,unique=true)
	private String fsnummer;
	
	/** The pan. */
	@Column(nullable=false,unique=true)
	private String pan;

	
	/** The strasse. */
	@Column(nullable=false)
	private String strasse;
	
	/** The link. */
	private String link;

	/** The saf. */
	private boolean saf;
	
	/** The admin. */
	private boolean admin;
	
	/** The aktive. */
	private boolean aktive;
	
	/** The gemietet. */
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="kunde") @MapKey
	private List<mieten> gemietet;
	
	/** The rechnungen. */
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="kunde") @MapKey
	private List<Rechnung> rechnungen;
	
	/** The bezahlmethoden. */
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="kunde") @MapKey
	private List<Bezahlmethode> bezahlmethoden;
	
	/** The schaden. */
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="kunde") @MapKey
	private List<Schaden> schaden;
	
	/** The bewertungen. */
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="kunde") @MapKey
	private List<Bewertung> bewertungen;
	
	/** The dreck. */
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="kunde") @MapKey
	private List<Dreck> dreck;

	/** The fsa. */
	@ManyToOne(optional=false)
	private FSA fsa;
	
	/** The kplz. */
	@ManyToOne(optional=false)
	private PLZ kplz;
	
	
	/**
	 * Instantiates a new kunde.
	 */
	public Kunde(){
		
		
	}


	/**
	 * Instantiates a new kunde.
	 *
	 * @param email the email
	 * @param kvorname the kvorname
	 * @param knachname the knachname
	 * @param kpassword the kpassword
	 * @param fsnummer the fsnummer
	 * @param pan the pan
	 * @param strasse the strasse
	 * @param saf the saf
	 * @param admin the admin
	 * @param fsa the fsa
	 * @param kplz the kplz
	 */
	public Kunde(String email, String kvorname, String knachname,
			String kpassword, String fsnummer, String pan, String strasse,
			boolean saf, boolean admin, FSA fsa, PLZ kplz) {
		super();
		this.email = email;
		this.kvorname = kvorname;
		this.knachname = knachname;
		this.kpassword = kpassword;
		this.fsnummer = fsnummer;
		this.pan = pan;
		this.strasse = strasse;
		this.saf = saf;
		this.admin = admin;
		this.gemietet = new ArrayList<>();
		this.rechnungen = new ArrayList<>();
		this.bezahlmethoden = new ArrayList<>();
		this.schaden = new ArrayList<>();
		this.bewertungen = new ArrayList<>();
		this.dreck = new ArrayList<>();
		this.fsa = fsa;
		this.kplz = kplz;
		this.link = Integer.toString(this.hashCode());
	}


	/**
	 * Gets the link.
	 *
	 * @return the link
	 */
	public String getLink() {
		return link;
	}


	/**
	 * Sets the link.
	 *
	 * @param link the new link
	 */
	public void setLink(String link) {
		this.link = link;
	}


	/**
	 * Checks if is aktive.
	 *
	 * @return true, if is aktive
	 */
	public boolean isAktive() {
		return aktive;
	}


	/**
	 * Sets the aktive.
	 *
	 * @param aktive the new aktive
	 */
	public void setAktive(boolean aktive) {
		this.aktive = aktive;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (admin ? 1231 : 1237);
		result = prime * result + (aktive ? 1231 : 1237);
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((fsnummer == null) ? 0 : fsnummer.hashCode());
		result = prime * result
				+ ((knachname == null) ? 0 : knachname.hashCode());
		result = prime * result
				+ ((kpassword == null) ? 0 : kpassword.hashCode());
		
		result = prime * result
				+ ((kvorname == null) ? 0 : kvorname.hashCode());
		result = prime * result + ((pan == null) ? 0 : pan.hashCode());
		result = prime * result + (saf ? 1231 : 1237);
		result = prime * result + ((strasse == null) ? 0 : strasse.hashCode());
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kunde other = (Kunde) obj;
		if (admin != other.admin)
			return false;
		if (aktive != other.aktive)
			return false;
		if (bewertungen == null) {
			if (other.bewertungen != null)
				return false;
		} else if (!bewertungen.equals(other.bewertungen))
			return false;
		if (bezahlmethoden == null) {
			if (other.bezahlmethoden != null)
				return false;
		} else if (!bezahlmethoden.equals(other.bezahlmethoden))
			return false;
		if (dreck == null) {
			if (other.dreck != null)
				return false;
		} else if (!dreck.equals(other.dreck))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fsa == null) {
			if (other.fsa != null)
				return false;
		} else if (!fsa.equals(other.fsa))
			return false;
		if (fsnummer == null) {
			if (other.fsnummer != null)
				return false;
		} else if (!fsnummer.equals(other.fsnummer))
			return false;
		if (gemietet == null) {
			if (other.gemietet != null)
				return false;
		} else if (!gemietet.equals(other.gemietet))
			return false;
		if (knachname == null) {
			if (other.knachname != null)
				return false;
		} else if (!knachname.equals(other.knachname))
			return false;
		if (kpassword == null) {
			if (other.kpassword != null)
				return false;
		} else if (!kpassword.equals(other.kpassword))
			return false;
		if (kplz == null) {
			if (other.kplz != null)
				return false;
		} else if (!kplz.equals(other.kplz))
			return false;
		if (kvorname == null) {
			if (other.kvorname != null)
				return false;
		} else if (!kvorname.equals(other.kvorname))
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		if (pan == null) {
			if (other.pan != null)
				return false;
		} else if (!pan.equals(other.pan))
			return false;
		if (rechnungen == null) {
			if (other.rechnungen != null)
				return false;
		} else if (!rechnungen.equals(other.rechnungen))
			return false;
		if (saf != other.saf)
			return false;
		if (schaden == null) {
			if (other.schaden != null)
				return false;
		} else if (!schaden.equals(other.schaden))
			return false;
		if (strasse == null) {
			if (other.strasse != null)
				return false;
		} else if (!strasse.equals(other.strasse))
			return false;
		return true;
	}


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
	 * Gets the kpassword.
	 *
	 * @return the kpassword
	 */
	public String getKpassword() {
		return kpassword;
	}


	/**
	 * Sets the kpassword.
	 *
	 * @param kpassword the new kpassword
	 */
	public void setKpassword(String kpassword) {
		this.kpassword = kpassword;
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
	 * Kunde.
	 *
	 * @param fsnummer the fsnummer
	 */
	public void kunde(String fsnummer) {
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
	 * Gets the strasse.
	 *
	 * @return the strasse
	 */
	public String getStrasse() {
		return strasse;
	}


	/**
	 * Sets the strasse.
	 *
	 * @param strasse the new strasse
	 */
	public void setStrasse(String strasse) {
		this.strasse = strasse;
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
	 * Gets the gemietet.
	 *
	 * @return the gemietet
	 */
	public List<mieten> getGemietet() {
		return gemietet;
	}


	/**
	 * Sets the gemietet.
	 *
	 * @param gemietet the new gemietet
	 */
	public void setGemietet(List<mieten> gemietet) {
		this.gemietet = gemietet;
	}


	/**
	 * Gets the rechnungen.
	 *
	 * @return the rechnungen
	 */
	public List<Rechnung> getRechnungen() {
		return rechnungen;
	}


	/**
	 * Sets the rechnungen.
	 *
	 * @param rechnungen the new rechnungen
	 */
	public void setRechnungen(List<Rechnung> rechnungen) {
		this.rechnungen = rechnungen;
	}


	/**
	 * Gets the bezahlmethoden.
	 *
	 * @return the bezahlmethoden
	 */
	public List<Bezahlmethode> getBezahlmethoden() {
		return bezahlmethoden;
	}


	/**
	 * Sets the bezahlmethoden.
	 *
	 * @param bezahlmethoden the new bezahlmethoden
	 */
	public void setBezahlmethoden(List<Bezahlmethode> bezahlmethoden) {
		this.bezahlmethoden = bezahlmethoden;
	}

	/**
	 * Adds the bezahlmethoden.
	 *
	 * @param bezmeth the bezmeth
	 */
	public void addBezahlmethoden(Bezahlmethode bezmeth){
		bezahlmethoden.add(bezmeth);
	}
	
	/**
	 * Gets the schaden.
	 *
	 * @return the schaden
	 */
	public List<Schaden> getSchaden() {
		return schaden;
	}


	/**
	 * Sets the schaden.
	 *
	 * @param schaden the new schaden
	 */
	public void setSchaden(List<Schaden> schaden) {
		this.schaden = schaden;
	}


	/**
	 * Gets the bewertungen.
	 *
	 * @return the bewertungen
	 */
	public List<Bewertung> getBewertungen() {
		return bewertungen;
	}


	/**
	 * Sets the bewertungen.
	 *
	 * @param bewertungen the new bewertungen
	 */
	public void setBewertungen(List<Bewertung> bewertungen) {
		this.bewertungen = bewertungen;
	}


	/**
	 * Gets the dreck.
	 *
	 * @return the dreck
	 */
	public List<Dreck> getDreck() {
		return dreck;
	}


	/**
	 * Sets the dreck.
	 *
	 * @param dreck the new dreck
	 */
	public void setDreck(List<Dreck> dreck) {
		this.dreck = dreck;
	}


	/**
	 * Gets the fsa.
	 *
	 * @return the fsa
	 */
	public FSA getFsa() {
		return fsa;
	}


	/**
	 * Sets the fsa.
	 *
	 * @param fsa the new fsa
	 */
	public void setFsa(FSA fsa) {
		this.fsa = fsa;
	}


	/**
	 * Gets the kplz.
	 *
	 * @return the kplz
	 */
	public PLZ getKplz() {
		return kplz;
	}


	/**
	 * Sets the kplz.
	 *
	 * @param kplz the new kplz
	 */
	public void setKplz(PLZ kplz) {
		this.kplz = kplz;
	}
	
	/**
	 * Addmiete.
	 *
	 * @param miet the miet
	 */
	public void addmiete(mieten miet) {
		gemietet.add(miet);
	}
	
	/**
	 * Adds the rechnung.
	 *
	 * @param rechnung the rechnung
	 */
	public void addRechnung(Rechnung rechnung){
		rechnungen.add(rechnung);
	}
	
	/**
	 * Adds the bezahlmethode.
	 *
	 * @param bzm the bzm
	 */
	public void addBezahlmethode(Bezahlmethode bzm){
		bezahlmethoden.add(bzm);
			}
	
	/**
	 * Adds the schaden.
	 *
	 * @param schaden the schaden
	 */
	public void addSchaden(Schaden schaden){
		this.schaden.add(schaden);
	}
	
	/**
	 * Adds the bewertung.
	 *
	 * @param bewertung the bewertung
	 */
	public void addBewertung(Bewertung bewertung){
		bewertungen.add(bewertung);
	}
	
	/**
	 * Adds the dreck.
	 *
	 * @param dreck the dreck
	 */
	public void addDreck(Dreck dreck){
		this.dreck.add(dreck);
	}


	@Override
	public String toString() {
		return "Kunde [email=" + email + ", kvorname=" + kvorname
				+ ", knachname=" + knachname + ", kpassword=" + kpassword
				+ ", fsnummer=" + fsnummer + ", pan=" + pan + ", strasse="
				+ strasse + ", link=" + link + ", saf=" + saf + ", admin="
				+ admin + ", aktive=" + aktive + ", gemietet=" + gemietet
				+ ", rechnungen=" + rechnungen + ", bezahlmethoden="
				+ bezahlmethoden + ", schaden=" + schaden + ", bewertungen="
				+ bewertungen + ", dreck=" + dreck + ", fsa=" + fsa + ", kplz="
				+ kplz + "]";
	}


	/**
	 * Sets the fsnummer.
	 *
	 * @param fsnummer the new fsnummer
	 */
	public void setFsnummer(String fsnummer) {
		this.fsnummer = fsnummer;
	}
	public void deleteSchaden(Schaden schaden){
		this.schaden.remove(schaden);
	}
	public void deleteDreck(Dreck dreck){
		this.dreck.remove(dreck);
	}
}
