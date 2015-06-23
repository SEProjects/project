
package de.autovermietung.onlinesystem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für saveMarke complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="saveMarke">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Sessionid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="MarkenId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Markenname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "saveMarke", propOrder = {
    "sessionid",
    "markenId",
    "markenname"
})
public class SaveMarke {

    @XmlElement(name = "Sessionid")
    protected int sessionid;
    @XmlElement(name = "MarkenId")
    protected int markenId;
    @XmlElement(name = "Markenname")
    protected String markenname;

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
     * Ruft den Wert der markenId-Eigenschaft ab.
     * 
     */
    public int getMarkenId() {
        return markenId;
    }

    /**
     * Legt den Wert der markenId-Eigenschaft fest.
     * 
     */
    public void setMarkenId(int value) {
        this.markenId = value;
    }

    /**
     * Ruft den Wert der markenname-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarkenname() {
        return markenname;
    }

    /**
     * Legt den Wert der markenname-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarkenname(String value) {
        this.markenname = value;
    }

}
