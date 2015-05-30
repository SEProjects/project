package de.autovermietung.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
public class Rechnung implements Serializable{
	public Rechnung(BigDecimal gesamtpreis, BigDecimal mWST,
			Map<Integer, mieten> rechnungspositionen, Kunde kunde) {
		super();
		Gesamtpreis = gesamtpreis;
		MWST = mWST;
		Rechnungspositionen = rechnungspositionen;
		this.kunde = kunde;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int Rid;
	@Column(nullable=false)
	private BigDecimal Gesamtpreis;
	@Column(nullable=false)
	private BigDecimal MWST;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="rechnung") @MapKey
	private Map<Integer,mieten> Rechnungspositionen;
	
	@ManyToOne(optional=false)
	private Kunde kunde;
	
	
	public Rechnung(){
		
	}

	public Rechnung(BigDecimal gesamtpreis, BigDecimal mWST, Kunde kunde) {
		super();
		Gesamtpreis = gesamtpreis;
		MWST = mWST;
		Rechnungspositionen = new HashMap<>();
		this.kunde = kunde;
	}

	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	public int getRid() {
		return Rid;
	}

	public void setRid(int rid) {
		Rid = rid;
	}

	public BigDecimal getGesamtpreis() {
		return Gesamtpreis;
	}

	public void setGesamtpreis(BigDecimal gesamtpreis) {
		Gesamtpreis = gesamtpreis;
	}

	public BigDecimal getMWST() {
		return MWST;
	}

	public void setMWST(BigDecimal mWST) {
		MWST = mWST;
	}

	public Map<Integer, mieten> getRechnungspositionen() {
		return Rechnungspositionen;
	}

	public void setRechnungspositionen(Map<Integer, mieten> rechnungspositionen) {
		Rechnungspositionen = rechnungspositionen;
	}


	
}
