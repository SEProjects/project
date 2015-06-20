package de.autovermietung.dto;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import de.autovermietung.entities.Kunde;
import de.autovermietung.entities.mieten;
// TODO: Auto-generated Javadoc

/**
 * The Class RechnungsResponse.
 */
public class RechnungsResponse extends ReturncodeResponse{

/** The Constant serialVersionUID. */
private static final long serialVersionUID = 1L;

/** The rid. */
private int rid;

/** The gesamtpreis. */
private BigDecimal gesamtpreis;

/** The timestamp. */
private Date timestamp;

/** The mwst. */
private BigDecimal mwst;

/** The rechnungspositionen. */
private List<mieten> rechnungspositionen;

/** The kunde. */
private Kunde kunde;

/** The abgerechnet. */
private boolean abgerechnet;

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
this.rechnungspositionen = rechnungspositionen;
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
}