package de.autovermietung.entities;

import javax.persistence.Id;

public class Kunde {
	@Id
	public int kid;
	public String Kvorname;
	public String Knachname;
	public String email;
	public String Kpassword;
	public String FSnummer;
	public String PAN;
	public String PLZ;
	public String Straße;
	public boolean SAF;
	public boolean Admin;
	
	public Kunde(){
		
		
	}

}
