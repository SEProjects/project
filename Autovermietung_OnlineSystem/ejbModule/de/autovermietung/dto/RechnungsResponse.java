package de.autovermietung.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;



import de.autovermietung.entities.Kunde;
import de.autovermietung.entities.mieten;

public class RechnungsResponse extends ReturncodeResponse{

	private static final long serialVersionUID = 1L;
	private int rid;
	private BigDecimal gesamtpreis;
	private Date timestamp;
	private BigDecimal mwst;
	private List<mieten> rechnungspositionen;
	private Kunde kunde;
	private boolean abgerechnet;
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public BigDecimal getGesamtpreis() {
		return gesamtpreis;
	}
	public void setGesamtpreis(BigDecimal gesamtpreis) {
		this.gesamtpreis = gesamtpreis;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
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
		this.rechnungspositionen = rechnungspositionen;
	}
	public Kunde getKunde() {
		return kunde;
	}
	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}
	public boolean isAbgerechnet() {
		return abgerechnet;
	}
	public void setAbgerechnet(boolean abgerechnet) {
		this.abgerechnet = abgerechnet;
	}
	
}
