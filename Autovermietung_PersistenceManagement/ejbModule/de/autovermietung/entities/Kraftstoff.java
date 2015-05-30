package de.autovermietung.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
public class Kraftstoff implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int KSid;
	@Column(nullable=false)
	private String KSBezeichnung;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="KS") @MapKey
	private Map<Integer,Autoart> Autoart;
	public Kraftstoff(){
	
	}
	
	public Kraftstoff(String kSBezeichnung) {
		super();
		KSBezeichnung = kSBezeichnung;
		Autoart = new HashMap<>();
	}

	public int getKSid() {
		return KSid;
	}
	public void setKSid(int kSid) {
		KSid = kSid;
	}
	public String getKSBezeichnung() {
		return KSBezeichnung;
	}
	public void setKSBezeichnung(String kSBezeichnung) {
		KSBezeichnung = kSBezeichnung;
	}
	public Map<Integer, Autoart> getAutoart() {
		return Autoart;
	}
	public void setAutoart(Map<Integer, Autoart> autoart) {
		Autoart = autoart;
	}
}
