package de.autovermietung.dto;

import de.autovermietung.entities.FSA;
import de.autovermietung.entities.PLZ;

public class KundeResponse extends ReturncodeResponse {

	private static final long serialVersionUID = -3173158310918408228L;
	private String email;
		
	private String kvorname;
	
	private String knachname;
	
	private String fsnummer;
	
	private String pan;
	private String straße;

	private boolean saf;
	private boolean admin;
	//Objekt FSA
	private String fsaName;
	//Objekt PLZ
	private String plz;
	private String wohnort;

	public KundeResponse(){
		
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
	
	public String getStraße() {
		return this.straße;
	}
	
	public void setStraße(String straße) {
		this.straße = straße;
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
	
	public String getFsaName() {
		return this.fsaName;
	}
	
	public void setFsaName(String fsaName) {
		this.fsaName = fsaName;
	}

	public String getPlz() {
		return this.plz;
	}
	public void setPlz(String plz) {
		this.plz = plz;
	}
	
	public String getWohnort() {
		return this.wohnort;
	}
	public void setWohnort(String wohnort) {
		this.wohnort = wohnort;
	}
}
