
package de.autovermietung.onlinesystem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import net.java.dev.jaxb.array.AnyTypeArray;


/**
 * <p>Java-Klasse für rechnungsAResponse complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="rechnungsAResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://onlineSystem.autovermietung.de/}returncodeResponse">
 *       &lt;sequence>
 *         &lt;element name="bezahlmethode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="datensaetze" type="{http://jaxb.dev.java.net/array}anyTypeArray" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="gesamtpreis" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="kunde" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mwst" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="rabatt" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="rid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="vorpreis" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rechnungsAResponse", propOrder = {
    "bezahlmethode",
    "datensaetze",
    "gesamtpreis",
    "kunde",
    "mwst",
    "rabatt",
    "rid",
    "timestamp",
    "vorpreis"
})
public class RechnungsAResponse
    extends ReturncodeResponse
{

    protected String bezahlmethode;
    @XmlElement(nillable = true)
    protected List<AnyTypeArray> datensaetze;
    protected BigDecimal gesamtpreis;
    protected String kunde;
    protected BigDecimal mwst;
    protected BigDecimal rabatt;
    protected int rid;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timestamp;
    protected BigDecimal vorpreis;

    /**
     * Ruft den Wert der bezahlmethode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBezahlmethode() {
        return bezahlmethode;
    }

    /**
     * Legt den Wert der bezahlmethode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBezahlmethode(String value) {
        this.bezahlmethode = value;
    }

    /**
     * Gets the value of the datensaetze property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the datensaetze property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDatensaetze().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AnyTypeArray }
     * 
     * 
     */
    public List<AnyTypeArray> getDatensaetze() {
        if (datensaetze == null) {
            datensaetze = new ArrayList<AnyTypeArray>();
        }
        return this.datensaetze;
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
     *     {@link String }
     *     
     */
    public String getKunde() {
        return kunde;
    }

    /**
     * Legt den Wert der kunde-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKunde(String value) {
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
     * Ruft den Wert der rid-Eigenschaft ab.
     * 
     */
    public int getRid() {
        return rid;
    }

    /**
     * Legt den Wert der rid-Eigenschaft fest.
     * 
     */
    public void setRid(int value) {
        this.rid = value;
    }

    /**
     * Ruft den Wert der timestamp-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimestamp() {
        return timestamp;
    }

    /**
     * Legt den Wert der timestamp-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimestamp(XMLGregorianCalendar value) {
        this.timestamp = value;
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
