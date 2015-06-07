package de.autovermietung.dao;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

import de.autovermietung.entities.FSA;
import de.autovermietung.entities.Kunde;
import de.autovermietung.entities.PLZ;



/**
 * Session Bean implementation class Databuilder
 */

@Startup
@Singleton
@LocalBean
public class Databuilder {
	private static final Logger logger = Logger.getLogger(Databuilder.class);

		@PersistenceContext
		EntityManager em;
		
		

		@PostConstruct
		private void init() { 
			Kunde customer1 = em.find(Kunde.class, "Kevin@web.de");
			if (customer1 == null) {
				boolean admin = false;
				PLZ kplz = new PLZ("48153","Münster");
				em.persist(kplz);
				logger.info(kplz);
				FSA newFSA = new FSA("LKW");
				em.persist(newFSA);
				logger.info(newFSA);
				Kunde newKunde = new Kunde("Kevin@web.de","asfd","asdf","1234","asds","asdf","asdf",true,false,newFSA,kplz);
				newFSA.addKunde(newKunde);
				kplz.addKunde(newKunde);
				em.persist(newKunde);
			
			}
			
		}

			
			/**
		}
     * Default constructor. 
     */
    public Databuilder() {
        // TODO Auto-generated constructor stub
    }

}
