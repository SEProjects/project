
package de.autovermietung.onlinesystem;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für autoArtResponse complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="autoArtResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://onlineSystem.autovermietung.de/}returncodeResponse">
 *       &lt;sequence>
 *         &lt;element name="aaid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="beschreibung" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bildlink" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kofferraumvolumen" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="kraftstoffverbrauch" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="ks" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="marke" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pjk" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ps" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sitzanzahl" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "autoArtResponse", propOrder = {
    "aaid",
    "beschreibung",
    "bildlink",
    "kofferraumvolumen",
    "kraftstoffverbrauch",
    "ks",
    "marke",
    "pjk",
    "ps",
    "sitzanzahl"
})
public class AutoArtResponse
    extends ReturncodeResponse
{

    protected int aaid;
    protected String beschreibung;
    protected String bildlink;
    protected int kofferraumvolumen;
    protected double kraftstoffverbrauch;
    protected int ks;
    protected int marke;
    protected BigDecimal pjk;
    protected int ps;
    protected int sitzanzahl;

    /**
     * Ruft den Wert der aaid-Eigenschaft ab.
     * 
     */
    public int getAaid() {
        return aaid;
    }

    /**
     * Legt den Wert der aaid-Eigenschaft fest.
     * 
     */
    public void setAaid(int value) {
        this.aaid = value;
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
     * Ruft den Wert der bildlink-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBildlink() {
        return bildlink;
    }

    /**
     * Legt den Wert der bildlink-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBildlink(String value) {
        this.bildlink = value;
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
     */
    public double getKraftstoffverbrauch() {
        return kraftstoffverbrauch;
    }

    /**
     * Legt den Wert der kraftstoffverbrauch-Eigenschaft fest.
     * 
     */
    public void setKraftstoffverbrauch(double value) {
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
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPjk() {
        return pjk;
    }

    /**
     * Legt den Wert der pjk-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPjk(BigDecimal value) {
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
