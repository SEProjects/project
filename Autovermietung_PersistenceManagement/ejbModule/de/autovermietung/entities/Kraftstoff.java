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
 * The Class Kraftstoff.
 */
@Entity
public class Kraftstoff implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The ksid. */
	@Id @GeneratedValue
	private int ksid;
	
	/** The ksbezeichnung. */
	@Column(nullable=false)
	private String ksbezeichnung;
	
	/** The autoart. */
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="ks") @MapKey
	private List<Autoart> autoart;
	
	/**
	 * Instantiates a new kraftstoff.
	 */
	public Kraftstoff(){
	
	}
	
	/**
	 * Instantiates a new kraftstoff.
	 *
	 * @param ksbezeichnung the ksbezeichnung
	 */
	public Kraftstoff(String ksbezeichnung) {
		super();
		this.ksbezeichnung = ksbezeichnung;
		this.autoart = new ArrayList<>();
	}
	
	/**
	 * Adds the autoart.
	 *
	 * @param autoart the autoart
	 */
	public void addAutoart(Autoart autoart){
		this.autoart.add(autoart);
	}
	
	/**
	 * Gets the ksbezeichnung.
	 *
	 * @return the ksbezeichnung
	 */
	public String getKsbezeichnung() {
		return ksbezeichnung;
	}
	
	/**
	 * Sets the ksbezeichnung.
	 *
	 * @param ksbezeichnung the new ksbezeichnung
	 */
	public void setKsbezeichnung(String ksbezeichnung) {
		this.ksbezeichnung = ksbezeichnung;
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
	 * Gets the ksid.
	 *
	 * @return the ksid
	 */
	public int getKsid() {
		return ksid;
	}
	
	
}
