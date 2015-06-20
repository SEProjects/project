package de.autovermietung.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


// TODO: Auto-generated Javadoc
/**
 * The Class RechnungsAResponse.
 */
public class RechnungsAResponse extends ReturncodeResponse {
	
	/** The rid. */
	private int rid;

	/** The gesamtpreis. */
	private BigDecimal gesamtpreis;
	
	/** The timestamp. */
	private Date timestamp;
	
	/** The mwst. */
	private BigDecimal mwst;
	
	/** The vorpreis. */
	private BigDecimal vorpreis;
	
	/** The rabatt. */
	private BigDecimal rabatt;
	
	
	/** The Datensaetze. */
	private List<Object[]> Datensaetze;
	
	/** The bezahlmethode. */
	private String bezahlmethode;
	
	/** The kunde. */
	private String kunde;

	/**
	 * Gets the rid.
	 *
	 * @return the rid
	 */
	public int getRid() {
		return rid;
	}

	/**
	 * Sets the rid.
	 *
	 * @param rid the new rid
	 */
	public void setRid(int rid) {
		this.rid = rid;
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
	 * Gets the timestamp.
	 *
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * Sets the timestamp.
	 *
	 * @param timestamp the new timestamp
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
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
	}

	/**
	 * Gets the datensaetze.
	 *
	 * @return the datensaetze
	 */
	public List<Object[]> getDatensaetze() {
		return Datensaetze;
	}

	/**
	 * Sets the datensaetze.
	 *
	 * @param datensaetze the new datensaetze
	 */
	public void setDatensaetze(List<Object[]> datensaetze) {
		Datensaetze = datensaetze;
	}

	/**
	 * Gets the bezahlmethode.
	 *
	 * @return the bezahlmethode
	 */
	public String getBezahlmethode() {
		return bezahlmethode;
	}

	/**
	 * Sets the bezahlmethode.
	 *
	 * @param bezahlmethode the new bezahlmethode
	 */
	public void setBezahlmethode(String bezahlmethode) {
		this.bezahlmethode = bezahlmethode;
	}

	/**
	 * Gets the kunde.
	 *
	 * @return the kunde
	 */
	public String getKunde() {
		return kunde;
	}

	/**
	 * Sets the kunde.
	 *
	 * @param kunde the new kunde
	 */
	public void setKunde(String kunde) {
		this.kunde = kunde;
	}
}
