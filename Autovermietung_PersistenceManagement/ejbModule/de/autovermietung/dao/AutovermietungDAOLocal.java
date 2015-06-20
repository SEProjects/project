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

@Local
public interface AutovermietungDAOLocal {
	
	public Kunde findKundebyEmail(String Email);
	
	public Session createSession(Kunde kunde);
	public Auto findAutobyID(int Aid);
	public Autoart findAutoartbyID(int aaId);
	public Marke findMarkebyID(int Mid);
	public Kraftstoff findKsbyId(int id);
	public Session findSessionbyId(int Id);
	public void deleteSession(Session session);
	public Rechnung findRechnungbyID(int Rid);
	public List<Integer> getAllAutosA();
	public List<Object[]> getAllAutos();
}
