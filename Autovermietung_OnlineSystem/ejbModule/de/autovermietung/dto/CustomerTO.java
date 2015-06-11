package de.autovermietung.dto;

import java.io.Serializable;

/* 
 * Author: Carlo Eefting
 * Beschreibung: 
 */



public class CustomerTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String password;
	private boolean gemietet = false;
	
	
	public CustomerTO() {
	}
	
	public CustomerTO(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void mietetAuto(){
		gemietet = true;
	}
	
	public void autoZurueck(){
		gemietet = false;
	}
	
	public boolean getMietStatus(){
		return gemietet;
	}
}
