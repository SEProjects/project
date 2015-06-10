package de.autovermietung.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

import de.autovermietung.entities.Kunde;
import de.autovermietung.entities.Session;

@Stateless
public class AutovermietungDAOUser implements AutovermietungDAOLocal {
	@PersistenceContext
	private EntityManager em;
	private static final Logger logger = Logger.getLogger(Databuilder.class);
	@Override
	public Kunde findKundebyEmail(String Email) {
		Kunde newKunde = em.find(Kunde.class,Email);
    	return newKunde;
	}

	@Override
	public Session createSession(Kunde kunde) {
		Session session = new Session(kunde);
    	em.persist(session);
    	return session;
	}

}
