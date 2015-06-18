package de.autovermietung.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.jboss.logging.Logger;

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


/**
 * Session Bean implementation class AutovermietungDAO
 */
@Stateless
public class AutovermietungDAO implements AutovermietungDAOAdminLocal,AutovermietungDAOLocal {
	@PersistenceContext
	private EntityManager em;
	private static final Logger logger = Logger.getLogger(AutovermietungDAO.class);
    public Kunde findKundebyEmail(String Email)
    {
    	Kunde newKunde = em.find(Kunde.class,Email);
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
    public Session createSession(Kunde kunde){
    	Session session = new Session(kunde);
    	em.persist(session);
    	return session;
    
    }
    public void deleteSession(Session session){
    	em.remove(session);
    }
    public Session findSessionbyId(int Id){
    	return em.find(Session.class, Id);
    }

	public List<Object[]> getAllKunden(){
    	 List query = em.createQuery("SELECT  k.email,  k.kvorname, k.knachname, k.strasse, k.kplz.Wohnort , k.kplz.plz FROM Kunde k").getResultList();
    	    return  query;
  
    }
	public List<Object[]> getAllAutos(){
   	 List query = em.createQuery("SELECT  A.aid, a.bez, a.autoart.beschreibung, a.autoart.marke.markenname, a.autoart.ks.ksbezeichnung, a.position FROM Auto a").getResultList();
   	    return  query;
 
   }
	public List<Integer> getAllAutosA(){
	   	 List query = em.createQuery("SELECT A.aid FROM Auto a").getResultList();
	   	 return  query;
	   }
	public List<Object[]> getAllMarken(){
	   	 List query = em.createQuery("SELECT m.markeid, m.markenname FROM Marke m").getResultList();
	   	    return  query;
	 
	   }
	public Marke createMarke(String bezeichung){
		Marke marke = new Marke(bezeichung);
		em.persist(marke);
		return marke;
	}
	public List<Object[]> getAllKS(){
		 List query = em.createQuery("SELECT k.ksid, k.ksbezeichnung FROM Kraftstoff k").getResultList();
	   	 return  query;
	}

	public Kraftstoff findKsbyId(int id){
		return em.find(Kraftstoff.class,id);
	}
	public Kraftstoff createKS(String beschreibung){
		Kraftstoff ks = new Kraftstoff(beschreibung);
		em.persist(ks);
		
		return ks;
	}
	public List<Object[]> getAllAA(){
		 List query = em.createQuery("SELECT a.aaid,a.beschreibung,a.ps,a.sitzanzahl,a.kofferraumvolumen,a.kraftstoffverbrauch,a.pjk,ks.ksbezeichnung,a.marke.markenname FROM Autoart a").getResultList();
	   	 return  query;
	}
	public Autoart createAA(String beschreibung, int kofferraumvolumen, double kraftstoffverbrauch,Kraftstoff ks,Marke marke,double pjk,int ps, int sitzanzahl)
	{
		BigDecimal pjk2 = new BigDecimal(pjk);
		Autoart aa = new Autoart(beschreibung,ps, sitzanzahl,
				kofferraumvolumen, kraftstoffverbrauch,
				 pjk2, ks,marke);
		em.persist(aa);
		return aa;
	}
	public Auto createAuto(String bez,Autoart aa){
		Auto auto = new Auto("51.961749, 7.626028",bez,aa);
		em.persist(auto);
		return auto;
	}
	public List<Object[]> getAllRechnungen(){
		 List query = em.createQuery("SELECT r.rid, r.gesamtpreis, r.timestamp, r.kunde.email, r.abgerechnet, r.bezahlt FROM Rechnung r").getResultList();
	   	 return  query;
	}
	public List<Object[]> getAllRechnungenposition(int id){
		 List query = em.createQuery("SELECT m.mid, m.anfangskm, m.endkm, m.auto.autoart.beschreibung, m.auto.autoart.pjk, m.diff, m.timestamp FROM mieten m where m.rechnung.rid = '" + id + "'").getResultList();
	   	 return  query;
	 
	}
	public void createAllRechnungen(){
		List query = em.createQuery("SELECT m.kunde.email from mieten m where m.endkm is not null and m.abgerechnet = false group by m.kunde.email").getResultList();
		List query2 = em.createQuery("SELECT m.mid from mieten m where m.endkm is not null and m.abgerechnet = false").getResultList();
		if(query.isEmpty()){
			logger.info("keine rechnungen vorhanden");
		}
		else{
			for(int i=0;i<query.size();i++){
				logger.info(query.get(i));
				
				List query3 = em.createQuery("SELECT m.mid from mieten m where m.endkm is not null and m.abgerechnet = false and m.kunde.email = '" + query.get(i) + "'").getResultList();
				BigDecimal summe = new BigDecimal(0);
				Kunde kunde = em.find(Kunde.class,query.get(i));
				Rechnung rechnung = new Rechnung(kunde);
			
				for(int j=0;j<query3.size();j++){
				

				
					mieten miet = em.find(mieten.class,query3.get(j));
					rechnung.addRechnungsposition(miet);
					
					BigDecimal zsumme = miet.getDiff();
				
					zsumme=zsumme.multiply(miet.getAuto().getAutoart().getPjk());
					
					summe=summe.add(zsumme);
					miet.setAbgerechnet(true);
					miet.setRechnung(rechnung);
					
				}
				rechnung.setGesamtpreis(summe);
				rechnung.setVorpreis(summe);
				rechnung.setRabatt(new BigDecimal(0));
				
				BigDecimal mwst = summe;
				mwst.multiply(new BigDecimal(0.19));
				rechnung.setMwst(mwst);
				em.persist(rechnung);
				
				logger.info(rechnung.getGesamtpreis());
				
			}
			
		}
	}

}


