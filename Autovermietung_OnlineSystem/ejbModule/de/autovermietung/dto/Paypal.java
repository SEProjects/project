package de.autovermietung.dto;

import java.io.Serializable;


public class Paypal extends Bezahlmethode implements  Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
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
