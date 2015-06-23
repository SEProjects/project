package de.autovermietung.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

// TODO: Auto-generated Javadoc
/**
 * @Kevin Haase
 * The Class Bankkonto.
 */
@Entity
public class Bankkonto extends Bezahlmethode implements Serializable  {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Iban. */
	@Column(nullable=false)
	private String iban;
	
	/** Bic. */
	@Column(nullable=false)
	private String bic;
	
	/**
	 * Instantiates a new bankkonto.
	 */
	public Bankkonto(){
	
	}
	
	/**
	 * Instantiates a new bankkonto.
	 *
	 * @param iBan the i ban
	 * @param bIC the b ic
	 * @param kunde the kunde
	 */
	public Bankkonto(String iBan, String bIC,Kunde kunde) {
		super(kunde);
		iban = iBan;
		bic = bIC;
	}
	
	/**
	 * Gets the iban.
	 *
	 * @return the iban
	 */
	public String getIban() {
		return iban;
	}
	
	/**
	 * Sets the iban.
	 *
	 * @param iban the new iban
	 */
	public void setIban(String iban) {
		this.iban = iban;
	}
	
	/**
	 * Gets the bic.
	 *
	 * @return the bic
	 */
	public String getBic() {
		return bic;
	}
	
	/**
	 * Sets the bic.
	 *
	 * @param bic the new bic
	 */
	public void setBic(String bic) {
		this.bic = bic;
	}
	

}
