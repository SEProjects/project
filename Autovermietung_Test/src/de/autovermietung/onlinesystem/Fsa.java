
package de.autovermietung.onlinesystem;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für fsa complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="fsa">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fsaname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kunden" type="{http://onlineSystem.autovermietung.de/}kunde" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fsa", propOrder = {
    "fsaname",
    "kunden"
})
public class Fsa {

    protected String fsaname;
    @XmlElement(nillable = true)
    protected List<Kunde> kunden;

    /**
     * Ruft den Wert der fsaname-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFsaname() {
        return fsaname;
    }

    /**
     * Legt den Wert der fsaname-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFsaname(String value) {
        this.fsaname = value;
    }

    /**
     * Gets the value of the kunden property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the kunden property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKunden().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Kunde }
     * 
     * 
     */
    public List<Kunde> getKunden() {
        if (kunden == null) {
            kunden = new ArrayList<Kunde>();
        }
        return this.kunden;
    }

}
