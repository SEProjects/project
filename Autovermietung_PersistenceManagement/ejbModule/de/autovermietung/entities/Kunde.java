package de.autovermietung.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
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
	@Id @GeneratedValue
	private int kid;
	
	@Column(nullable=false)
	private String Kvorname;
	@Column(nullable=false)
	private String Knachname;
	@Column(nullable=false,unique=true)
	private String email;
	@Column(nullable=false)
	private String Kpassword;
	@Column(nullable=false,unique=true)
	private String FSnummer;
	@Column(nullable=false,unique=true)
	private String PAN;

	
	@Column(nullable=false)
	private String Strasse;


	private boolean SAF;
	private boolean Admin;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="kunde") @MapKey
	private Map<Integer,mieten> gemietet;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="kunde") @MapKey
	private Map<Integer,Rechnung> Rechnungen;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="kunde") @MapKey
	private Map<Integer,Bezahlmethode> Bezahlmethoden;

	@ManyToOne(optional=false)
	private FSA FSA;
	@ManyToOne(optional=false)
	private PLZ Kplz;
	
	
	public Kunde(){
		
		
	}
	
	public Kunde(String kvorname, String knachname, String email,
			String kpassword, String fSnummer, String pAN, String strasse,
			boolean sAF, boolean admin,	FSA fSA, PLZ kplz) {
		super();
		Kvorname = kvorname;
		Knachname = knachname;
		this.email = email;
		Kpassword = kpassword;
		FSnummer = fSnummer;
		PAN = pAN;
		Strasse = strasse;
		SAF = sAF;
		Admin = admin;
		this.gemietet = new HashMap<>();
		Rechnungen = new HashMap<>();
		Bezahlmethoden = new HashMap<>();
		FSA = fSA;
		Kplz = kplz;
	}

	public FSA getFSA() {
		return FSA;
	}

	public void setFSA(FSA fSA) {
		FSA = fSA;
	}

	public PLZ getKplz() {
		return Kplz;
	}

	public void setKplz(PLZ kplz) {
		Kplz = kplz;
	}

	public int getKid() {
		return kid;
	}

	public void setKid(int kid) {
		this.kid = kid;
	}
	
	public String getKvorname() {
		return Kvorname;
	}

	public void setKvorname(String kvorname) {
		Kvorname = kvorname;
	}

	public String getKnachname() {
		return Knachname;
	}

	public void setKnachname(String knachname) {
		Knachname = knachname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getKpassword() {
		return Kpassword;
	}

	public void setKpassword(String kpassword) {
		Kpassword = kpassword;
	}

	public String getFSnummer() {
		return FSnummer;
	}

	public void setFSnummer(String fSnummer) {
		FSnummer = fSnummer;
	}

	public String getPAN() {
		return PAN;
	}

	public void setPAN(String pAN) {
		PAN = pAN;
	}

	

	public String getStrasse() {
		return Strasse;
	}

	public void setStraße(String strasse) {
		Strasse = strasse;
	}

	public boolean isSAF() {
		return SAF;
	}

	public void setSAF(boolean sAF) {
		SAF = sAF;
	}

	public boolean isAdmin() {
		return Admin;
	}

	public void setAdmin(boolean admin) {
		Admin = admin;
	}

	public Map<Integer, mieten> getGemietet() {
		return gemietet;
	}
	public void setGemietet(Map<Integer, mieten> gemietet) {
		this.gemietet = gemietet;
	}
	public Map<Integer, Rechnung> getRechnungen() {
		return Rechnungen;
	}
	public void setRechnungen(Map<Integer, Rechnung> rechnungen) {
		Rechnungen = rechnungen;
	}
	public Map<Integer, Bezahlmethode> getBezahlmethoden() {
		return Bezahlmethoden;
	}
	public void setBezahlmethoden(Map<Integer, Bezahlmethode> bezahlmethoden) {
		Bezahlmethoden = bezahlmethoden;
	}

	public void setStrasse(String strasse) {
		Strasse = strasse;
	}
	

}
