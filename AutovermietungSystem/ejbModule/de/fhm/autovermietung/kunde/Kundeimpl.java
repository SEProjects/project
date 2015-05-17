package de.fhm.autovermietung.kunde;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import de.fhm.autovermietung.client.Kunde;

/**
 * Session Bean implementation class Kundeimpl
 */
@Stateless
@Remote(Kunde.class)
public class Kundeimpl implements Kunde {

    /**
     * Default constructor. 
     */
    public Kundeimpl() {
        // TODO Auto-generated constructor stub
    }

}
