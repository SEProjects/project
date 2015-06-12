package de.autovermietung.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import java.util.ArrayList;

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
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="rechnung") 
	private List<mieten> rechnungspositionen;
	
	@ManyToOne(optional=false)
	private Kunde kunde;
	private boolean abgerechnet;
	
	public boolean isAbgerechnet() {
		return abgerechnet;
	}


	public void setAbgerechnet(boolean abgerechnet) {
		this.abgerechnet = abgerechnet;
	}


	public Rechnung(){
		
	}


	public Rechnung(BigDecimal gesamtpreis, BigDecimal mwst, Kunde kunde) {
		super();
		this.gesamtpreis = gesamtpreis;
		this.mwst = mwst;
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
