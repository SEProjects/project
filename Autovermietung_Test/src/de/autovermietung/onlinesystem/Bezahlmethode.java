
package de.autovermietung.onlinesystem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für bezahlmethode complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="bezahlmethode">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bmid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="kunde" type="{http://onlineSystem.autovermietung.de/}kunde" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bezahlmethode", propOrder = {
    "bmid",
    "kunde"
})
public class Bezahlmethode {

    protected int bmid;
    protected Kunde kunde;

    /**
     * Ruft den Wert der bmid-Eigenschaft ab.
     * 
     */
    public int getBmid() {
        return bmid;
    }

    /**
     * Legt den Wert der bmid-Eigenschaft fest.
     * 
     */
    public void setBmid(int value) {
        this.bmid = value;
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

}
