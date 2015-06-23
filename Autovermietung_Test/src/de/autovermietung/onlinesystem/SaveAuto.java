
package de.autovermietung.onlinesystem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für saveAuto complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="saveAuto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Sessionid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Autoid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="bez" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AAid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "saveAuto", propOrder = {
    "sessionid",
    "autoid",
    "bez",
    "aAid"
})
public class SaveAuto {

    @XmlElement(name = "Sessionid")
    protected int sessionid;
    @XmlElement(name = "Autoid")
    protected int autoid;
    protected String bez;
    @XmlElement(name = "AAid")
    protected int aAid;

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
     * Ruft den Wert der autoid-Eigenschaft ab.
     * 
     */
    public int getAutoid() {
        return autoid;
    }

    /**
     * Legt den Wert der autoid-Eigenschaft fest.
     * 
     */
    public void setAutoid(int value) {
        this.autoid = value;
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

}
