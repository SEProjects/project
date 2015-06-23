
package de.autovermietung.onlinesystem;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für kraftstoff complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="kraftstoff">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="autoart" type="{http://onlineSystem.autovermietung.de/}autoart" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ksbezeichnung" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "kraftstoff", propOrder = {
    "autoart",
    "ksbezeichnung"
})
public class Kraftstoff {

    @XmlElement(nillable = true)
    protected List<Autoart> autoart;
    protected String ksbezeichnung;

    /**
     * Gets the value of the autoart property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the autoart property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAutoart().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Autoart }
     * 
     * 
     */
    public List<Autoart> getAutoart() {
        if (autoart == null) {
            autoart = new ArrayList<Autoart>();
        }
        return this.autoart;
    }

    /**
     * Ruft den Wert der ksbezeichnung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKsbezeichnung() {
        return ksbezeichnung;
    }

    /**
     * Legt den Wert der ksbezeichnung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKsbezeichnung(String value) {
        this.ksbezeichnung = value;
    }

}
