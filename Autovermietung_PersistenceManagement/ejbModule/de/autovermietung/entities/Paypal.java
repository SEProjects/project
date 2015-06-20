package de.autovermietung.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

// TODO: Auto-generated Javadoc
/**
 * The Class Paypal.
 */
@Entity
public class Paypal extends Bezahlmethode implements  Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The email. */
	@Column(nullable=false)
	private String email;
	
	/**
	 * Instantiates a new paypal.
	 */
	public Paypal(){
		
	}
	
	/**
	 * Instantiates a new paypal.
	 *
	 * @param email the email
	 * @param kunde the kunde
	 */
	public Paypal(String email,Kunde kunde) {
		super(kunde);
		this.email = email;
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



}
