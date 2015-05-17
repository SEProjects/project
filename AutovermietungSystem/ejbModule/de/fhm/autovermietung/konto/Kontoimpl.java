package de.fhm.autovermietung.konto;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import de.fhm.autovermietung.client.Konto;

/**
 * Session Bean implementation class Kontoimpl
 */
@Stateless
@Remote(Konto.class)
public class Kontoimpl implements Konto {

    /**
     * Default constructor. 
     */
    public Kontoimpl() {
        // TODO Auto-generated constructor stub
    }

}
