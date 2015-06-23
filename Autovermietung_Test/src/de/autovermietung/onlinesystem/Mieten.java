
package de.autovermietung.onlinesystem;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für mieten complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="mieten">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="abgerechnet" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="anfangskm" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="auto" type="{http://onlineSystem.autovermietung.de/}auto" minOccurs="0"/>
 *         &lt;element name="diff" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="endkm" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="kunde" type="{http://onlineSystem.autovermietung.de/}kunde" minOccurs="0"/>
 *         &lt;element name="rechnung" type="{http://onlineSystem.autovermietung.de/}Rechnung2" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mieten", propOrder = {
    "abgerechnet",
    "anfangskm",
    "auto",
    "diff",
    "endkm",
    "kunde",
    "rechnung"
})
public class Mieten {

    protected boolean abgerechnet;
    protected double anfangskm;
    protected Auto auto;
    protected BigDecimal diff;
    protected double endkm;
    protected Kunde kunde;
    protected Rechnung2 rechnung;

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
     * Ruft den Wert der anfangskm-Eigenschaft ab.
     * 
     */
    public double getAnfangskm() {
        return anfangskm;
    }

    /**
     * Legt den Wert der anfangskm-Eigenschaft fest.
     * 
     */
    public void setAnfangskm(double value) {
        this.anfangskm = value;
    }

    /**
     * Ruft den Wert der auto-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Auto }
     *     
     */
    public Auto getAuto() {
        return auto;
    }

    /**
     * Legt den Wert der auto-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Auto }
     *     
     */
    public void setAuto(Auto value) {
        this.auto = value;
    }

    /**
     * Ruft den Wert der diff-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDiff() {
        return diff;
    }

    /**
     * Legt den Wert der diff-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDiff(BigDecimal value) {
        this.diff = value;
    }

    /**
     * Ruft den Wert der endkm-Eigenschaft ab.
     * 
     */
    public double getEndkm() {
        return endkm;
    }

    /**
     * Legt den Wert der endkm-Eigenschaft fest.
     * 
     */
    public void setEndkm(double value) {
        this.endkm = value;
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
     * Ruft den Wert der rechnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Rechnung2 }
     *     
     */
    public Rechnung2 getRechnung() {
        return rechnung;
    }

    /**
     * Legt den Wert der rechnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Rechnung2 }
     *     
     */
    public void setRechnung(Rechnung2 value) {
        this.rechnung = value;
    }

}
