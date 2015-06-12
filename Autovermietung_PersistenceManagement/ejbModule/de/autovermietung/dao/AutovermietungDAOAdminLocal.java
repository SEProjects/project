package de.autovermietung.dao;
import java.util.List;

import javax.ejb.Local;

import de.autovermietung.entities.Auto;
import de.autovermietung.entities.Autoart;
import de.autovermietung.entities.Bankkonto;
import de.autovermietung.entities.FSA;
import de.autovermietung.entities.Kraftstoff;
import de.autovermietung.entities.Kunde;
import de.autovermietung.entities.Marke;
import de.autovermietung.entities.PLZ;
import de.autovermietung.entities.Rechnung;
import de.autovermietung.entities.Session;
import de.autovermietung.entities.mieten;

@Local
public interface AutovermietungDAOAdminLocal {
	
    public Kunde findKundebyEmail(String Email);
    
    public Auto findAutobyID(int Aid);
    
    public Autoart findAutoartbyID(int AAid);
    
    public mieten findMietenbyID(int Mid);
    
    public Rechnung findRechnungbyID(int Rid);
  
    public Marke findMarkebyID(int Mid);
    public Session createSession(Kunde kunde);
    
    public void deleteSession(Session session);
    public Kunde createKunde(String kvorname, String knachname, String email,
			String kpassword, String fSnummer, String pAN, String strasse,
			boolean sAF, FSA fSA, PLZ kplz);
			
    public mieten createMieten(double anfangskm,Auto auto, Kunde kunde);
	
	
    public Bankkonto createBankkonto(String iBan, String bIC,Kunde kunde);
    public Session findSessionbyId(int Id);
    public List<Object[]> getAllKunden();
    public List<Object[]> getAllAutos();
	public List<Object[]> getAllMarken();
	public Marke createMarke(String bezeichung);
	public List<Object[]> getAllKS();
	public Kraftstoff findKsbyId(int id);
	public Kraftstoff createKS(String beschreibung);
	public List<Object[]> getAllAA();
	public Auto createAuto(String bez,Autoart aa);
	public List<Object[]> getAllRechnungen();
	public Autoart createAA(String beschreibung,int kofferraumvolumen, double kraftstoffverbrauch,Kraftstoff ks,Marke marke,double pjk,int ps, int sitzanzahl);
	public void createAllRechnungen();
}
