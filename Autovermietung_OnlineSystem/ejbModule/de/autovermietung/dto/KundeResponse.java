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


	private boolean saf;
	private boolean admin;



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

	

}
