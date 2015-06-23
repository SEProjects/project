
package de.autovermietung.onlinesystem;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für auto complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="auto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="autoart" type="{http://onlineSystem.autovermietung.de/}autoart" minOccurs="0"/>
 *         &lt;element name="bewertungen" type="{http://onlineSystem.autovermietung.de/}bewertung" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bez" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dreck" type="{http://onlineSystem.autovermietung.de/}dreck" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="gemietet" type="{http://onlineSystem.autovermietung.de/}mieten" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="position" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="schaden" type="{http://onlineSystem.autovermietung.de/}schaden" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "auto", propOrder = {
    "autoart",
    "bewertungen",
    "bez",
    "dreck",
    "gemietet",
    "position",
    "schaden"
})
public class Auto {

    protected Autoart autoart;
    @XmlElement(nillable = true)
    protected List<Bewertung> bewertungen;
    protected String bez;
    @XmlElement(nillable = true)
    protected List<Dreck> dreck;
    @XmlElement(nillable = true)
    protected List<Mieten> gemietet;
    protected String position;
    @XmlElement(nillable = true)
    protected List<Schaden> schaden;

    /**
     * Ruft den Wert der autoart-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Autoart }
     *     
     */
    public Autoart getAutoart() {
        return autoart;
    }

    /**
     * Legt den Wert der autoart-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Autoart }
     *     
     */
    public void setAutoart(Autoart value) {
        this.autoart = value;
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
     * Ruft den Wert der bez-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBez() {
        return bez;
    }

    /**
     * Legt den Wert der bez-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBez(String value) {
        this.bez = value;
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
     * Ruft den Wert der position-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosition() {
        return position;
    }

    /**
     * Legt den Wert der position-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosition(String value) {
        this.position = value;
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

}
