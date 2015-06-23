
package de.autovermietung.onlinesystem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für markeResponse complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="markeResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://onlineSystem.autovermietung.de/}returncodeResponse">
 *       &lt;sequence>
 *         &lt;element name="markeid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="markenname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "markeResponse", propOrder = {
    "markeid",
    "markenname"
})
public class MarkeResponse
    extends ReturncodeResponse
{

    protected int markeid;
    protected String markenname;

    /**
     * Ruft den Wert der markeid-Eigenschaft ab.
     * 
     */
    public int getMarkeid() {
        return markeid;
    }

    /**
     * Legt den Wert der markeid-Eigenschaft fest.
     * 
     */
    public void setMarkeid(int value) {
        this.markeid = value;
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
