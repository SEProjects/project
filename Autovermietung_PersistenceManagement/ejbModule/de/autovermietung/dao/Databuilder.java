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
import de.autovermietung.entities.PLZ;
import de.autovermietung.entities.Schaden;
import de.autovermietung.entities.mieten;



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
				Kunde customer3 = em.find(Kunde.class, "test@web.de");
				logger.info(newKunde);
				if (customer3 == null) {
					
					Kunde newKunde2 = new Kunde("test@web.de","asss","asss","1234","asdsaa","avs","aaf",true,false,newFSA,kplz);
					newFSA.addKunde(newKunde2);
					kplz.addKunde(newKunde2);
					em.persist(newKunde2);
					logger.info(newKunde2);
				
				}
						
				
					
				
				}

			Kunde customer2 = em.find(Kunde.class, "test@web.de");
			if (customer2 == null) {
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
				Kunde customer3 = em.find(Kunde.class, "test@web.de");
				if (customer3 == null) {
					
					Kunde newKunde2 = new Kunde("test@web.de","asss","asss","1234","asdsaa","avs","aaf",true,false,newFSA,kplz);
					newFSA.addKunde(newKunde2);
					kplz.addKunde(newKunde2);
					em.persist(newKunde2);
				
				}
						
				
					
				
				}
			Auto auto = em.find(Auto.class, 1);
			if (auto == null) {
				Marke marke = new Marke("VW");
				em.persist(marke);
				Kraftstoff ks = new Kraftstoff("Diesel");
				em.persist(ks);
				BigDecimal pjk = new BigDecimal(3.5);
				Autoart autoart = new Autoart("VW Kombi", 90, 4,60,9.8,pjk,ks,marke);
				autoart.setBild("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");
				em.persist(autoart);
				Auto auto2 = new Auto("51.955206, 7.627572","Auto2",autoart);
				marke.addAutoart(autoart);
				ks.addAutoart(autoart);
				autoart.addAuto(auto2);
				em.persist(auto2);
				Auto auto21 = new Auto("51.967517, 7.602504","Auto10",autoart);
				marke.addAutoart(autoart);
				ks.addAutoart(autoart);
				autoart.addAuto(auto21);
				em.persist(auto21);
				mieten m = em.find(mieten.class, 1);
				if (m== null) {
					Kunde customer11 = em.find(Kunde.class, "Kevin@web.de");
					
					mieten m1 = new mieten(2000,auto21,customer11);
					m1.setEndkm(2500);
					em.persist(m1);
				
				
				
				}
				Kunde customer11 = em.find(Kunde.class, "Kevin@web.de");
				
				mieten m1 = new mieten(2000,auto21,customer11);
				m1.setEndkm(2500);
				em.persist(m1);
				Kunde customer13 = em.find(Kunde.class, "test@web.de");
				
				mieten m11 = new mieten(2000,auto21,customer13);
				m11.setEndkm(2500);
				em.persist(m11);
				Schaden schaden = new Schaden(customer11,auto21,"Licht vorne Rechts defekt");
				em.persist(schaden);
				Dreck dreck = new Dreck(customer11,auto21);
				em.persist(dreck);
			
				
			
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
