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
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;



@Entity
public class Auto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int Aid;
	@Column(nullable=false)
	private String position;
	@Column(nullable=false)
	private String bez;
	
	@ManyToOne(optional=false)
	private Autoart autoart;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="auto") @MapKey
	private Map<Integer,mieten> gemietet;
	
	public Auto(){
		
	
	}
	
	
	public Auto(int aid, String position, String bez, Autoart autoart) {
		super();
		this.position = position;
		this.bez = bez;
		this.autoart = autoart;
		this.gemietet = new HashMap<>();
	}


	public Autoart getAutoart() {
		return autoart;
	}

	public void setAutoart(Autoart autoart) {
		this.autoart = autoart;
	}

	public Auto(String position,String bez)
	{
		this.position = position;
		this.bez = bez;
	}

	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getBez() {
		return bez;
	}
	public void setBez(String bez) {
		this.bez = bez;
	}

	public int getAid() {
		return Aid;
	}

	public void setAid(int aid) {
		Aid = aid;
	}

	

	public Map<Integer, mieten> getGemietet() {
		return gemietet;
	}

	public void setGemietet(Map<Integer, mieten> gemietet) {
		this.gemietet = gemietet;
	}

	
	
}
