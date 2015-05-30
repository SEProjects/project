package de.autovermietung.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import de.autovermietung.entities.Kunde;


/**
 * Session Bean implementation class AutovermietungDAO
 */
@Stateless
public class AutovermietungDAO implements AutovermietungDAOLocal {

	private EntityManager em;
    /**
     * Default constructor. 
     */
    public AutovermietungDAO() {
        // TODO Auto-generated constructor stub
    }
    public Kunde findKundebyID(int kid)
    {
    	return em.find(Kunde.class, kid);
    	
    	   }

}
