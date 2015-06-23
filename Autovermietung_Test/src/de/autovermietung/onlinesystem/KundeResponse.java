
package de.autovermietung.onlinesystem;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für kundeResponse complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="kundeResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://onlineSystem.autovermietung.de/}returncodeResponse">
 *       &lt;sequence>
 *         &lt;element name="admin" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="aktive" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fsaName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fsnummer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gemietet" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="knachname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kvorname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="plz" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strasse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wohnort" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "kundeResponse", propOrder = {
    "admin",
    "aktive",
    "email",
    "fsaName",
    "fsnummer",
    "gemietet",
    "knachname",
    "kvorname",
    "pan",
    "plz",
    "strasse",
    "wohnort"
})
public class KundeResponse
    extends ReturncodeResponse
{

    protected boolean admin;
    protected boolean aktive;
    protected String email;
    protected String fsaName;
    protected String fsnummer;
    @XmlElement(nillable = true)
    protected List<Integer> gemietet;
    protected String knachname;
    protected String kvorname;
    protected String pan;
    protected String plz;
    protected String strasse;
    protected String wohnort;

    /**
     * Ruft den Wert der admin-Eigenschaft ab.
     * 
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * Legt den Wert der admin-Eigenschaft fest.
     * 
     */
    public void setAdmin(boolean value) {
        this.admin = value;
    }

    /**
     * Ruft den Wert der aktive-Eigenschaft ab.
     * 
     */
    public boolean isAktive() {
        return aktive;
    }

    /**
     * Legt den Wert der aktive-Eigenschaft fest.
     * 
     */
    public void setAktive(boolean value) {
        this.aktive = value;
    }

    /**
     * Ruft den Wert der email-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Legt den Wert der email-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Ruft den Wert der fsaName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFsaName() {
        return fsaName;
    }

    /**
     * Legt den Wert der fsaName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFsaName(String value) {
        this.fsaName = value;
    }

    /**
     * Ruft den Wert der fsnummer-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFsnummer() {
        return fsnummer;
    }

    /**
     * Legt den Wert der fsnummer-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFsnummer(String value) {
        this.fsnummer = value;
    }

    /**
     * Gets the value of the gemietet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the gemietet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGemietet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getGemietet() {
        if (gemietet == null) {
            gemietet = new ArrayList<Integer>();
        }
        return this.gemietet;
    }

    /**
     * Ruft den Wert der knachname-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKnachname() {
        return knachname;
    }

    /**
     * Legt den Wert der knachname-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKnachname(String value) {
        this.knachname = value;
    }

    /**
     * Ruft den Wert der kvorname-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKvorname() {
        return kvorname;
    }

    /**
     * Legt den Wert der kvorname-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKvorname(String value) {
        this.kvorname = value;
    }

    /**
     * Ruft den Wert der pan-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPan() {
        return pan;
    }

    /**
     * Legt den Wert der pan-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPan(String value) {
        this.pan = value;
    }

    /**
     * Ruft den Wert der plz-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlz() {
        return plz;
    }

    /**
     * Legt den Wert der plz-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlz(String value) {
        this.plz = value;
    }

    /**
     * Ruft den Wert der strasse-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrasse() {
        return strasse;
    }

    /**
     * Legt den Wert der strasse-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrasse(String value) {
        this.strasse = value;
    }

    /**
     * Ruft den Wert der wohnort-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWohnort() {
        return wohnort;
    }

    /**
     * Legt den Wert der wohnort-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWohnort(String value) {
        this.wohnort = value;
    }

}
