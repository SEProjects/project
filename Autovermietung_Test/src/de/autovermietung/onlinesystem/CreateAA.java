
package de.autovermietung.onlinesystem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für createAA complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="createAA">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Sessionid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="beschreibung" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kofferraumvolumen" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="kraftstoffverbrauch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ks" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="marke" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pjk" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="ps" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sitzanzahl" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createAA", propOrder = {
    "sessionid",
    "beschreibung",
    "kofferraumvolumen",
    "kraftstoffverbrauch",
    "ks",
    "marke",
    "pjk",
    "ps",
    "sitzanzahl"
})
public class CreateAA {

    @XmlElement(name = "Sessionid")
    protected int sessionid;
    protected String beschreibung;
    protected int kofferraumvolumen;
    protected String kraftstoffverbrauch;
    protected int ks;
    protected int marke;
    protected double pjk;
    protected int ps;
    protected int sitzanzahl;

    /**
     * Ruft den Wert der sessionid-Eigenschaft ab.
     * 
     */
    public int getSessionid() {
        return sessionid;
    }

    /**
     * Legt den Wert der sessionid-Eigenschaft fest.
     * 
     */
    public void setSessionid(int value) {
        this.sessionid = value;
    }

    /**
     * Ruft den Wert der beschreibung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeschreibung() {
        return beschreibung;
    }

    /**
     * Legt den Wert der beschreibung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeschreibung(String value) {
        this.beschreibung = value;
    }

    /**
     * Ruft den Wert der kofferraumvolumen-Eigenschaft ab.
     * 
     */
    public int getKofferraumvolumen() {
        return kofferraumvolumen;
    }

    /**
     * Legt den Wert der kofferraumvolumen-Eigenschaft fest.
     * 
     */
    public void setKofferraumvolumen(int value) {
        this.kofferraumvolumen = value;
    }

    /**
     * Ruft den Wert der kraftstoffverbrauch-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKraftstoffverbrauch() {
        return kraftstoffverbrauch;
    }

    /**
     * Legt den Wert der kraftstoffverbrauch-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKraftstoffverbrauch(String value) {
        this.kraftstoffverbrauch = value;
    }

    /**
     * Ruft den Wert der ks-Eigenschaft ab.
     * 
     */
    public int getKs() {
        return ks;
    }

    /**
     * Legt den Wert der ks-Eigenschaft fest.
     * 
     */
    public void setKs(int value) {
        this.ks = value;
    }

    /**
     * Ruft den Wert der marke-Eigenschaft ab.
     * 
     */
    public int getMarke() {
        return marke;
    }

    /**
     * Legt den Wert der marke-Eigenschaft fest.
     * 
     */
    public void setMarke(int value) {
        this.marke = value;
    }

    /**
     * Ruft den Wert der pjk-Eigenschaft ab.
     * 
     */
    public double getPjk() {
        return pjk;
    }

    /**
     * Legt den Wert der pjk-Eigenschaft fest.
     * 
     */
    public void setPjk(double value) {
        this.pjk = value;
    }

    /**
     * Ruft den Wert der ps-Eigenschaft ab.
     * 
     */
    public int getPs() {
        return ps;
    }

    /**
     * Legt den Wert der ps-Eigenschaft fest.
     * 
     */
    public void setPs(int value) {
        this.ps = value;
    }

    /**
     * Ruft den Wert der sitzanzahl-Eigenschaft ab.
     * 
     */
    public int getSitzanzahl() {
        return sitzanzahl;
    }

    /**
     * Legt den Wert der sitzanzahl-Eigenschaft fest.
     * 
     */
    public void setSitzanzahl(int value) {
        this.sitzanzahl = value;
    }

}
