
package de.autovermietung.onlinesystem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für saveKS complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="saveKS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Sessionid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="KSId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="KSbezeichnung" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "saveKS", propOrder = {
    "sessionid",
    "ksId",
    "kSbezeichnung"
})
public class SaveKS {

    @XmlElement(name = "Sessionid")
    protected int sessionid;
    @XmlElement(name = "KSId")
    protected int ksId;
    @XmlElement(name = "KSbezeichnung")
    protected String kSbezeichnung;

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
     * Ruft den Wert der ksId-Eigenschaft ab.
     * 
     */
    public int getKSId() {
        return ksId;
    }

    /**
     * Legt den Wert der ksId-Eigenschaft fest.
     * 
     */
    public void setKSId(int value) {
        this.ksId = value;
    }

    /**
     * Ruft den Wert der kSbezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKSbezeichnung() {
        return kSbezeichnung;
    }

    /**
     * Legt den Wert der kSbezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKSbezeichnung(String value) {
        this.kSbezeichnung = value;
    }

}
