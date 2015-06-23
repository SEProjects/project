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
// TODO: Auto-generated Javadoc

/**
 * @author Kevin Haase
 * The Class Marke.
 */
@Entity
public class Marke implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The markeid. */
	@Id @GeneratedValue
	private int markeid;
	
	/** The markenname. */
	@Column(nullable=false)
	private String markenname;
	
	/** The autoart. */
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="marke") @MapKey
	private List<Autoart> autoart;
	
	/**
	 * Instantiates a new marke.
	 */
	public Marke(){
		
	}
	
	/**
	 * Instantiates a new marke.
	 *
	 * @param markenname the markenname
	 */
	public Marke(String markenname) {
		super();
		this.markenname = markenname;
		this.autoart = new ArrayList<>();
	}
	
	/**
	 * Gets the markenname.
	 *
	 * @return the markenname
	 */
	public String getMarkenname() {
		return markenname;
	}
	
	/**
	 * Sets the markenname.
	 *
	 * @param markenname the new markenname
	 */
	public void setMarkenname(String markenname) {
		this.markenname = markenname;
	}
	
	/**
	 * Gets the autoart.
	 *
	 * @return the autoart
	 */
	public List<Autoart> getAutoart() {
		return autoart;
	}
	
	/**
	 * Sets the autoart.
	 *
	 * @param autoart the new autoart
	 */
	public void setAutoart(List<Autoart> autoart) {
		this.autoart = autoart;
	}
	
	/**
	 * Gets the markeid.
	 *
	 * @return the markeid
	 */
	public int getMarkeid() {
		return markeid;
	}
	
	/**
	 * Adds the autoart.
	 *
	 * @param aa the aa
	 */
	public void addAutoart(Autoart aa){
		autoart.add(aa);
	}


}
