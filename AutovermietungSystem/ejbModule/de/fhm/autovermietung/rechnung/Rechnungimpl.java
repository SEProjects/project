package de.fhm.autovermietung.rechnung;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import de.fhm.autovermietung.client.Rechnung;

/**
 * Session Bean implementation class Rechnungimpl
 */
@Stateless
@Remote(Rechnung.class)
public class Rechnungimpl implements Rechnung{

    /**
     * Default constructor. 
     */
    public Rechnungimpl() {
        // TODO Auto-generated constructor stub
    }

}
