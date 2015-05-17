package de.fhm.autovermietung.kunde;

import javax.ejb.Remote;
import javax.ejb.Stateful;

import de.fhm.autovermietung.client.Konto;
import de.fhm.autovermietung.client.Kunde;

/**
 * Session Bean implementation class Kundeimpl
 */
@Stateful
@Remote(Kunde.class)
public class Kundeimpl implements Kunde {
	
	
    /**
     * Default constructor. 
     */
    public Kundeimpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Konto getKonto() {
		// TODO Auto-generated method stub
		return null;
	}

}
