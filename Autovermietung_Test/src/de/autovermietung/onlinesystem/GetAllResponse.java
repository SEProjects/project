
package de.autovermietung.onlinesystem;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import net.java.dev.jaxb.array.AnyTypeArray;


/**
 * <p>Java-Klasse für getAllResponse complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="getAllResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://onlineSystem.autovermietung.de/}returncodeResponse">
 *       &lt;sequence>
 *         &lt;element name="datensaetze" type="{http://jaxb.dev.java.net/array}anyTypeArray" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAllResponse", propOrder = {
    "datensaetze"
})
public class GetAllResponse
    extends ReturncodeResponse
{

    @XmlElement(nillable = true)
    protected List<AnyTypeArray> datensaetze;

    /**
     * Gets the value of the datensaetze property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the datensaetze property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDatensaetze().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AnyTypeArray }
     * 
     * 
     */
    public List<AnyTypeArray> getDatensaetze() {
        if (datensaetze == null) {
            datensaetze = new ArrayList<AnyTypeArray>();
        }
        return this.datensaetze;
    }

}
