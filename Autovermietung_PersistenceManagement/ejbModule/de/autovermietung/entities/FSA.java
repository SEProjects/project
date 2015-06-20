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
 * The Class FSA.
 */
@Entity
public class FSA implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The fsa. */
	@Id @GeneratedValue
	private int fsa;
	
	/** The fsaname. */
	@Column(nullable=false)
	private String fsaname;
	
	/** The kunden. */
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="fsa") @MapKey
	private List<Kunde> kunden;
	
	/**
	 * Instantiates a new fsa.
	 */
	public FSA(){
		
	}



	/**
	 * Instantiates a new fsa.
	 *
	 * @param fSAName the f sa name
	 */
	public FSA(String fSAName) {
		super();
		fsaname = fSAName;
		kunden = new ArrayList<>();
	}

	/**
	 * Adds the kunde.
	 *
	 * @param kunde the kunde
	 */
	public void addKunde(Kunde kunde){
		kunden.add(kunde);
	}

	/**
	 * Gets the fsaname.
	 *
	 * @return the fsaname
	 */
	public String getFsaname() {
		return fsaname;
	}



	/**
	 * Sets the fsaname.
	 *
	 * @param fsaname the new fsaname
	 */
	public void setFsaname(String fsaname) {
		this.fsaname = fsaname;
	}



	/**
	 * Gets the kunden.
	 *
	 * @return the kunden
	 */
	public List<Kunde> getKunden() {
		return kunden;
	}



	/**
	 * Sets the kunden.
	 *
	 * @param kunden the new kunden
	 */
	public void setKunden(List<Kunde> kunden) {
		this.kunden = kunden;
	}



	/**
	 * Gets the fsa.
	 *
	 * @return the fsa
	 */
	public int getFsa() {
		return fsa;
	}



	

}
