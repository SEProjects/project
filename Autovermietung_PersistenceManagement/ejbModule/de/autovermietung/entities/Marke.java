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
public class Marke implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int Markeid;
	@Column(nullable=false)
	private String markenname;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="marke") @MapKey
	private Map<Integer,Autoart> Autoart;
	public Marke(){
		
	}

	public Marke(String markenname) {
		super();
		this.markenname = markenname;
		Autoart = new HashMap<>();
	}

	public int getMarkeid() {
		return Markeid;
	}

	public void setMarkeid(int markeid) {
		this.Markeid = markeid;
	}

	public String getMarkenname() {
		return markenname;
	}

	public void setMarkenname(String markenname) {
		this.markenname = markenname;
	}

	public Map<Integer, Autoart> getAutoart() {
		return Autoart;
	}

	public void setAutoart(Map<Integer, Autoart> autoart) {
		Autoart = autoart;
	}

}
