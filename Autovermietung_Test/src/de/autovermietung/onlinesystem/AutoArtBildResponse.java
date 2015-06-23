
package de.autovermietung.onlinesystem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für autoArtBildResponse complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="autoArtBildResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://onlineSystem.autovermietung.de/}returncodeResponse">
 *       &lt;sequence>
 *         &lt;element name="bild" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "autoArtBildResponse", propOrder = {
    "bild"
})
public class AutoArtBildResponse
    extends ReturncodeResponse
{

    protected String bild;

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
