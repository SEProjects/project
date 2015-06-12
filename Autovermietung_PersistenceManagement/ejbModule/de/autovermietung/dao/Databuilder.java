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
import de.autovermietung.entities.FSA;
import de.autovermietung.entities.Kraftstoff;
import de.autovermietung.entities.Kunde;
import de.autovermietung.entities.Marke;
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
			Auto auto = em.find(Auto.class, 1);
			if (auto == null) {
				Marke marke = new Marke("VW");
				em.persist(marke);
				Kraftstoff ks = new Kraftstoff("Diesel");
				em.persist(ks);
				BigDecimal pjk = new BigDecimal(3.5);
				Autoart autoart = new Autoart("VW Kombi", 90, 4,60,9.8,pjk,ks,marke);
				em.persist(autoart);
				Auto auto2 = new Auto("51.955206, 7.627572","Auto2",autoart);
				marke.addAutoart(autoart);
				ks.addAutoart(autoart);
				autoart.addAuto(auto2);
				em.persist(auto2);
				
			
				
			
			}
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
				if (customer3 == null) {
					
					Kunde newKunde2 = new Kunde("test@web.de","asss","asss","1234","asdsaa","avs","aaf",true,false,newFSA,kplz);
					newFSA.addKunde(newKunde2);
					kplz.addKunde(newKunde2);
					em.persist(newKunde2);
				
				}
				
			
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
