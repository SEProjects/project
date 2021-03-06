
package de.autovermietung.onlinesystem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für dreck complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="dreck">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="auto" type="{http://onlineSystem.autovermietung.de/}auto" minOccurs="0"/>
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
@XmlType(name = "dreck", propOrder = {
    "auto",
    "kunde"
})
public class Dreck {

    protected Auto auto;
    protected Kunde kunde;

    /**
     * Ruft den Wert der auto-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Auto }
     *     
     */
    public Auto getAuto() {
        return auto;
    }

    /**
     * Legt den Wert der auto-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Auto }
     *     
     */
    public void setAuto(Auto value) {
        this.auto = value;
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
