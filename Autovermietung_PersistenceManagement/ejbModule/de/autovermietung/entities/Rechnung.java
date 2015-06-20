package de.autovermietung.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlType;
// TODO: Auto-generated Javadoc

/**
 * The Class Rechnung.
 */
@XmlType(name="Rechnung2")
@Entity
public class Rechnung implements Serializable{


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The rid. */
	@Id @GeneratedValue
	private int rid;
	
	/** The gesamtpreis. */
	@Column(nullable=false)
	private BigDecimal gesamtpreis;
	
	/** The timestamp. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP",nullable=false,updatable = false, insertable = false)
	private Date timestamp;
	
	/** The mwst. */
	@Column(nullable=false)
	private BigDecimal mwst;
	
	/** The vorpreis. */
	private BigDecimal vorpreis;
	
	/** The rabatt. */
	private BigDecimal rabatt;
	
	/** The rechnungspositionen. */
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="rechnung") 
	private List<mieten> rechnungspositionen;
	
	/** The bezahlmethode. */
	@ManyToOne
	private Bezahlmethode bezahlmethode;
	
	/** The kunde. */
	@ManyToOne(optional=false)
	private Kunde kunde;
	
	/**
	 * Gets the vorpreis.
	 *
	 * @return the vorpreis
	 */
	public BigDecimal getVorpreis() {
		return vorpreis;
	}


	/**
	 * Sets the vorpreis.
	 *
	 * @param vorpreis the new vorpreis
	 */
	public void setVorpreis(BigDecimal vorpreis) {
		this.vorpreis = vorpreis;
	}


	/**
	 * Gets the rabatt.
	 *
	 * @return the rabatt
	 */
	public BigDecimal getRabatt() {
		return rabatt;
	}


	/**
	 * Sets the rabatt.
	 *
	 * @param rabatt the new rabatt
	 */
	public void setRabatt(BigDecimal rabatt) {
		this.rabatt = rabatt;
		gesamtpreis = vorpreis.multiply(new BigDecimal(1).subtract(rabatt.divide(new BigDecimal(100))));
		this.mwst = gesamtpreis.multiply(new BigDecimal(0.19));
	}


	/**
	 * Checks if is bezahlt.
	 *
	 * @return true, if is bezahlt
	 */
	public boolean isBezahlt() {
		return bezahlt;
	}


	/**
	 * Sets the bezahlt.
	 *
	 * @param bezahlt the new bezahlt
	 */
	public void setBezahlt(boolean bezahlt) {
		this.bezahlt = bezahlt;
	}
	
	/** The bezahlt. */
	private boolean bezahlt;
	
	/** The abgerechnet. */
	private boolean abgerechnet;
	
	/**
	 * Checks if is abgerechnet.
	 *
	 * @return true, if is abgerechnet
	 */
	public boolean isAbgerechnet() {
		return abgerechnet;
	}


	/**
	 * Sets the abgerechnet.
	 *
	 * @param abgerechnet the new abgerechnet
	 */
	public void setAbgerechnet(boolean abgerechnet) {
		this.abgerechnet = abgerechnet;
	}


	/**
	 * Instantiates a new rechnung.
	 */
	public Rechnung(){
		
	}


	/**
	 * Instantiates a new rechnung.
	 *
	 * @param kunde the kunde
	 */
	public Rechnung(Kunde kunde) {
		super();
	
		this.kunde = kunde;
		rechnungspositionen = new ArrayList<>();
	
	}
	
	/**
	 * Adds the rechnungsposition.
	 *
	 * @param miet the miet
	 */
	public void addRechnungsposition(mieten miet){
		rechnungspositionen.add(miet);
	}

	/**
	 * Gets the gesamtpreis.
	 *
	 * @return the gesamtpreis
	 */
	public BigDecimal getGesamtpreis() {
		return gesamtpreis;
	}


	/**
	 * Sets the gesamtpreis.
	 *
	 * @param gesamtpreis the new gesamtpreis
	 */
	public void setGesamtpreis(BigDecimal gesamtpreis) {
		this.gesamtpreis = gesamtpreis;
	}


	/**
	 * Gets the mwst.
	 *
	 * @return the mwst
	 */
	public BigDecimal getMwst() {
		return mwst;
	}


	/**
	 * Sets the mwst.
	 *
	 * @param mwst the new mwst
	 */
	public void setMwst(BigDecimal mwst) {
		this.mwst = mwst;
	}


	/**
	 * Gets the rechnungspositionen.
	 *
	 * @return the rechnungspositionen
	 */
	public List<mieten> getRechnungspositionen() {
		return rechnungspositionen;
	}


	/**
	 * Sets the rechnungspositionen.
	 *
	 * @param rechnungspositionen the new rechnungspositionen
	 */
	public void setRechnungspositionen(List<mieten> rechnungspositionen) {
		this.rechnungspositionen =  rechnungspositionen;
	}


	/**
	 * Gets the kunde.
	 *
	 * @return the kunde
	 */
	public Kunde getKunde() {
		return kunde;
	}


	/**
	 * Sets the kunde.
	 *
	 * @param kunde the new kunde
	 */
	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}


	/**
	 * Gets the rid.
	 *
	 * @return the rid
	 */
	public int getRid() {
		return rid;
	}
	
	/**
	 * Gets the timestamp.
	 *
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}
	
	
}
