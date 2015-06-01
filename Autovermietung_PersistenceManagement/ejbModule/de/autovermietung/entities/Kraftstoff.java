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
public class Kraftstoff implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int ksid;
	@Column(nullable=false)
	private String ksbezeichnung;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="ks") @MapKey
	private List<Autoart> autoart;
	public Kraftstoff(){
	
	}
	public Kraftstoff(String ksbezeichnung) {
		super();
		this.ksbezeichnung = ksbezeichnung;
		this.autoart = new ArrayList<>();
	}
	public void addAutoart(Autoart autoart){
		this.autoart.add(autoart);
	}
	public String getKsbezeichnung() {
		return ksbezeichnung;
	}
	public void setKsbezeichnung(String ksbezeichnung) {
		this.ksbezeichnung = ksbezeichnung;
	}
	public List<Autoart> getAutoart() {
		return autoart;
	}
	public void setAutoart(List<Autoart> autoart) {
		this.autoart = autoart;
	}
	public int getKsid() {
		return ksid;
	}
	
	
}
