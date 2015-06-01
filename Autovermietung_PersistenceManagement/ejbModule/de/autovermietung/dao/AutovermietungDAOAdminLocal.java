package de.autovermietung.dao;
import javax.ejb.Local;

import de.autovermietung.entities.Auto;
import de.autovermietung.entities.Autoart;
import de.autovermietung.entities.Bankkonto;
import de.autovermietung.entities.FSA;
import de.autovermietung.entities.Kunde;
import de.autovermietung.entities.Marke;
import de.autovermietung.entities.PLZ;
import de.autovermietung.entities.Rechnung;
import de.autovermietung.entities.mieten;

@Local
public interface AutovermietungDAOAdminLocal {
	
    public Kunde findKundebyEmail(String Email);
    
    public Auto findAutobyID(int Aid);
    
    public Autoart findAutoartbyID(int AAid);
    
    public mieten findMietenbyID(int Mid);
    
    public Rechnung findRechnungbyID(int Rid);
  
    public Marke findMarkebyID(int Mid);
    
    public Kunde createKunde(String kvorname, String knachname, String email,
			String kpassword, String fSnummer, String pAN, String strasse,
			boolean sAF, FSA fSA, PLZ kplz);
			
    public mieten createMieten(double anfangskm,Auto auto, Kunde kunde);
	
	
    public Bankkonto createBankkonto(String iBan, String bIC,Kunde kunde);
   

}
