package de.fhm.autovermietung.auto;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import de.fhm.autovermietung.client.Auto;



/**
 * Session Bean implementation class Autoimpl
 */
@Stateless
@Remote(Auto.class)
public class Autoimpl implements Auto{

    /**
     * Default constructor. 
     */
    public Autoimpl() {
        // TODO Auto-generated constructor stub
    }
    

}
