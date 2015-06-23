
package de.autovermietung.onlinesystem;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für autoResponse complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="autoResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://onlineSystem.autovermietung.de/}returncodeResponse">
 *       &lt;sequence>
 *         &lt;element name="aa" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="aid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="bewertungen" type="{http://onlineSystem.autovermietung.de/}bewertung" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bez" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dreck" type="{http://onlineSystem.autovermietung.de/}dreck" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="gemietet" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="position" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="schaden" type="{http://onlineSystem.autovermietung.de/}schaden" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "autoResponse", propOrder = {
    "aa",
    "aid",
    "bewertungen",
    "bez",
    "dreck",
    "gemietet",
    "position",
    "schaden"
})
public class AutoResponse
    extends ReturncodeResponse
{

    protected int aa;
    protected int aid;
    @XmlElement(nillable = true)
    protected List<Bewertung> bewertungen;
    protected String bez;
    @XmlElement(nillable = true)
    protected List<Dreck> dreck;
    @XmlElement(nillable = true)
    protected List<Integer> gemietet;
    protected String position;
    @XmlElement(nillable = true)
    protected List<Schaden> schaden;

    /**
     * Ruft den Wert der aa-Eigenschaft ab.
     * 
     */
    public int getAa() {
        return aa;
    }

    /**
     * Legt den Wert der aa-Eigenschaft fest.
     * 
     */
    public void setAa(int value) {
        this.aa = value;
    }

    /**
     * Ruft den Wert der aid-Eigenschaft ab.
     * 
     */
    public int getAid() {
        return aid;
    }

    /**
     * Legt den Wert der aid-Eigenschaft fest.
     * 
     */
    public void setAid(int value) {
        this.aid = value;
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
