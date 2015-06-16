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
@XmlType(name="Rechnung2")
@Entity
public class Rechnung implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int rid;
	@Column(nullable=false)
	private BigDecimal gesamtpreis;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP",nullable=false,updatable = false, insertable = false)
	private Date timestamp;
	@Column(nullable=false)
	private BigDecimal mwst;
	private BigDecimal vorpreis;
	private BigDecimal rabatt;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="rechnung") 
	private List<mieten> rechnungspositionen;
	@ManyToOne
	private Bezahlmethode bezahlmethode;
	@ManyToOne(optional=false)
	private Kunde kunde;
	public BigDecimal getVorpreis() {
		return vorpreis;
	}


	public void setVorpreis(BigDecimal vorpreis) {
		this.vorpreis = vorpreis;
	}


	public BigDecimal getRabatt() {
		return rabatt;
	}


	public void setRabatt(BigDecimal rabatt) {
		this.rabatt = rabatt;
		gesamtpreis = vorpreis.multiply(new BigDecimal(1).subtract(rabatt.divide(new BigDecimal(100))));
		this.mwst = gesamtpreis.multiply(new BigDecimal(0.19));
	}


	public boolean isBezahlt() {
		return bezahlt;
	}


	public void setBezahlt(boolean bezahlt) {
		this.bezahlt = bezahlt;
	}
	private boolean bezahlt;
	private boolean abgerechnet;
	
	public boolean isAbgerechnet() {
		return abgerechnet;
	}


	public void setAbgerechnet(boolean abgerechnet) {
		this.abgerechnet = abgerechnet;
	}


	public Rechnung(){
		
	}


	public Rechnung(Kunde kunde) {
		super();
	
		this.kunde = kunde;
		rechnungspositionen = new ArrayList<>();
	
	}
	public void addRechnungsposition(mieten miet){
		rechnungspositionen.add(miet);
	}

	public BigDecimal getGesamtpreis() {
		return gesamtpreis;
	}


	public void setGesamtpreis(BigDecimal gesamtpreis) {
		this.gesamtpreis = gesamtpreis;
	}


	public BigDecimal getMwst() {
		return mwst;
	}


	public void setMwst(BigDecimal mwst) {
		this.mwst = mwst;
	}


	public List<mieten> getRechnungspositionen() {
		return rechnungspositionen;
	}


	public void setRechnungspositionen(List<mieten> rechnungspositionen) {
		this.rechnungspositionen =  rechnungspositionen;
	}


	public Kunde getKunde() {
		return kunde;
	}


	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}


	public int getRid() {
		return rid;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	
	
}
