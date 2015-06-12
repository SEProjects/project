package de.autovermietung.dao;

import javax.ejb.Local;

import de.autovermietung.entities.Auto;
import de.autovermietung.entities.Kunde;
import de.autovermietung.entities.Session;

@Local
public interface AutovermietungDAOLocal {
	
	public Kunde findKundebyEmail(String Email);
	
	public Session createSession(Kunde kunde);
	  public Auto findAutobyID(int Aid);
	  public Session findSessionbyId(int Id);
	    public void deleteSession(Session session);
}
