
package de.autovermietung.onlinesystem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für bewertung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="bewertung">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="auto" type="{http://onlineSystem.autovermietung.de/}auto" minOccurs="0"/>
 *         &lt;element name="kunde" type="{http://onlineSystem.autovermietung.de/}kunde" minOccurs="0"/>
 *         &lt;element name="note" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bewertung", propOrder = {
    "auto",
    "kunde",
    "note"
})
public class Bewertung {

    protected Auto auto;
    protected Kunde kunde;
    protected int note;

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

    /**
     * Ruft den Wert der note-Eigenschaft ab.
     * 
     */
    public int getNote() {
        return note;
    }

    /**
     * Legt den Wert der note-Eigenschaft fest.
     * 
     */
    public void setNote(int value) {
        this.note = value;
    }

}
