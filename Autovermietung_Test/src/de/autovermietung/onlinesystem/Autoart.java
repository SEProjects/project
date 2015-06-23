
package de.autovermietung.onlinesystem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für autoart complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="autoart">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="autos" type="{http://onlineSystem.autovermietung.de/}auto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="beschreibung" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bild" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kofferraumvolumen" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="kraftstoffverbrauch" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="ks" type="{http://onlineSystem.autovermietung.de/}kraftstoff" minOccurs="0"/>
 *         &lt;element name="marke" type="{http://onlineSystem.autovermietung.de/}marke" minOccurs="0"/>
 *         &lt;element name="pjk" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
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
@XmlType(name = "autoart", propOrder = {
    "autos",
    "beschreibung",
    "bild",
    "kofferraumvolumen",
    "kraftstoffverbrauch",
    "ks",
    "marke",
    "pjk",
    "ps",
    "sitzanzahl"
})
public class Autoart {

    @XmlElement(nillable = true)
    protected List<Auto> autos;
    protected String beschreibung;
    protected String bild;
    protected int kofferraumvolumen;
    protected double kraftstoffverbrauch;
    protected Kraftstoff ks;
    protected Marke marke;
    protected BigDecimal pjk;
    protected int ps;
    protected int sitzanzahl;

    /**
     * Gets the value of the autos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the autos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAutos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Auto }
     * 
     * 
     */
    public List<Auto> getAutos() {
        if (autos == null) {
            autos = new ArrayList<Auto>();
        }
        return this.autos;
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
     * Ruft den Wert der bild-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBild() {
        return bild;
    }

    /**
     * Legt den Wert der bild-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBild(String value) {
        this.bild = value;
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
     * @return
     *     possible object is
     *     {@link Kraftstoff }
     *     
     */
    public Kraftstoff getKs() {
        return ks;
    }

    /**
     * Legt den Wert der ks-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Kraftstoff }
     *     
     */
    public void setKs(Kraftstoff value) {
        this.ks = value;
    }

    /**
     * Ruft den Wert der marke-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Marke }
     *     
     */
    public Marke getMarke() {
        return marke;
    }

    /**
     * Legt den Wert der marke-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Marke }
     *     
     */
    public void setMarke(Marke value) {
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
