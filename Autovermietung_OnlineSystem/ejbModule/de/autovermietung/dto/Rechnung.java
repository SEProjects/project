package de.autovermietung.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Rechnung implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int rid;

	private BigDecimal gesamtpreis;
	
	private Date zeit;
	
	private BigDecimal mwst;
	
	
	private List<mieten> rechnungspositionen;
	
	
	private Kunde kunde;
	
	
	public Rechnung(){
		
	}


	public Rechnung(BigDecimal gesamtpreis, BigDecimal mwst, Kunde kunde) {
		super();
		this.gesamtpreis = gesamtpreis;
		this.mwst = mwst;
		this.kunde = kunde;
		rechnungspositionen = new ArrayList<>();
		Calendar currenttime = Calendar.getInstance();
		   this.zeit = new Date((currenttime.getTime()).getTime());
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
	
	public Date getZeit(){
		return zeit;
	}
	
	
}
