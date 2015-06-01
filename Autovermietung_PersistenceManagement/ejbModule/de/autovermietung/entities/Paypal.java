package de.autovermietung.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Paypal extends Bezahlmethode implements  Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(nullable=false)
	private String email;
	
	public Paypal(){
		
	}
	
	public Paypal(String email,Kunde kunde) {
		super(kunde);
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



}
