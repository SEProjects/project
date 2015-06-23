
package de.autovermietung.onlinesystem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für neuerEintragResponse complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="neuerEintragResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://onlineSystem.autovermietung.de/}returncodeResponse">
 *       &lt;sequence>
 *         &lt;element name="successful" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "neuerEintragResponse", propOrder = {
    "successful"
})
public class NeuerEintragResponse
    extends ReturncodeResponse
{

    protected boolean successful;

    /**
     * Ruft den Wert der successful-Eigenschaft ab.
     * 
     */
    public boolean isSuccessful() {
        return successful;
    }

    /**
     * Legt den Wert der successful-Eigenschaft fest.
     * 
     */
    public void setSuccessful(boolean value) {
        this.successful = value;
    }

}
