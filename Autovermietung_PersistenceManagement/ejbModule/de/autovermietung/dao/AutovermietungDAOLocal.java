package de.autovermietung.dao;

import java.util.List;

import javax.ejb.Local;

import de.autovermietung.entities.Auto;
import de.autovermietung.entities.Autoart;
import de.autovermietung.entities.Kraftstoff;
import de.autovermietung.entities.Kunde;
import de.autovermietung.entities.Marke;
import de.autovermietung.entities.Rechnung;
import de.autovermietung.entities.Session;

// TODO: Auto-generated Javadoc
/**
 * The Interface AutovermietungDAOLocal.
 */
@Local
public interface AutovermietungDAOLocal {
	
	/**
	 * Find kundeby email.
	 *
	 * @param Email the email
	 * @return the kunde
	 */
	public Kunde findKundebyEmail(String Email);
	/**
	 * Creates the session.
	 *
	 * @param kunde the kunde
	 * @return the session
	 */
	public Session createSession(Kunde kunde);
	
	/**
	 * Find autoby id.
	 *
	 * @param Aid the aid
	 * @return the auto
	 */
	public Auto findAutobyID(int Aid);
	
	/**
	 * Find autoartby id.
	 *
	 * @param aaId the aa id
	 * @return the autoart
	 */
	public Autoart findAutoartbyID(int aaId);
	
	/**
	 * Find markeby id.
	 *
	 * @param Mid the mid
	 * @return the marke
	 */
	public Marke findMarkebyID(int Mid);
	
	/**
	 * Find ksby id.
	 *
	 * @param id the id
	 * @return the kraftstoff
	 */
	public Kraftstoff findKsbyId(int id);
	
	/**
	 * Find sessionby id.
	 *
	 * @param Id the id
	 * @return the session
	 */
	public Session findSessionbyId(int Id);
	
	/**
	 * Delete session.
	 *
	 * @param session the session
	 */
	public void deleteSession(Session session);
	
	/**
	 * Find rechnungby id.
	 *
	 * @param Rid the rid
	 * @return the rechnung
	 */
	public Rechnung findRechnungbyID(int Rid);
	
	/**
	 * Gets the all autos a.
	 *
	 * @return the all autos a
	 */
	public List<Integer> getAllAutosA();
	
	/**
	 * Gets the all autos.
	 *
	 * @return the all autos
	 */
	public List<Object[]> getAllAutos();
}
