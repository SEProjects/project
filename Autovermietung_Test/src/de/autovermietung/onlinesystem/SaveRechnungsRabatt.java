
package de.autovermietung.onlinesystem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für saveRechnungsRabatt complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="saveRechnungsRabatt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Sessionid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Rechnungsid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Rabatt" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "saveRechnungsRabatt", propOrder = {
    "sessionid",
    "rechnungsid",
    "rabatt"
})
public class SaveRechnungsRabatt {

    @XmlElement(name = "Sessionid")
    protected int sessionid;
    @XmlElement(name = "Rechnungsid")
    protected int rechnungsid;
    @XmlElement(name = "Rabatt")
    protected double rabatt;

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
     * Ruft den Wert der rechnungsid-Eigenschaft ab.
     * 
     */
    public int getRechnungsid() {
        return rechnungsid;
    }

    /**
     * Legt den Wert der rechnungsid-Eigenschaft fest.
     * 
     */
    public void setRechnungsid(int value) {
        this.rechnungsid = value;
    }

    /**
     * Ruft den Wert der rabatt-Eigenschaft ab.
     * 
     */
    public double getRabatt() {
        return rabatt;
    }

    /**
     * Legt den Wert der rabatt-Eigenschaft fest.
     * 
     */
    public void setRabatt(double value) {
        this.rabatt = value;
    }

}
