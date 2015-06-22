package de.autovermietung.dto;

import java.math.BigDecimal;
import java.util.Date;


import de.autovermietung.entities.Auto;
import de.autovermietung.entities.Kunde;
import de.autovermietung.entities.Rechnung;

public class MietenResponse extends ReturncodeResponse {

	private static final long serialVersionUID = 1L;
	private int mid;
	private double anfangskm;
	private double endkm;
	private int autoId;
	private String kundeEmail;
	private Rechnung rechnung;
	private BigDecimal diff;
	private String timestamp;
	private boolean abgerechnet;
	/**
	 * @return the mid
	 */
	public int getMid() {
		return mid;
	}
	/**
	 * @param mid the mid to set
	 */
	public void setMid(int mid) {
		this.mid = mid;
	}
	/**
	 * @return the anfangskm
	 */
	public double getAnfangskm() {
		return anfangskm;
	}
	/**
	 * @param anfangskm the anfangskm to set
	 */
	public void setAnfangskm(double anfangskm) {
		this.anfangskm = anfangskm;
	}
	/**
	 * @return the endkm
	 */
	public double getEndkm() {
		return endkm;
	}
	/**
	 * @param endkm the endkm to set
	 */
	public void setEndkm(double endkm) {
		this.endkm = endkm;
	}
	/**
	 * @return the auto
	 */
	public int getAutoId() {
		return autoId;
	}
	/**
	 * @param auto the auto to set
	 */
	public void setAutoId(int autoId) {
		this.autoId = autoId;
	}
	/**
	 * @return the kunde
	 */
	public String getKundeEmail() {
		return this.kundeEmail;
	}
	/**
	 * @param kunde the kunde to set
	 */
	public void setKundeEmail(String kundeEmail) {
		this.kundeEmail = kundeEmail;
	}
	/**
	 * @return the rechnung
	 */
	public Rechnung getRechnung() {
		return rechnung;
	}
	/**
	 * @param rechnung the rechnung to set
	 */
	public void setRechnung(Rechnung rechnung) {
		this.rechnung = rechnung;
	}
	/**
	 * @return the diff
	 */
	public BigDecimal getDiff() {
		return diff;
	}
	/**
	 * @param diff the diff to set
	 */
	public void setDiff(BigDecimal diff) {
		this.diff = diff;
	}
	/**
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * @return the abgerechnet
	 */
	public boolean isAbgerechnet() {
		return abgerechnet;
	}
	/**
	 * @param abgerechnet the abgerechnet to set
	 */
	public void setAbgerechnet(boolean abgerechnet) {
		this.abgerechnet = abgerechnet;
	}
}
