
package de.autovermietung.onlinesystem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für saveKunde complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="saveKunde">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Sessionid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Kundeemail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kvorname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="knachname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fsnummer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="aktive" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="admin" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="strasse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "saveKunde", propOrder = {
    "sessionid",
    "kundeemail",
    "kvorname",
    "knachname",
    "fsnummer",
    "pan",
    "aktive",
    "admin",
    "strasse"
})
public class SaveKunde {

    @XmlElement(name = "Sessionid")
    protected int sessionid;
    @XmlElement(name = "Kundeemail")
    protected String kundeemail;
    protected String kvorname;
    protected String knachname;
    protected String fsnummer;
    protected String pan;
    protected boolean aktive;
    protected boolean admin;
    protected String strasse;

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
     * Ruft den Wert der kundeemail-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKundeemail() {
        return kundeemail;
    }

    /**
     * Legt den Wert der kundeemail-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKundeemail(String value) {
        this.kundeemail = value;
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

}
