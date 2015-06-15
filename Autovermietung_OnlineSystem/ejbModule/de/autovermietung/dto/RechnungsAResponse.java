package de.autovermietung.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


public class RechnungsAResponse extends ReturncodeResponse {
	
	private int rid;

	private BigDecimal gesamtpreis;
	private Date timestamp;
	private BigDecimal mwst;
	private BigDecimal vorpreis;
	private BigDecimal rabatt;
	
	
	private List<Object[]> Datensaetze;
	
	private String bezahlmethode;
	
	private String kunde;

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
	}

	public List<Object[]> getDatensaetze() {
		return Datensaetze;
	}

	public void setDatensaetze(List<Object[]> datensaetze) {
		Datensaetze = datensaetze;
	}

	public String getBezahlmethode() {
		return bezahlmethode;
	}

	public void setBezahlmethode(String bezahlmethode) {
		this.bezahlmethode = bezahlmethode;
	}

	public String getKunde() {
		return kunde;
	}

	public void setKunde(String kunde) {
		this.kunde = kunde;
	}
}
