package de.autovermietung.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Bankkonto extends Bezahlmethode implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(nullable=false)
	private String IBan;
	@Column(nullable=false)
	private String BIC;
	
	public Bankkonto(){
	
	}
	public Bankkonto(String iBan, String bIC,Kunde kunde) {
		super(kunde);
		IBan = iBan;
		BIC = bIC;
	}
	public String getIBan() {
		return IBan;
	}
	public void setIBan(String iBan) {
		IBan = iBan;
	}
	public String getBIC() {
		return BIC;
	}
	public void setBIC(String bIC) {
		BIC = bIC;
	}

	

}
