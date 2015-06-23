
package de.autovermietung.onlinesystem;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für kunde complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="kunde">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="admin" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="aktive" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="bewertungen" type="{http://onlineSystem.autovermietung.de/}bewertung" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bezahlmethoden" type="{http://onlineSystem.autovermietung.de/}bezahlmethode" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dreck" type="{http://onlineSystem.autovermietung.de/}dreck" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fsa" type="{http://onlineSystem.autovermietung.de/}fsa" minOccurs="0"/>
 *         &lt;element name="fsnummer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gemietet" type="{http://onlineSystem.autovermietung.de/}mieten" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="knachname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kpassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kplz" type="{http://onlineSystem.autovermietung.de/}plz" minOccurs="0"/>
 *         &lt;element name="kvorname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="link" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rechnungen" type="{http://onlineSystem.autovermietung.de/}Rechnung2" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="saf" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="schaden" type="{http://onlineSystem.autovermietung.de/}schaden" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "kunde", propOrder = {
    "admin",
    "aktive",
    "bewertungen",
    "bezahlmethoden",
    "dreck",
    "email",
    "fsa",
    "fsnummer",
    "gemietet",
    "knachname",
    "kpassword",
    "kplz",
    "kvorname",
    "link",
    "pan",
    "rechnungen",
    "saf",
    "schaden",
    "strasse"
})
public class Kunde {

    protected boolean admin;
    protected boolean aktive;
    @XmlElement(nillable = true)
    protected List<Bewertung> bewertungen;
    @XmlElement(nillable = true)
    protected List<Bezahlmethode> bezahlmethoden;
    @XmlElement(nillable = true)
    protected List<Dreck> dreck;
    protected String email;
    protected Fsa fsa;
    protected String fsnummer;
    @XmlElement(nillable = true)
    protected List<Mieten> gemietet;
    protected String knachname;
    protected String kpassword;
    protected Plz kplz;
    protected String kvorname;
    protected String link;
    protected String pan;
    @XmlElement(nillable = true)
    protected List<Rechnung2> rechnungen;
    protected boolean saf;
    @XmlElement(nillable = true)
    protected List<Schaden> schaden;
    protected String strasse;

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
     * Gets the value of the bewertungen property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bewertungen property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBewertungen().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Bewertung }
     * 
     * 
     */
    public List<Bewertung> getBewertungen() {
        if (bewertungen == null) {
            bewertungen = new ArrayList<Bewertung>();
        }
        return this.bewertungen;
    }

    /**
     * Gets the value of the bezahlmethoden property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bezahlmethoden property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBezahlmethoden().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Bezahlmethode }
     * 
     * 
     */
    public List<Bezahlmethode> getBezahlmethoden() {
        if (bezahlmethoden == null) {
            bezahlmethoden = new ArrayList<Bezahlmethode>();
        }
        return this.bezahlmethoden;
    }

    /**
     * Gets the value of the dreck property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dreck property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDreck().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Dreck }
     * 
     * 
     */
    public List<Dreck> getDreck() {
        if (dreck == null) {
            dreck = new ArrayList<Dreck>();
        }
        return this.dreck;
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
     * Ruft den Wert der fsa-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Fsa }
     *     
     */
    public Fsa getFsa() {
        return fsa;
    }

    /**
     * Legt den Wert der fsa-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Fsa }
     *     
     */
    public void setFsa(Fsa value) {
        this.fsa = value;
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
     * {@link Mieten }
     * 
     * 
     */
    public List<Mieten> getGemietet() {
        if (gemietet == null) {
            gemietet = new ArrayList<Mieten>();
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
     * Ruft den Wert der kpassword-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKpassword() {
        return kpassword;
    }

    /**
     * Legt den Wert der kpassword-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKpassword(String value) {
        this.kpassword = value;
    }

    /**
     * Ruft den Wert der kplz-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Plz }
     *     
     */
    public Plz getKplz() {
        return kplz;
    }

    /**
     * Legt den Wert der kplz-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Plz }
     *     
     */
    public void setKplz(Plz value) {
        this.kplz = value;
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
     * Ruft den Wert der link-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLink() {
        return link;
    }

    /**
     * Legt den Wert der link-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLink(String value) {
        this.link = value;
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
     * Gets the value of the rechnungen property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rechnungen property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRechnungen().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Rechnung2 }
     * 
     * 
     */
    public List<Rechnung2> getRechnungen() {
        if (rechnungen == null) {
            rechnungen = new ArrayList<Rechnung2>();
        }
        return this.rechnungen;
    }

    /**
     * Ruft den Wert der saf-Eigenschaft ab.
     * 
     */
    public boolean isSaf() {
        return saf;
    }

    /**
     * Legt den Wert der saf-Eigenschaft fest.
     * 
     */
    public void setSaf(boolean value) {
        this.saf = value;
    }

    /**
     * Gets the value of the schaden property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the schaden property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSchaden().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Schaden }
     * 
     * 
     */
    public List<Schaden> getSchaden() {
        if (schaden == null) {
            schaden = new ArrayList<Schaden>();
        }
        return this.schaden;
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
