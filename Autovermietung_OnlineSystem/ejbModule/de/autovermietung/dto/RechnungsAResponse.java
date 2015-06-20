package de.autovermietung.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;



/**
 * @author Kevin Haase
 *  Responseklasse für den Aufruf  {@link de.autovermietung.onlineSystem.OnlineAdminIntegration#getRechnung(int, int) getRechnung}
 */
public class RechnungsAResponse extends ReturncodeResponse {
	
	/** Rechnungsid. */
	private int rid;

	/**Gesamtpreis. */
	private BigDecimal gesamtpreis;
	
	/** timestamp. */
	private Date timestamp;
	
	/** 'Mwst. */
	private BigDecimal mwst;
	
	/** Vorpreis. */
	private BigDecimal vorpreis;
	
	/** Rabatt. */
	private BigDecimal rabatt;
	
	
	/** Datensaetze der mieten in der Rechnung */
	private List<Object[]> Datensaetze;
	
	/** Bezahlmethode. */
	private String bezahlmethode;
	
	/** Kundenemail. */
	private String kunde;

	/**
	 * Gets Rechnungsid.
	 *
	 * @return  rid
	 */
	public int getRid() {
		return rid;
	}

	/**
	 * Sets the rid in der Response.
	 *
	 * @param rid neue rid
	 */
	public void setRid(int rid) {
		this.rid = rid;
	}

	/**
	 * Gets gesamtpreis.
	 *
	 * @return gesamtpreis
	 */
	public BigDecimal getGesamtpreis() {
		return gesamtpreis;
	}

	/**
	 * Sets gesamtpreis in der Response.
	 *
	 * @param gesamtpreis neuer gesamtpreis
	 */
	public void setGesamtpreis(BigDecimal gesamtpreis) {
		this.gesamtpreis = gesamtpreis;
	}

	/**
	 * Gets timestamp.
	 *
	 * @return timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * Sets timestamp in der Response.
	 *
	 * @param timestamp neuer timestamp
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * Gets mwst.
	 *
	 * @return  mwst
	 */
	public BigDecimal getMwst() {
		return mwst;
	}

	/**
	 * Sets mwst.
	 *
	 * @param mwst neuer mwst
	 */
	public void setMwst(BigDecimal mwst) {
		this.mwst = mwst;
	}

	/**
	 * Gets vorpreis.
	 *
	 * @return vorpreis
	 */
	public BigDecimal getVorpreis() {
		return vorpreis;
	}

	/**
	 * Sets vorpreis in der Response.
	 *
	 * @param vorpreis the new vorpreis
	 */
	public void setVorpreis(BigDecimal vorpreis) {
		this.vorpreis = vorpreis;
	}

	/**
	 * Gets rabatt.
	 *
	 * @return rabatt
	 */
	public BigDecimal getRabatt() {
		return rabatt;
	}

	/**
	 * Sets  rabatt in der Response.
	 *
	 * @param rabatt neuer rabatt
	 */
	public void setRabatt(BigDecimal rabatt) {
		this.rabatt = rabatt;
	}

	/**
	 * Gets  datensaetze.
	 *
	 * @return datensaetze
	 */
	public List<Object[]> getDatensaetze() {
		return Datensaetze;
	}

	/**
	 * Sets datensaetze in der Response .
	 *
	 * @param datensaetze neue datensaetze
	 */
	public void setDatensaetze(List<Object[]> datensaetze) {
		Datensaetze = datensaetze;
	}

	/**
	 * Gets  bezahlmethode.
	 *
	 * @return  bezahlmethode
	 */
	public String getBezahlmethode() {
		return bezahlmethode;
	}

	/**
	 * Sets bezahlmethode in der Response.
	 *
	 * @param bezahlmethode neue bezahlmethode
	 */
	public void setBezahlmethode(String bezahlmethode) {
		this.bezahlmethode = bezahlmethode;
	}

	/**
	 * Gets kunde.
	 *
	 * @return  kunde
	 */
	public String getKunde() {
		return kunde;
	}

	/**
	 * Sets  kunde in der Response.
	 *
	 * @param kunde neuer kunde
	 */
	public void setKunde(String kunde) {
		this.kunde = kunde;
	}
}
