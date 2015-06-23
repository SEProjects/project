
package de.autovermietung.onlinesystem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für saveAABild complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="saveAABild">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Sessionid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="AAid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Bild" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "saveAABild", propOrder = {
    "sessionid",
    "aAid",
    "bild"
})
public class SaveAABild {

    @XmlElement(name = "Sessionid")
    protected int sessionid;
    @XmlElement(name = "AAid")
    protected int aAid;
    @XmlElement(name = "Bild")
    protected String bild;

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
     * Ruft den Wert der aAid-Eigenschaft ab.
     * 
     */
    public int getAAid() {
        return aAid;
    }

    /**
     * Legt den Wert der aAid-Eigenschaft fest.
     * 
     */
    public void setAAid(int value) {
        this.aAid = value;
    }

    /**
     * Ruft den Wert der bild-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBild() {
        return bild;
    }

    /**
     * Legt den Wert der bild-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBild(String value) {
        this.bild = value;
    }

}
