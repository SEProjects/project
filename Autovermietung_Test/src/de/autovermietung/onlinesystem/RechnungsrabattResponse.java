
package de.autovermietung.onlinesystem;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für rechnungsrabattResponse complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="rechnungsrabattResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://onlineSystem.autovermietung.de/}returncodeResponse">
 *       &lt;sequence>
 *         &lt;element name="rabatt" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rechnungsrabattResponse", propOrder = {
    "rabatt"
})
public class RechnungsrabattResponse
    extends ReturncodeResponse
{

    protected BigDecimal rabatt;

    /**
     * Ruft den Wert der rabatt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRabatt() {
        return rabatt;
    }

    /**
     * Legt den Wert der rabatt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRabatt(BigDecimal value) {
        this.rabatt = value;
    }

}
