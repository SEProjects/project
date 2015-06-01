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
public class Marke implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int markeid;
	@Column(nullable=false)
	private String markenname;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="marke") @MapKey
	private List<Autoart> autoart;
	public Marke(){
		
	}
	public Marke(String markenname) {
		super();
		this.markenname = markenname;
		this.autoart = new ArrayList<>();
	}
	public String getMarkenname() {
		return markenname;
	}
	public void setMarkenname(String markenname) {
		this.markenname = markenname;
	}
	public List<Autoart> getAutoart() {
		return autoart;
	}
	public void setAutoart(List<Autoart> autoart) {
		this.autoart = autoart;
	}
	public int getMarkeid() {
		return markeid;
	}
	public void addAutoart(Autoart aa){
		autoart.add(aa);
	}


}
