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
public class FSA implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int FSA;
	@Column(nullable=false)
	private String FSAName;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="FSA") @MapKey
	private Map<Integer,Kunde> Kunden;
	public FSA(){
		
	}



	public FSA(String fSAName) {
		super();
		FSAName = fSAName;
		Kunden = new HashMap<>();
	}



	public int getFSA() {
		return FSA;
	}



	public void setFSA(int fSA) {
		FSA = fSA;
	}



	public String getFSAName() {
		return FSAName;
	}

	public void setFSAName(String fSAName) {
		FSAName = fSAName;
	}

	public Map<Integer, Kunde> getKunden() {
		return Kunden;
	}

	public void setKunden(Map<Integer, Kunde> kunden) {
		Kunden = kunden;
	}

}
