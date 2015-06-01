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
	private String iban;
	@Column(nullable=false)
	private String bic;
	
	public Bankkonto(){
	
	}
	public Bankkonto(String iBan, String bIC,Kunde kunde) {
		super(kunde);
		iban = iBan;
		bic = bIC;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public String getBic() {
		return bic;
	}
	public void setBic(String bic) {
		this.bic = bic;
	}
	

}
