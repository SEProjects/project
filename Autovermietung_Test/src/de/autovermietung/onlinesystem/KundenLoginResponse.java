
package de.autovermietung.onlinesystem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für kundenLoginResponse complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="kundenLoginResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://onlineSystem.autovermietung.de/}returncodeResponse">
 *       &lt;sequence>
 *         &lt;element name="session" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "kundenLoginResponse", propOrder = {
    "session"
})
public class KundenLoginResponse
    extends ReturncodeResponse
{

    protected int session;

    /**
     * Ruft den Wert der session-Eigenschaft ab.
     * 
     */
    public int getSession() {
        return session;
    }

    /**
     * Legt den Wert der session-Eigenschaft fest.
     * 
     */
    public void setSession(int value) {
        this.session = value;
    }

}
