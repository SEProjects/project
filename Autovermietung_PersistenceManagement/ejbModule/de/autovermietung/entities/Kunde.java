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

@Entity
public class Kunde implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String email;
	
	@Column(nullable=false)
	private String kvorname;
	@Column(nullable=false)
	private String knachname;
	
	@Column(nullable=false)
	private String kpassword;
	@Column(nullable=false,unique=true)
	private String fsnummer;
	@Column(nullable=false,unique=true)
	private String pan;

	
	@Column(nullable=false)
	private String strasse;
	private String link;

	private boolean saf;
	private boolean admin;
	private boolean aktive;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="kunde") @MapKey
	private List<mieten> gemietet;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="kunde") @MapKey
	private List<Rechnung> rechnungen;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="kunde") @MapKey
	private List<Bezahlmethode> bezahlmethoden;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="kunde") @MapKey
	private List<Schaden> schaden;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="kunde") @MapKey
	private List<Bewertung> bewertungen;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="kunde") @MapKey
	private List<Dreck> dreck;

	@ManyToOne(optional=false)
	private FSA fsa;
	@ManyToOne(optional=false)
	private PLZ kplz;
	
	
	public Kunde(){
		
		
	}


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


	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
	}


	public boolean isAktive() {
		return aktive;
	}


	public void setAktive(boolean aktive) {
		this.aktive = aktive;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (admin ? 1231 : 1237);
		result = prime * result + (aktive ? 1231 : 1237);
		result = prime * result
				+ ((bewertungen == null) ? 0 : bewertungen.hashCode());
		result = prime * result
				+ ((bezahlmethoden == null) ? 0 : bezahlmethoden.hashCode());
		result = prime * result + ((dreck == null) ? 0 : dreck.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fsa == null) ? 0 : fsa.hashCode());
		result = prime * result
				+ ((fsnummer == null) ? 0 : fsnummer.hashCode());
		result = prime * result
				+ ((gemietet == null) ? 0 : gemietet.hashCode());
		result = prime * result
				+ ((knachname == null) ? 0 : knachname.hashCode());
		result = prime * result
				+ ((kpassword == null) ? 0 : kpassword.hashCode());
		result = prime * result + ((kplz == null) ? 0 : kplz.hashCode());
		result = prime * result
				+ ((kvorname == null) ? 0 : kvorname.hashCode());
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result + ((pan == null) ? 0 : pan.hashCode());
		result = prime * result
				+ ((rechnungen == null) ? 0 : rechnungen.hashCode());
		result = prime * result + (saf ? 1231 : 1237);
		result = prime * result + ((schaden == null) ? 0 : schaden.hashCode());
		result = prime * result + ((strasse == null) ? 0 : strasse.hashCode());
		return result;
	}


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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getKvorname() {
		return kvorname;
	}


	public void setKvorname(String kvorname) {
		this.kvorname = kvorname;
	}


	public String getKnachname() {
		return knachname;
	}


	public void setKnachname(String knachname) {
		this.knachname = knachname;
	}


	public String getKpassword() {
		return kpassword;
	}


	public void setKpassword(String kpassword) {
		this.kpassword = kpassword;
	}


	public String getFsnummer() {
		return fsnummer;
	}


	public void kunde(String fsnummer) {
		this.fsnummer = fsnummer;
	}


	public String getPan() {
		return pan;
	}


	public void setPan(String pan) {
		this.pan = pan;
	}


	public String getStrasse() {
		return strasse;
	}


	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}


	public boolean isSaf() {
		return saf;
	}


	public void setSaf(boolean saf) {
		this.saf = saf;
	}


	public boolean isAdmin() {
		return admin;
	}


	public void setAdmin(boolean admin) {
		this.admin = admin;
	}


	public List<mieten> getGemietet() {
		return gemietet;
	}


	public void setGemietet(List<mieten> gemietet) {
		this.gemietet = gemietet;
	}


	public List<Rechnung> getRechnungen() {
		return rechnungen;
	}


	public void setRechnungen(List<Rechnung> rechnungen) {
		this.rechnungen = rechnungen;
	}


	public List<Bezahlmethode> getBezahlmethoden() {
		return bezahlmethoden;
	}


	public void setBezahlmethoden(List<Bezahlmethode> bezahlmethoden) {
		this.bezahlmethoden = bezahlmethoden;
	}

	public void addBezahlmethoden(Bezahlmethode bezmeth){
		bezahlmethoden.add(bezmeth);
	}
	
	public List<Schaden> getSchaden() {
		return schaden;
	}


	public void setSchaden(List<Schaden> schaden) {
		this.schaden = schaden;
	}


	public List<Bewertung> getBewertungen() {
		return bewertungen;
	}


	public void setBewertungen(List<Bewertung> bewertungen) {
		this.bewertungen = bewertungen;
	}


	public List<Dreck> getDreck() {
		return dreck;
	}


	public void setDreck(List<Dreck> dreck) {
		this.dreck = dreck;
	}


	public FSA getFsa() {
		return fsa;
	}


	public void setFsa(FSA fsa) {
		this.fsa = fsa;
	}


	public PLZ getKplz() {
		return kplz;
	}


	public void setKplz(PLZ kplz) {
		this.kplz = kplz;
	}
	public void addmiete(mieten miet) {
		gemietet.add(miet);
	}
	public void addRechnung(Rechnung rechnung){
		rechnungen.add(rechnung);
	}
	public void addBezahlmethode(Bezahlmethode bzm){
		bezahlmethoden.add(bzm);
			}
	public void addSchaden(Schaden schaden){
		this.schaden.add(schaden);
	}
	public void addBewertung(Bewertung bewertung){
		bewertungen.add(bewertung);
	}
	public void addDreck(Dreck dreck){
		this.dreck.add(dreck);
	}


	@Override
	public String toString() {
		return "Kunde [email=" + email + ", kvorname=" + kvorname
				+ ", knachname=" + knachname + ", kpassword=" + kpassword
				+ ", fsnummer=" + fsnummer + ", pan=" + pan + ", strasse="
				+ strasse + ", saf=" + saf + ", admin=" + admin + ", gemietet="
				+ gemietet + ", rechnungen=" + rechnungen + ", bezahlmethoden="
				+ bezahlmethoden + ", schaden=" + schaden + ", bewertungen="
				+ bewertungen + ", dreck=" + dreck + ", fsa=" + fsa + ", kplz="
				+ kplz + "]";
	}


	public void setFsnummer(String fsnummer) {
		this.fsnummer = fsnummer;
	}
}
