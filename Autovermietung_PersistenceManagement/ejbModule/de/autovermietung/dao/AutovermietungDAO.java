package de.autovermietung.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

import de.autovermietung.entities.Auto;
import de.autovermietung.entities.Autoart;
import de.autovermietung.entities.Bankkonto;
import de.autovermietung.entities.FSA;
import de.autovermietung.entities.Kunde;
import de.autovermietung.entities.Marke;
import de.autovermietung.entities.PLZ;
import de.autovermietung.entities.Rechnung;
import de.autovermietung.entities.mieten;


/**
 * Session Bean implementation class AutovermietungDAO
 */
@Stateless
public class AutovermietungDAO implements AutovermietungDAOAdminLocal {
	@PersistenceContext
	private EntityManager em;
	private static final Logger logger = Logger.getLogger(Databuilder.class);
    public Kunde findKundebyEmail(String Email)
    {
 
    	logger.info(Email);
		
    	Kunde newKunde = em.find(Kunde.class,"Kevin");
    	logger.info(newKunde);
    	return newKunde;
    	
    	   }
    public Auto findAutobyID(int Aid)
    {
    	return em.find(Auto.class, Aid);
    
    }
    public Autoart findAutoartbyID(int AAid)
    {
    	return em.find(Autoart.class,AAid );
    
    }
    public mieten findMietenbyID(int Mid)
    {
    	return em.find(mieten.class,Mid);
    }
    public Rechnung findRechnungbyID(int Rid)
    {
    	return em.find(Rechnung.class,Rid);
    }
    public Marke findMarkebyID(int Mid)
    {
    	return em.find(Marke.class,Mid);
    }
    public Kunde createKunde(String kvorname, String knachname, String email,
			String kpassword, String fSnummer, String pAN, String strasse,
			boolean sAF, FSA fSA, PLZ kplz)
			{
    			boolean admin = false;
    			Kunde newKunde = new Kunde(kvorname,knachname,email,kpassword,fSnummer,pAN, strasse,
			sAF, admin,fSA,kplz);
    			em.persist(newKunde);
    			return newKunde;
			}
    public mieten createMieten(double anfangskm,Auto auto, Kunde kunde)
	{
    	
    	
    	mieten newmieten = new mieten(anfangskm,auto,kunde);
    	em.persist(newmieten);
    	return newmieten;
	}
    public Bankkonto createBankkonto(String iBan, String bIC,Kunde kunde)
    {
    		Bankkonto newBankkonto = new Bankkonto(iBan,bIC,kunde);
    		em.persist(newBankkonto);
    		return newBankkonto;
    }

}
