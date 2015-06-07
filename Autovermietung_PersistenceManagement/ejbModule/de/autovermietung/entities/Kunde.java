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


	private boolean saf;
	private boolean admin;
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


	public void setFsnummer(String fsnummer) {
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
}
