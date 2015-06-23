package de.autovermietung.dao;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

import de.autovermietung.entities.Auto;
import de.autovermietung.entities.Autoart;
import de.autovermietung.entities.Dreck;
import de.autovermietung.entities.FSA;
import de.autovermietung.entities.Kraftstoff;
import de.autovermietung.entities.Kunde;
import de.autovermietung.entities.Marke;
import de.autovermietung.entities.Mieten;
import de.autovermietung.entities.PLZ;
import de.autovermietung.entities.Rechnung;
import de.autovermietung.entities.Schaden;



// TODO: Auto-generated Javadoc
/**
 * Session Bean implementation class Databuilder.
 */

@Startup
@Singleton
@LocalBean
public class Databuilder {
	
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(Databuilder.class);

		/** The em. */
		@PersistenceContext
		EntityManager em;
		
		

		/**
		 * Inits the.
		 */
		@PostConstruct
		private void init() { 
		}
		
			
			/**
		}
     * Default constructor. 
     */
    public Databuilder() {
        // TODO Auto-generated constructor stub
    }

}
