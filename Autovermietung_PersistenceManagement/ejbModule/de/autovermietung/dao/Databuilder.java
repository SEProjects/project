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

		
			Kunde customer1 = em.find(Kunde.class, "Kevin@web.de");
			if (customer1 == null) {
				boolean admin = false;
				PLZ kplz = new PLZ("48153","Münster");
				em.persist(kplz);
				logger.info(kplz);
				FSA newFSA = new FSA("LKW");
				em.persist(newFSA);
				logger.info(newFSA);
				Kunde newKunde = new Kunde("Kevin@web.de","asfd","asdf","1234","asds","asdf","asdf",true,kplz);
				newFSA.addKunde(newKunde);
				kplz.addKunde(newKunde);
				newKunde.setLink("true");
				em.persist(newKunde);
				Kunde customer3 = em.find(Kunde.class, "test@web.de");
				logger.info(newKunde);
				if (customer3 == null) {
					
					Kunde newKunde2 = new Kunde("test@web.de","asss","asss","1234","asdsaa","avs","aaf",false,kplz);
					newFSA.addKunde(newKunde2);
					kplz.addKunde(newKunde2);
					newKunde2.setLink("true");
					em.persist(newKunde2);
					logger.info(newKunde2);
				
				}
						
				
					
		
				
				}
			
			
				Marke marke = new Marke("VW");
				em.persist(marke);
				Kraftstoff ks = new Kraftstoff("Diesel");
				em.persist(ks);
				BigDecimal pjk = new BigDecimal(3.5);
				Autoart autoart = new Autoart("VW Kombi", 90, 4,60,9.8,pjk,ks,marke);
				autoart.setBild("");
					em.persist(autoart);
				Auto auto2 = new Auto("51.955206, 7.627572","VW2",autoart);
				marke.addAutoart(autoart);
				ks.addAutoart(autoart);
				autoart.addAuto(auto2);
				em.persist(auto2);
				Auto auto21 = new Auto("51.967517, 7.602504","VW1",autoart);
				marke.addAutoart(autoart);
				ks.addAutoart(autoart);
				autoart.addAuto(auto21);
				em.persist(auto21);
				Mieten m = em.find(Mieten.class, 1);
				if (m== null) {
					Kunde customer11 = em.find(Kunde.class, "Kevin@web.de");
					
					Mieten m1 = new Mieten(2000,auto21,customer11);
					m1.setEndkm(2500);
					em.persist(m1);
				
				
				
				}
				Kunde customer11 = em.find(Kunde.class, "Kevin@web.de");
				
				Mieten m1 = new Mieten(2000,auto21,customer11);
				m1.setEndkm(2500);
				em.persist(m1);
				Kunde customer13 = em.find(Kunde.class, "test@web.de");
				
				Mieten m11 = new Mieten(2000,auto21,customer13);
				m11.setEndkm(2500);
				em.persist(m11);
				Schaden schaden = new Schaden(customer11,auto21,"Licht vorne Rechts defekt");
				em.persist(schaden);
				Dreck dreck = new Dreck(customer11,auto21);
				em.persist(dreck);
				Rechnung rechnung = new Rechnung(customer11);
				rechnung.addRechnungsposition(m1);
				rechnung.setVorpreis(m1.getAuto().getAutoart().getPjk().multiply(m1.getDiff()));
				rechnung.setRabatt(new BigDecimal(0));
				m1.setRechnung(rechnung);
				m1.setAbgerechnet(true);
				rechnung.setBezahlt(true);
				em.persist(rechnung);
				if(em.find(PLZ.class, "48143") == null ){
				PLZ plz = new PLZ("48143","Münster");
				em.persist(plz);
				
				plz = new PLZ("48145","Münster");
				em.persist(plz);
				plz = new PLZ("48147","Münster");
				em.persist(plz);
				plz = new PLZ("48149","Münster");
				em.persist(plz);
				plz = new PLZ("48151","Münster");
				em.persist(plz);
			
				plz = new PLZ("48155","Münster");
				em.persist(plz);
				plz = new PLZ("48157","Münster");
				em.persist(plz);
				plz = new PLZ("48159","Münster");
				em.persist(plz);
				plz = new PLZ("48161","Münster");
				em.persist(plz);
				plz = new PLZ("48163","Münster");
				em.persist(plz);
				plz = new PLZ("48165","Münster");
				em.persist(plz);
				plz = new PLZ("48167","Münster");
				em.persist(plz);
				
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
