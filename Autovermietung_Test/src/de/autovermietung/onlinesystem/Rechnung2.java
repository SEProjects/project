
package de.autovermietung.onlinesystem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für Rechnung2 complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Rechnung2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="abgerechnet" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="bezahlt" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="gesamtpreis" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="kunde" type="{http://onlineSystem.autovermietung.de/}kunde" minOccurs="0"/>
 *         &lt;element name="mwst" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="rabatt" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="rechnungspositionen" type="{http://onlineSystem.autovermietung.de/}mieten" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vorpreis" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Rechnung2", propOrder = {
    "abgerechnet",
    "bezahlt",
    "gesamtpreis",
    "kunde",
    "mwst",
    "rabatt",
    "rechnungspositionen",
    "vorpreis"
})
public class Rechnung2 {

    protected boolean abgerechnet;
    protected boolean bezahlt;
    protected BigDecimal gesamtpreis;
    protected Kunde kunde;
    protected BigDecimal mwst;
    protected BigDecimal rabatt;
    @XmlElement(nillable = true)
    protected List<Mieten> rechnungspositionen;
    protected BigDecimal vorpreis;

    /**
     * Ruft den Wert der abgerechnet-Eigenschaft ab.
     * 
     */
    public boolean isAbgerechnet() {
        return abgerechnet;
    }

    /**
     * Legt den Wert der abgerechnet-Eigenschaft fest.
     * 
     */
    public void setAbgerechnet(boolean value) {
        this.abgerechnet = value;
    }

    /**
     * Ruft den Wert der bezahlt-Eigenschaft ab.
     * 
     */
    public boolean isBezahlt() {
        return bezahlt;
    }

    /**
     * Legt den Wert der bezahlt-Eigenschaft fest.
     * 
     */
    public void setBezahlt(boolean value) {
        this.bezahlt = value;
    }

    /**
     * Ruft den Wert der gesamtpreis-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getGesamtpreis() {
        return gesamtpreis;
    }

    /**
     * Legt den Wert der gesamtpreis-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setGesamtpreis(BigDecimal value) {
        this.gesamtpreis = value;
    }

    /**
     * Ruft den Wert der kunde-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Kunde }
     *     
     */
    public Kunde getKunde() {
        return kunde;
    }

    /**
     * Legt den Wert der kunde-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Kunde }
     *     
     */
    public void setKunde(Kunde value) {
        this.kunde = value;
    }

    /**
     * Ruft den Wert der mwst-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMwst() {
        return mwst;
    }

    /**
     * Legt den Wert der mwst-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMwst(BigDecimal value) {
        this.mwst = value;
    }

    /**
     * Ruft den Wert der rabatt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRabatt() {
        return rabatt;
    }

    /**
     * Legt den Wert der rabatt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRabatt(BigDecimal value) {
        this.rabatt = value;
    }

    /**
     * Gets the value of the rechnungspositionen property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rechnungspositionen property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRechnungspositionen().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Mieten }
     * 
     * 
     */
    public List<Mieten> getRechnungspositionen() {
        if (rechnungspositionen == null) {
            rechnungspositionen = new ArrayList<Mieten>();
        }
        return this.rechnungspositionen;
    }

    /**
     * Ruft den Wert der vorpreis-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVorpreis() {
        return vorpreis;
    }

    /**
     * Legt den Wert der vorpreis-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVorpreis(BigDecimal value) {
        this.vorpreis = value;
    }

}
