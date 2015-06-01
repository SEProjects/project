package de.autovermietung.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
	private int fsa;
	@Column(nullable=false)
	private String fsaname;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="fsa") @MapKey
	private List<Kunde> kunden;
	public FSA(){
		
	}



	public FSA(String fSAName) {
		super();
		fsaname = fSAName;
		kunden = new ArrayList<>();
	}

	public void addKunde(Kunde kunde){
		kunden.add(kunde);
	}

	public String getFsaname() {
		return fsaname;
	}



	public void setFsaname(String fsaname) {
		this.fsaname = fsaname;
	}



	public List<Kunde> getKunden() {
		return kunden;
	}



	public void setKunden(List<Kunde> kunden) {
		this.kunden = kunden;
	}



	public int getFsa() {
		return fsa;
	}



	

}
