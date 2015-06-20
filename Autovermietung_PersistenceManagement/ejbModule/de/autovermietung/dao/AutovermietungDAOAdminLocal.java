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

// TODO: Auto-generated Javadoc
/**
 * @author Kevin Haase
 * The Interface AutovermietungDAOAdminLocal.
 */
@Local
public interface AutovermietungDAOAdminLocal {
	
    /**
     * Sucht Kunde mit angebener Email.
     *
     * @param Email Kundeemail
     * @return Kunde  or null if not exists
     */
    public Kunde findKundebyEmail(String Email);
    
    /**
     * Sucht Auto mit angebener ID
     *
     * @param Aid AutoID
     * @return Auto  or null if not exists
     */
    public Auto findAutobyID(int Aid);
    
    /**
     * Sucht AutoARt mit angebener ID
     *
     * @param AAid tAutoartid
     * @return  autoart  or null if not exists
     */
    public Autoart findAutoartbyID(int AAid);
    
    /**
     * Sucht mieten mit angebener ID
     *
     * @param Mid MietenID
     * @return mieten  or null if not exists
     */
    public mieten findMietenbyID(int Mid);
    
    /**
     *Sucht Rechnung mit angebener ID
     *
     * @param Rid the rid
     * @return the rechnung  or null if not exists
     */
    public Rechnung findRechnungbyID(int Rid);
  
    /**
     *Sucht Marke mit angebener ID
     *
     * @param Mid MarkenID
     * @return marke  or null if not exists
     */
    public Marke findMarkebyID(int Mid);
    
    /**
     * Creates session mit angegebenen Kunden.
     *
     * @param kunde the kunde
     * @return Session
     */
    public Session createSession(Kunde kunde);
    
    /**
     * Delete session.
     *
     * @param session Übergabe des Sessionobject welches gelöscht werden soll
     */
    public void deleteSession(Session session);
    
    /**
     * erstellt einen neuen Kunden
     *
     * @param kvorname Kundenvorname
     * @param knachname Kundennachname
     * @param email Kundenemail
     * @param kpassword Kundenpassword schon gehashed
     * @param fSnummer Fuehrerscheinnummer
     * @param pAN Personalausweissnummer
     * @param strasse strasse
     * @param sAF the s af
     * @param fSA FueherscheinArt als Object
     * @param kplz Kundenplz als PLZ Object
     * @return Kunde als fertiges object
     */
    public Kunde createKunde(String kvorname, String knachname, String email,
			String kpassword, String fSnummer, String pAN, String strasse,
			boolean sAF, FSA fSA, PLZ kplz);
			
  
    
    /**
     * sucht eine Session mit der angeben Id.
     *
     * @param Id the id
     * @return the session  or null if not exists
     */
    public Session findSessionbyId(int Id);
    
    /**
     * Liefert alle Kunden.
     *
     * @return alle Kunden in einer Liste mit Objects
     */
    public List<Object[]> getAllKunden();
    
    /**
     * Liefert alle  Autos.
     *
     * @return alle autos in einer Liste mit Objects
     */
    public List<Object[]> getAllAutos();
	
	/**
	 * leifert alle Marken.
	 *
	 * @return alle Marken in einer Liste mit Objects
	 */
	public List<Object[]> getAllMarken();
	
	/**
	 * Erzeuge eine neue Marke.
	 *
	 * @param bezeichung der Marke
	 * @return marke object 
	 */
	public Marke createMarke(String bezeichung);
	
	/**
	 * Liefert alle  Kraftstoffarten
	 *
	 * @return  alle ks in einer Liste mit Objects
	 */
	public List<Object[]> getAllKS();
	
	/**
	 * Sucht Kraftstoffart mit angebener id.
	 *
	 * @param id der Kraftstoffart
	 * @return  kraftstoff or null if not exists
	 */
	public Kraftstoff findKsbyId(int id);
	
	/**
	 * Erzeugt eine neue Kraftstoffart.
	 *
	 * @param beschreibung der Kraftstoffart
	 * @return  kraftstoff
	 */
	public Kraftstoff createKS(String beschreibung);
	
	/**
	 * Liefert alle Autoarten.
	 *
	 * @return the all aa in einer Liste mit Objects
	 */
	public List<Object[]> getAllAA();
	
	/**
	 * Creates the auto.
	 *
	 * @param bez the bez
	 * @param aa the aa
	 * @return the auto
	 */
	public Auto createAuto(String bez,Autoart aa);
	
	/**
	 * Liefert alle Rechnungen.
	 *
	 * @return alle Rechnungen in einer Liste mit Objects
	 */
	public List<Object[]> getAllRechnungen();
	
	/**
	 * erzeugt eine neue Autoart
	 *
	 * @param beschreibung beschreibung
	 * @param kofferraumvolumen kofferraumvolumen
	 * @param kraftstoffverbrauch  kraftstoffverbrauch
	 * @param ks Kraftstoffart als Objects
	 * @param marke Marke als Object
	 * @param pjk als double
	 * @param ps PS
	 * @param sitzanzahl sitzanzahl
	 * @return autoart
	 */
	public Autoart createAA(String beschreibung,int kofferraumvolumen, double kraftstoffverbrauch,Kraftstoff ks,Marke marke,double pjk,int ps, int sitzanzahl);
	
	/**
	 * erzeugt alle Rechnungen mit einem Algorithmus.
	 */
	public void createAllRechnungen();
	
	/**
	 * Liefert alle Rechnungenposition der angebenen Rechnungsid.
	 *
	 * @param id Rechnungsid
	 * @return alle rechnungenposition als Liste von Objecten
	 */
	public List<Object[]> getAllRechnungenposition(int id);
	public Kunde getKundeByHash(String Hash);
}
