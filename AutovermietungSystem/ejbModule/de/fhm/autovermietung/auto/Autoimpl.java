package de.fhm.autovermietung.auto;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebService;

import de.fhm.autovermietung.client.Auto;
import de.fhm.autovermietung.client.AutoWeb;



/**
 * Session Bean implementation class Autoimpl
 */
@Stateless
@Remote(Auto.class)
@WebService
public class Autoimpl implements Auto,AutoWeb{

    /**
     * Default constructor. 
     */
    public Autoimpl() {
        // TODO Auto-generated constructor stub
    }
    public String autoname()
    {
    	
    return "hallo";
    }

}
