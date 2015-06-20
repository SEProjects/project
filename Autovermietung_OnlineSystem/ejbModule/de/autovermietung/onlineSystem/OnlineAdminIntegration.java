package de.autovermietung.onlineSystem;



import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

import org.jboss.logging.Logger;

import de.autovermietung.dao.AutovermietungDAOAdminLocal;
import de.autovermietung.dao.Databuilder;
import de.autovermietung.dto.AutoArtBildResponse;
import de.autovermietung.dto.AutoArtResponse;
import de.autovermietung.dto.AutoResponse;
import de.autovermietung.dto.GetAllResponse;
import de.autovermietung.dto.KSResponse;

import de.autovermietung.dto.KundeResponse;
import de.autovermietung.dto.KundenLoginResponse;
import de.autovermietung.dto.MarkeResponse;
import de.autovermietung.dto.RechnungsAResponse;
import de.autovermietung.dto.RechnungsrabattResponse;
import de.autovermietung.dto.UpdateResponse;
import de.autovermietung.dto.neuerEintragResponse;
import de.autovermietung.entities.Auto;
import de.autovermietung.entities.Autoart;
import de.autovermietung.entities.Kraftstoff;
import de.autovermietung.entities.Kunde;
import de.autovermietung.entities.Marke;
import de.autovermietung.entities.Rechnung;
import de.autovermietung.entities.Session;
import de.autovermietung.exceptions.InsertException;
import de.autovermietung.exceptions.InvalidLoginException;
import de.autovermietung.exceptions.KeineAutosException;
import de.autovermietung.exceptions.KeineKundenException;
import de.autovermietung.exceptions.KeineMarkenException;
import de.autovermietung.exceptions.KeineSessionException;
import de.autovermietung.exceptions.KundeNichtVorhandenException;
import de.autovermietung.exceptions.NichtVorhandenException;
import de.autovermietung.exceptions.OnlineIntegrationExceptions;
import de.autovermietung.exceptions.SessionabgelaufenException;
import de.autovermietung.util.DtoAssembler;


/**
 * Diese Stateless Session bean ist der Webendpoint für den Administrationswebbereich
 * @author Kevin Haase
 */
@Stateless
@WebService
@LocalBean
public class OnlineAdminIntegration {

    /**
     * Laden des DataAccessObject aus der Autovermietung_Persistense
     */
	@EJB(beanName = "AutovermietungDAO", beanInterface = de.autovermietung.dao.AutovermietungDAOAdminLocal.class)
	private AutovermietungDAOAdminLocal dao;
	
	/** The ws context. */
	@Resource
	private WebServiceContext wsContext;
	
	/** Laden der MessageDrivenBean Insert Klasse. */
	@EJB
	private OutputRequesterBean outputRequester;
	
	/** Laden des dtoAssembler,welcher größere DTO erstellt */
	@EJB
	private DtoAssembler dto;
	
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(Databuilder.class);
    
  
    
    /**
     * Loginmethode für den Administratorbereich.
     *
     * @param email des Administrators als String
     * @param password des Administrators als String 
     * @return {@link de.autovermietung.dto.KundenLoginResponse KundenLoginResponse} testen ob Returncode = 0 sonst failed
     * @throws InvalidLoginException wenn Eingabe falsch
         */
    public KundenLoginResponse Adminlogin(@WebParam(name = "email") String email, @WebParam(name="password") String password)   {
       
    	KundenLoginResponse klr = new KundenLoginResponse();
    	
		try {
			Kunde kunde = this.dao.findKundebyEmail(email);	
			
			if (kunde != null && kunde.getKpassword().equals(password)) {
				Session session = dao.createSession(kunde);
				klr.setSession(session.getSid());
				
			}
			else {
				
				throw new InvalidLoginException("Login fehlgeschlagen, da Kunde unbekannt oder Passwort falsch. username=" + email + " " + password);
			}
		}
		catch (InvalidLoginException e) {
			klr.setReturnCode(e.getErrorCode());
			klr.setMessage(e.getMessage());
		}
		return klr;
	    
    }
   
   /**
    * Interne Methode zum Checken der aktiven Session mit Ablauf
    *
    * @param Id the id
    * @return SessionID zur Authentifizierung
    * @throws SessionabgelaufenException wenn Session älter als 5 Minuten
    * @throws KeineSessionException wenn Session nicht vorhanden
    */
   private Session getSession(int Id) throws SessionabgelaufenException, KeineSessionException{
	   Session session = dao.findSessionbyId(Id);
	   if(session == null )
		   throw new KeineSessionException("Bitte loggen Sie sich zuerst ein.");
	   else
	   {
		   Date created  = session.getTimestamp();
		   long startTime = created.getTime();
			long jetzt = new Date().getTime();
			long seconds=jetzt-startTime;
		   
		   logger.info(seconds*0.001);
		   if(seconds > 300000){
			   dao.deleteSession(session);
			   throw new SessionabgelaufenException("Ihre Session ist leider abgelaufen. Bitte loggen sie sich erneurt ein");
		   }		   
		   else
		   {
		   
			   session.updateTimestamp();
			   return session;
		   }
	      
	   }
   }
    
 
    
    /**
     * Liefert alle Kunden.
     **   @param Sessionid muss die SessionID übergeben werden
     * @return  {@link de.autovermietung.dto.GetAllResponse GetAllResponse}
     * @throws SessionabgelaufenException wenn Session älter als 5 Minuten
    * @throws  KeineSessionException wenn Session nicht vorhanden
    * @throws KeineKundenException wenn es noch keine Kunden gibt
          */
    public GetAllResponse getAllKunden(@WebParam(name="Sessionid") int session){
      
        	GetAllResponse gar = new 	GetAllResponse();
        	try {
        		Session Nsession = getSession(session);
    			List<Object[]> kunden = this.dao.getAllKunden();	
    			
    			if (kunden.isEmpty() == false) {
    				gar.setDatensaetze(kunden);
    			}
    			else {
    				
    				throw new KeineKundenException("Es sind noch keine Kunden vorhanden");
    			}
    		}
    		catch (OnlineIntegrationExceptions e) {
    			gar.setReturnCode(e.getErrorCode());
    			gar.setMessage(e.getMessage());
    		}
        	
        	
        	return gar;
        }
    
    /**
     * Liefert den gesuchten Kunden.
     *
     * @param Sessionid  SessionID zur Authentifizierung
     * @param Kundeemail Übergabe der Kundenemail
     * @return {@link de.autovermietung.dto.KundeResponse KundeResponse}
     * @throws SessionabgelaufenException wenn Session älter als 5 Minuten
    * @throws KeineSessionException wenn Session nicht vorhanden
    * @throws KundenNichtException Kunde nicht vorhanden.
    * @throws NichtVorhandenException gesuchter Kunde nicht vorhanden.
     */
    public KundeResponse getKunde(@WebParam(name="Sessionid") int session,@WebParam(name="Kundeemail") String id){
       KundeResponse kr = new KundeResponse();
    	try {
    		Session Nsession = getSession(session);
			Kunde kunde = dao.findKundebyEmail(id);	
			
			if (kunde != null) {
				kr = dto.makeDTO(kunde);
			}
			else {
				
				throw new NichtVorhandenException("Kunde nicht vorhanden");
			}
		}
		catch (OnlineIntegrationExceptions e) {
			kr.setReturnCode(e.getErrorCode());
			kr.setMessage(e.getMessage());
		}
    	
    	
    	return kr;
    
    }
    
    /**
     * speichert die  Kundendaten.
     *
     * @param Sessionid SessionID zur Authentifizierung
     * @param Kundeemail Kundenemail des Kunden
     * @param kvorname Vorname des Kunden
     * @param knachname Nachname des Kunden
     * @param fsnummer  Führerscheinnummer des Kunden
     * @param pan Personalausweißnummer des Kunden
     * @param saf the saf des Kunden
     * @param admin Adminrechte
     * @return {@link de.autovermietung.dto.UpdateResponse UpdateResponse}
     */
    public UpdateResponse saveKunde(@WebParam(name="Sessionid") int session,@WebParam(name="Kundeemail") String id,
    		@WebParam(name="kvorname") String kvorname,@WebParam(name="knachname") String knachname,@WebParam(name="fsnummer") String fsnummer,
    		@WebParam(name="pan") String pan,@WebParam(name="saf") boolean saf,@WebParam(name="admin") boolean admin){
    	UpdateResponse ker = new UpdateResponse();
    	try {
    		Session Nsession = getSession(session);
			Kunde kunde = dao.findKundebyEmail(id);	
			
			if (kunde != null) {
				kunde.setEmail(id);
				kunde.setKvorname(kvorname);
				kunde.setKnachname(knachname);
				kunde.setFsnummer(fsnummer);
				kunde.setPan(pan);
				kunde.setSaf(saf);
				kunde.setAdmin(admin);
				ker.setSuccessful(true);
					
			}
			else {
				
				throw new KundeNichtVorhandenException("Kunde nicht vorhanden");
			}
		}
		catch (OnlineIntegrationExceptions e) {
			ker.setReturnCode(e.getErrorCode());
			ker.setMessage(e.getMessage());
			ker.setSuccessful(false);
		}
    	
    	
    	
    	
    	return ker;
    }
    
    /**
     *Liefert alle Autos.
     *
     * @param Sessionid muss die SessionID übergeben werden
     * @return   {@link de.autovermietung.dto.GetAllResponse GetAllResponse}
     * @throws SessionabgelaufenException wenn Session älter als 5 Minuten
    * @throws KeineSessionException wenn Session nicht vorhanden
    * @throws KeineAutosException wenn es noch keine Autos gibt
     */
    public GetAllResponse getAllAutos(@WebParam(name="Sessionid") int session){
    	
    	GetAllResponse aar = new GetAllResponse();
    	try {
    		Session Nsession = getSession(session);
			List<Object[]> autos = this.dao.getAllAutos();	
	
			if (autos.isEmpty() == false) {
				aar.setDatensaetze(autos);
			}
			else {
				
				throw new KeineAutosException("Es sind noch keine Autos vorhanden");
			}
		}
		catch (OnlineIntegrationExceptions e) {
			aar.setReturnCode(e.getErrorCode());
			aar.setMessage(e.getMessage());
		}
    	 	
    	
    	
    	
    	return aar;
    }
   
    /**
     * Liefert alle Marken.
     *
     * @param Sessionid muss die SessionID übergeben werden
     * @return  {@link de.autovermietung.dto.GetAllResponse GetAllResponse}
     * @throws SessionabgelaufenException wenn Session älter als 5 Minuten
    * @throws KeineSessionException wenn Session nicht vorhanden
    * @throws KeineMarkenException wenn es noch keine Marken gibt
     */
   public GetAllResponse  getAllMarken(@WebParam(name="Sessionid") int session){
    	
	   GetAllResponse  amr = new GetAllResponse();
    	try {
    		Session Nsession = getSession(session);
			List<Object[]> marken  = this.dao.getAllMarken();	
	
			if (marken.isEmpty() == false) {
				amr.setDatensaetze(marken);
			}
			else {
				
				throw new KeineMarkenException("Es sind noch keine Marken vorhanden");
			}
		}
		catch (OnlineIntegrationExceptions e) {
			amr.setReturnCode(e.getErrorCode());
			amr.setMessage(e.getMessage());
		}
    	 	
    	
    	
    	
    	return amr;
    }
   
   /**
    *Erstellt eine neue Marke.
    *
    * @param Sessionid SessionID zur Authentifizierung
    * @param Markenname Name der Marke
    * @throws InsertException wenn einfügen fehlgeschlagen
    * @return {@link de.autovermietung.dto.neuerEintragResponse neuerEintragResponse}
    */
   public neuerEintragResponse createMarke(@WebParam(name="Sessionid") int session,@WebParam(name="Markenname") String Marke){
	   neuerEintragResponse ner = new neuerEintragResponse();
	   try {
   		Session Nsession = getSession(session);
   		Marke marke = dao.createMarke(Marke);
			
			if (marke != null) {
				ner.setSuccessful(true);
			}
			else {
				ner.setSuccessful(false);
				throw new InsertException("Einfügen der Marke ist fehlgeschlagen");
			}
		}
		catch (OnlineIntegrationExceptions e) {
			ner.setReturnCode(e.getErrorCode());
			ner.setMessage(e.getMessage());
		}
	   
	   
	   
	   
	   
	   return ner;  
	   
	   
   }
  
  /**
   * Leifert die selektierte Marke.
   *
   * @param Sessionid SessionID zur Authentifizierung
   * @param MarkenId  der Marke
   * @return {@link de.autovermietung.dto.MarkeResponse MarkeResponse}
   */
  public MarkeResponse getMarke(@WebParam(name="Sessionid") int session,@WebParam(name="MarkenId") int Id){
	  MarkeResponse mr = new MarkeResponse();
	  
	   try {
	   		Session Nsession = getSession(session);
	   		Marke marke = dao.findMarkebyID(Id);
				logger.info(Id);
				if (marke != null) {
					mr.setMarkeid(marke.getMarkeid());
					mr.setMarkenname(marke.getMarkenname());
				}
				else {
					
					throw new NichtVorhandenException("Die Marke ist nicht vorhanden");
				}
			}
			catch (OnlineIntegrationExceptions e) {
				mr.setReturnCode(e.getErrorCode());
				mr.setMessage(e.getMessage());
			}
		   
	  
	  
	  return mr;
  }
  
  /**
   * speichert die angebenen Markendetails.
   *
   * @param Sessionid SessionID zur Authentifizierung
   * @param MarkenId der Marke
   * @param Markenname Markenname
   * @throws NichtVorhandenException die selektierte Marke ist nicht vorhanden.
   * @return {@link de.autovermietung.dto.UpdateResponse UpdateResponse}
   */
  public UpdateResponse saveMarke(@WebParam(name="Sessionid") int session,@WebParam(name="MarkenId") int Id,@WebParam(name="Markenname") String Marke){
	  UpdateResponse ur = new UpdateResponse();
	  try {
	   		Session Nsession = getSession(session);
	   		Marke marke = dao.findMarkebyID(Id);
				
				if (marke != null) {
					marke.setMarkenname(Marke);
					ur.setSuccessful(true);
				}
				else {
					ur.setSuccessful(false);
					throw new NichtVorhandenException("Die Marke ist nicht vorhanden");
				}
			}
			catch (OnlineIntegrationExceptions e) {
				ur.setReturnCode(e.getErrorCode());
				ur.setMessage(e.getMessage());
				ur.setSuccessful(false);
			}
		   
	  return ur;
  }
  
  /**
   * Liefert alle Krafststoffe.
   *
   * @param Sessionid muss die SessionID übergeben werden
   * @return   {@link de.autovermietung.dto.GetAllResponse GetAllResponse}
   * @throws SessionabgelaufenException wenn Session älter als 5 Minuten
  * @throws KeineSessionException wenn Session nicht vorhanden
  * @throws NichtVorhandenException wenn es noch keine Kraftstoffe gibt
   */
  public GetAllResponse getAllKS(@WebParam(name="Sessionid") int session){
  	
	  GetAllResponse  agr = new  GetAllResponse();
  	try {
  		Session Nsession = getSession(session);
			List<Object[]> ks = this.dao.getAllKS();	
	
			if (ks.isEmpty() == false) {
				agr.setDatensaetze(ks);
			}
			else {
				
				throw new NichtVorhandenException("Es sind noch keine Kraftstoffarten vorhanden");
			}
		}
		catch (OnlineIntegrationExceptions e) {
			agr.setReturnCode(e.getErrorCode());
			agr.setMessage(e.getMessage());
		}
  	 	
  	
  	
  	
  	return agr;
  }
 
 /**
  * Erzeugt eine neue Kraftstoffart.
  *
  * @param Sessionid SessionID zur Authentifizierung
  * @param KS Kraftstoffartname
  * @throws InsertException wenn einfügen fehlgeschlagen
  * @return {@link de.autovermietung.dto.neuerEintragResponse neuerEintragResponse}
  */
 public neuerEintragResponse createKS(@WebParam(name="Sessionid") int session,@WebParam(name="KS") String KS){
	 neuerEintragResponse ner = new neuerEintragResponse();
	   try {
 		Session Nsession = getSession(session);
 		Kraftstoff ks = dao.createKS(KS);
			
			if (ks != null) {
				ner.setSuccessful(true);
			}
			else {
				ner.setSuccessful(false);
				throw new InsertException("Einfügen der Krafststoffart ist fehlgeschlagen");
			}
		}
		catch (OnlineIntegrationExceptions e) {
			ner.setReturnCode(e.getErrorCode());
			ner.setMessage(e.getMessage());
		}
	   
	   
	   
	   
	   
	   return ner;  
	   
	   
 }

/**
 * Liefert die ausgewählte Kraftstoffart.
 *
 * @param Sessionid SessionID zur Authentifizierung
 * @param KSId der Kraftstoffart
 * @return {@link de.autovermietung.dto.KSResponse KSResponse}
 */
public KSResponse getKS(@WebParam(name="Sessionid") int session,@WebParam(name="KSId") int Id){
	  KSResponse kr = new KSResponse();
	  
	   try {
	   		Session Nsession = getSession(session);
	   		Kraftstoff ks = dao.findKsbyId(Id);
			
				if (ks != null) {
					kr.setKsid(Id);
					kr.setBezeichnung(ks.getKsbezeichnung());
				}
				else {
					
					throw new NichtVorhandenException("Die Marke ist nicht vorhanden");
				}
			}
			catch (OnlineIntegrationExceptions e) {
				kr.setReturnCode(e.getErrorCode());
				kr.setMessage(e.getMessage());
			}
		   
	  
	  
	  return kr;
}

/**
 * Speichert die Kraftstoffart
 *
 * @param Sessionid SessionID zur Authentifizierung
 * @param KSId der Kraftstoffart id
 * @param KSbezeichnung Kraftstoffartbezeichnung
 * @throws NichtVorhandenException wenn Kraftstoffart nicht vorhanden
 * @return {@link de.autovermietung.dto.UpdateResponse UpdateResponse}
 */
public UpdateResponse saveKS(@WebParam(name="Sessionid") int session,@WebParam(name="KSId") int Id,@WebParam(name="KSbezeichnung") String bezeichnung){
	  UpdateResponse ur = new UpdateResponse();
	  try {
	   		Session Nsession = getSession(session);
	   		Kraftstoff ks = dao.findKsbyId(Id);
				
	   		if (ks != null) {
	   				ks.setKsbezeichnung(bezeichnung);
	   				ur.setSuccessful(true);
				}
				else {
					ur.setSuccessful(false);
					throw new NichtVorhandenException("Die Kraftstoffart ist nicht vorhanden");
				}
			}
			catch (OnlineIntegrationExceptions e) {
				ur.setReturnCode(e.getErrorCode());
				ur.setMessage(e.getMessage());
				ur.setSuccessful(false);
			}
		   
	  return ur;
		}

/**
 * Liefert alle Autoarten.
 *
 * @param Sessionid muss die SessionID übergeben werden
 * @return   {@link de.autovermietung.dto.GetAllResponse GetAllResponse}
 * @throws SessionabgelaufenException wenn Session älter als 5 Minuten
* @throws KeineSessionException wenn Session nicht vorhanden
* @throws NichtVorhandenException wenn es noch keine Autoarten gibt
 */
	public GetAllResponse getAllAA(@WebParam(name="Sessionid") int session){
	
	  GetAllResponse  agr = new  GetAllResponse();
	  	try {
	  		Session Nsession = getSession(session);
				List<Object[]> ks = this.dao.getAllAA();	
		
				if (ks.isEmpty() == false) {
					agr.setDatensaetze(ks);
				}
				else {
					
					throw new NichtVorhandenException("Es sind noch keine Autoarten vorhanden");
				}
			}
			catch (OnlineIntegrationExceptions e) {
				agr.setReturnCode(e.getErrorCode());
				agr.setMessage(e.getMessage());
			}
	  	 	
	  	
	  	
	  	
	  	return agr;
	
	}
	
	/**
	 * Liefert die Selektierte Autoart.
	 *
	 * @param Sessionid SessionID zur Authentifizierung
	 * @param AAid Id der Autoart
	 * @throws  NichtVorhandenException wenn Autoart nicht vorhanden
	 * @return {@link de.autovermietung.dto.AutoArtResponse AutoArtResponse}
	 */
	public AutoArtResponse getAA(@WebParam(name="Sessionid") int session,@WebParam(name="AAid") int aaid){
		AutoArtResponse aar = new AutoArtResponse(); 
		 try {
		   		Session Nsession = getSession(session);
		   		Autoart aa = dao.findAutoartbyID(aaid);
				
					if (aa != null) {
						aar=dto.makeDTO(aa);
					}
					else {
						
						throw new NichtVorhandenException("Autoart ist nicht vorhanden");
					}
				}
				catch (OnlineIntegrationExceptions e) {
					aar.setReturnCode(e.getErrorCode());
					aar.setMessage(e.getMessage());
				}
			   
		return aar;
	}
	
	/**
	 * Speichert die Autoartdetails.
	 *
	 * @param Sessionid SessionID zur Authentifizierung
	 * @param AAid der Autoart
	 * @param beschreibung Beschreibung der Autoart
	 * @param kofferraumvolumen Kofferraumvolumen der Autoart
	 * @param kraftstoffverbrauch Kraftstoffverbrauch der Autoart
	 * @param ks Kraftstoffid der Autoart
	 * @param marke Markenid der Autoart
	 * @param pjk Preis je Km der Autoart
	 * @param ps Ps der Autoart
	 * @param sitzanzahl Sitzanzahl der Autoart
	 * @throws NichtVorhandenException wenn Autoart, Marke oder Kraftstoffart nicht vorhanden
	 * @return {@link de.autovermietung.dto.neuerEintragResponse neuerEintragResponse}
	 */
	public UpdateResponse saveAA(@WebParam(name="Sessionid") int session,@WebParam(name="AAid") int Id,@WebParam(name="beschreibung") String beschreibung,@WebParam(name="kofferraumvolumen") int kofferraumvolumen,@WebParam(name="kraftstoffverbrauch") String kraftstoffverbrauch, @WebParam(name="ks") int ksid,@WebParam(name="marke") int markenid,@WebParam(name="pjk") double pjk,@WebParam(name="ps") int ps,@WebParam(name="sitzanzahl") int sitzanzahl){
		  UpdateResponse ur = new UpdateResponse();
		  try {
			 
		   		Session Nsession = getSession(session);
		   		Autoart aa = dao.findAutoartbyID(Id);
					
		   		if (aa != null) {
		   			    BigDecimal pjk2 = new BigDecimal(pjk);
		   			    Marke marke = dao.findMarkebyID(markenid);
		   			    if(marke !=null){
			   			    Kraftstoff ks = dao.findKsbyId(ksid);
			   			    if(ks !=null){
			   			    double zahl = Double.parseDouble(kraftstoffverbrauch);
			   				aa.setBeschreibung(beschreibung);
			   				
			   				aa.setKofferraumvolumen(kofferraumvolumen);
			   				aa.setKraftstoffverbrauch(zahl);
			   				aa.setPjk(pjk2);
			   				aa.setPs(ps);
			   				aa.setSitzanzahl(sitzanzahl);
			   				aa.setMarke(marke);
			   				aa.setKs(ks);
			   				ur.setSuccessful(true);
			   			    }
			   			    else 
			   			    {
								ur.setSuccessful(false);
								throw new NichtVorhandenException("Kraftstoff ist nicht vorhanden");
							}
		   				}
		   			    else
		   			    {
							ur.setSuccessful(false);
							throw new NichtVorhandenException("Die Marke ist nicht vorhanden");
						}
					}
					else {
						ur.setSuccessful(false);
						throw new NichtVorhandenException("Die Autoart ist nicht vorhanden");
					}
				}
				catch (OnlineIntegrationExceptions e) {
					ur.setReturnCode(e.getErrorCode());
					ur.setMessage(e.getMessage());
					ur.setSuccessful(false);
				}
			   
		  return ur;
			}
	
	/**
	 * Erzeugt eine neue Autoart.
	 *
	 * @param Sessionid SessionID zur Authentifizierung
	 * @param beschreibung Beschreibung der Autoart
	 * @param kofferraumvolumen Kofferraumvolumen der Autoart
	 * @param kraftstoffverbrauch Kraftstoffverbrauch der Autoart
	 * @param ks Kraftstoffid der Autoart
	 * @param marke Markenid der Autoart
	 * @param pjk Preis je Km der Autoart
	 * @param ps Ps der Autoart
	 * @param sitzanzahl Sitzanzahl der Autoart
	 * @throws NichtVorhandenException wenn Marke oder Kraftstoffart nicht vorhanden
	 *	@return {@link de.autovermietung.dto.neuerEintragResponse neuerEintragResponse}
	 */
	public neuerEintragResponse createAA(@WebParam(name="Sessionid") int session,@WebParam(name="beschreibung") String beschreibung,@WebParam(name="kofferraumvolumen") int kofferraumvolumen,@WebParam(name="kraftstoffverbrauch") String kraftstoffverbrauch, @WebParam(name="ks") int ksid,@WebParam(name="marke") int markenid,@WebParam(name="pjk") double pjk,@WebParam(name="ps") int ps,@WebParam(name="sitzanzahl") int sitzanzahl){
		 neuerEintragResponse ner = new neuerEintragResponse();
		   try {
	 		Session Nsession = getSession(session);
	 		
				
					Marke marke = dao.findMarkebyID(markenid);
	   			    if(marke !=null){
		   			    Kraftstoff ks = dao.findKsbyId(ksid);
		   			    if(ks !=null){
		   			    	double zahl = Double.parseDouble(kraftstoffverbrauch);
		   			    	Autoart aa = dao.createAA(beschreibung,  kofferraumvolumen, zahl, ks, marke, pjk, ps, sitzanzahl);
		   			    ner.setSuccessful(true);
		   			    }
		   			    else 
		   			    {
							ner.setSuccessful(false);
							
							throw new NichtVorhandenException("Kraftstoff ist nicht vorhanden");
						}
	   				}
	   			    else
	   			    {
						ner.setSuccessful(false);
						throw new NichtVorhandenException("Die Marke ist nicht vorhanden");
					}
					
				
				
			}
			catch (OnlineIntegrationExceptions e) {
				ner.setReturnCode(e.getErrorCode());
				ner.setMessage(e.getMessage());
			}
		   
		   
		   
		   
		   
		   return ner;  
		   
		   
	 }
	
	/**
	 * Liefert das selektiertes Auto.
	 *
	 * @param Sessionid SessionID zur Authentifizierung
	 * @param Autoid des Autos
	 * @throws NichtVorhandenException wenn Auto nicht vorhanden
	 * @return {@link de.autovermietung.dto.AutoResponse AutoResponse} 
	 */
	public AutoResponse getAuto(@WebParam(name="Sessionid") int session,@WebParam(name="Autoid") int autoid){
		AutoResponse ar = new AutoResponse();
		
		 try {
		   		Session Nsession = getSession(session);
		   		Auto auto = dao.findAutobyID(autoid);
				
					if (auto != null) {
						ar.setAid(auto.getAid());
						ar.setBez(auto.getBez());
						ar.setAa(auto.getAutoart().getAaid());
						ar.setPosition(auto.getPosition());
					}
					else {
						
						throw new NichtVorhandenException("Auto ist nicht vorhanden");
					}
				}
				catch (OnlineIntegrationExceptions e) {
					ar.setReturnCode(e.getErrorCode());
					ar.setMessage(e.getMessage());
				}
			   
		  
		  
		  return ar;
		
		
	}
	
	/**
	 * Speichert die Autodetails.
	 *
	 * @param Sessionid SessionID zur Authentifizierung
	 * @param Autoid des Autos
	 * @param bez Die Bezeichnungs des Autos
	 * @param AAid die Autoartid des Autos
	 * @throws NichtVorhandenException wenn Autoart oder Auto nicht vorhanden
	 * @return {@link de.autovermietung.dto.UpdateResponse UpdateResponse}
	 */
	public UpdateResponse saveAuto(@WebParam(name="Sessionid") int session,@WebParam(name="Autoid") int Id,@WebParam(name="bez") String bez,@WebParam(name="AAid") int AAid){
		UpdateResponse ur = new UpdateResponse();
		  try {
			 
		   		Session Nsession = getSession(session);
		   		Auto auto = dao.findAutobyID(Id);
					
		   		if (auto != null) {
		   			   
		   			    Autoart aa  = dao.findAutoartbyID(AAid);
		   			    if(aa !=null){
			   			   auto.setAutoart(aa);
			   			   auto.setBez(bez);
			   			   
			   				ur.setSuccessful(true);
			   			 }	   			  
		   				
		   			    else
		   			    {
							ur.setSuccessful(false);
							throw new NichtVorhandenException("Die Autoart ist nicht vorhanden");
						}
					}
					else {
						ur.setSuccessful(false);
						throw new NichtVorhandenException("Auto ist nicht vorhanden");
					}
				}
				catch (OnlineIntegrationExceptions e) {
					ur.setReturnCode(e.getErrorCode());
					ur.setMessage(e.getMessage());
					ur.setSuccessful(false);
				}
			   
		  return ur;
			}
	
	/**
	 * Erzeugt ein neues Auto.
	 *
	 * @param Sessionid SessionID zur Authentifizierung
	 * @param bez Die Bezeichnungs des Autos
	 * @param AAid die Autoartid des Autos
	 * @throws NichtVorhandenException wenn Autoart  nicht vorhanden
	 * @return {@link de.autovermietung.dto.neuerEintragResponse neuerEintragResponse}
	 */
	public neuerEintragResponse createAuto(@WebParam(name="Sessionid") int session,@WebParam(name="bez") String bez,@WebParam(name="AAid") int AAid){
		 neuerEintragResponse ner = new neuerEintragResponse();
		   try {
	 		Session Nsession = getSession(session);
	 		
				
	 		 
		  Autoart aa  = dao.findAutoartbyID(AAid);
			    if(aa !=null){
			    	
   			   Auto auto = dao.createAuto(bez, aa);
   				ner.setSuccessful(true);
   			 }	   			  
				
			    else
			    {
				ner.setSuccessful(false);
				throw new NichtVorhandenException("Die Autoart ist nicht vorhanden");
			}
				
				
			}
			catch (OnlineIntegrationExceptions e) {
				ner.setReturnCode(e.getErrorCode());
				ner.setMessage(e.getMessage());
			}
		   
		   
		   
		   
		   
		   return ner;  
		   
		   
	 }
	
	/**
	 * Liefert alle Rechnungen.
	 *
	 * @param Sessionid muss die SessionID übergeben werden
	 * @return   {@link de.autovermietung.dto.GetAllResponse GetAllResponse}
	 * @throws SessionabgelaufenException wenn Session älter als 5 Minuten
	* @throws KeineSessionException wenn Session nicht vorhanden
	* @throws NichtVorhandenException wenn es noch keine Rechnungen gibt
	 */
	public GetAllResponse getAllRechnungen(@WebParam(name="Sessionid") int session){
		
		  GetAllResponse  agr = new  GetAllResponse();
		  	try {
		  		Session Nsession = getSession(session);
					List<Object[]> ks = this.dao.getAllRechnungen();	
			
					if (ks.isEmpty() == false) {
						agr.setDatensaetze(ks);
					}
					else {
						
						throw new NichtVorhandenException("Es sind noch keine Rechnungen vorhanden");
					}
				}
				catch (OnlineIntegrationExceptions e) {
					agr.setReturnCode(e.getErrorCode());
					agr.setMessage(e.getMessage());
				}
		  	 	
		  	
		  	
		  	
		  	return agr;
		
		}
	
	/**
	 * speichert das Autoartbild.
	 *
	 * @param Sessionid SessionID zur Authentifizierung
	 * @param AAid der Autoart
	 * @param bild in Base64 encoded als Bytestring
	 * @return {@link de.autovermietung.dto.UpdateResponse UpdateResponse}
	 */
	public UpdateResponse saveAABild(@WebParam(name="Sessionid") int session,@WebParam(name="AAid") int Id,@WebParam(name="Bild") String bild){
		UpdateResponse ur = new UpdateResponse();
		  try {
			 
		   		Session Nsession = getSession(session);
		   		Autoart aa = dao.findAutoartbyID(Id);
					
		   		if (aa != null) {
		   			   
		   			    
			   			aa.setBild(bild);
			   			ur.setSuccessful(true);
					}
					else {
						ur.setSuccessful(false);
						throw new NichtVorhandenException("AutoArt ist nicht vorhanden");
					}
				}
				catch (OnlineIntegrationExceptions e) {
					ur.setReturnCode(e.getErrorCode());
					ur.setMessage(e.getMessage());
					ur.setSuccessful(false);
				}
			   
		  return ur;
			}
	
	/**
	 * Leifert das Autoartbild der Autoart.
	 *
	 * @param Sessionid SessionID zur Authentifizierung
	 * @param AAid AutoartID
	 * @throws NichtVorhandenException wenn Autoart nicht vorhanden
	 * @return {@link de.autovermietung.dto.AutoArtBildResponse AutoArtBildResponse}
	 */
	public AutoArtBildResponse getAABild(@WebParam(name="Sessionid") int session,@WebParam(name="AAid") int aaid){
		AutoArtBildResponse aar = new AutoArtBildResponse(); 
		 try {
		   		Session Nsession = getSession(session);
		   		Autoart aa = dao.findAutoartbyID(aaid);
				
					if (aa != null) {
						aar.setBild(aa.getBild());
					}
					else {
						
						throw new NichtVorhandenException("Die Autoart ist nicht vorhanden");
					}
				}
				catch (OnlineIntegrationExceptions e) {
					aar.setReturnCode(e.getErrorCode());
					aar.setMessage(e.getMessage());
				}
			   
		return aar;
	}
	
	/**
	 * Erzeugt alle Rechungen.
	 *
	 * @param Sessionid SessionID zur Authentifizierung
	 * @return {@link de.autovermietung.dto.neuerEintragResponse neuerEintragResponse}
	 */
	public neuerEintragResponse createAllRechungen(@WebParam(name="Sessionid") int session){
		 neuerEintragResponse ner = new neuerEintragResponse();
		   try {
	 		Session Nsession = getSession(session);
	 		
				
	 		 
	 			dao.createAllRechnungen();
	 			ner.setSuccessful(true);
				
			}
			catch (OnlineIntegrationExceptions e) {
				ner.setReturnCode(e.getErrorCode());
				ner.setMessage(e.getMessage());
				ner.setSuccessful(false);
			}
		   
		   
		   
		   
		   
		   return ner;  
		   
		   
	 }
	

	
	/**
	 * Zahlungbestaetigen einer Rechnung.
	 *
	 * @param Sessionid SessionID zur Authentifizierung
	 * @param Rechnungsid der Rechnung
	 * @throws NichtVorhandenException wenn Rechnung nicht vorhanden
	 * @return {@link de.autovermietung.dto.UpdateResponse UpdateResponse}
	 */
	public UpdateResponse Zahlungbestaetigen(@WebParam(name="Sessionid") int session,@WebParam(name="Rechnungsid") int Id){
		UpdateResponse ur = new UpdateResponse();
		  try {
			 
		   		Session Nsession = getSession(session);
		   		Rechnung rechnung= dao.findRechnungbyID(Id);
					
		   		if (rechnung != null) {
		   			   
		   			    
			   			rechnung.setAbgerechnet(true);
			   			ur.setSuccessful(true);
					}
					else {
						ur.setSuccessful(false);
						throw new NichtVorhandenException("Rechnung ist nicht vorhanden");
					}
				}
				catch (OnlineIntegrationExceptions e) {
					ur.setReturnCode(e.getErrorCode());
					ur.setMessage(e.getMessage());
					ur.setSuccessful(false);
				}
			   
		  return ur;
			}
	
	/**
	 * Gets the rechnungs rabatt.
	 *
	 * @param Sessionid SessionID zur Authentifizierung
	 * @param Rechnungsid Rechnungsid
	 * @throws NichtVorhandenException wenn Rechnung nicht vorhanden
	 * @return {@link de.autovermietung.dto.RechnungsrabattResponse RechnungsrabattResponse}
	 */
	public RechnungsrabattResponse getRechnungsRabatt(@WebParam(name="Sessionid") int session,@WebParam(name="Rechnungsid") int id){
		RechnungsrabattResponse rrr = new RechnungsrabattResponse(); 
		 try {
			 
		   		Session Nsession = getSession(session);
		   		Rechnung rechnung= dao.findRechnungbyID(id);
					
		   		if (rechnung != null) {
		   			   rrr.setRabatt(rechnung.getRabatt());
		   			    
			   			
			   			
					}
					else {
						
						throw new NichtVorhandenException("Rechnung ist nicht vorhanden");
					}
				}
				catch (OnlineIntegrationExceptions e) {
					rrr.setReturnCode(e.getErrorCode());
					rrr.setMessage(e.getMessage());
				
				}
			   
		  return rrr;
			}
	
	/**
	 * Speichert den Rechnungsrabatt.
	 *
	 * @param Sessionid SessionID zur Authentifizierung
	 * @param Rechnungsid  der Rechnung
	 * @param Rabatt  Rabatt der Rechnung
	 * @throws NichtVorhandenException wenn Rechnung nicht vorhanden
	 * @return {@link de.autovermietung.dto.UpdateResponse UpdateResponse}
		 */
	public UpdateResponse saveRechnungsRabatt(@WebParam(name="Sessionid") int session,@WebParam(name="Rechnungsid") int Id,@WebParam(name="Rabatt") double rabatt){
		UpdateResponse ur = new UpdateResponse();
		  try {
			 
		   		Session Nsession = getSession(session);
		   		Rechnung rechnung= dao.findRechnungbyID(Id);
					
		   		if (rechnung != null) {
		   			   
		   			    
			   			rechnung.setRabatt(new BigDecimal(rabatt));
			   			ur.setSuccessful(true);
			   			logger.info("!");
			   			outputRequester.sendMessage(rechnung);
			   			
			   				
			   			}
					else {
						ur.setSuccessful(false);
						throw new NichtVorhandenException("AutoArt ist nicht vorhanden");
					}
				}
				catch (OnlineIntegrationExceptions e) {
					ur.setReturnCode(e.getErrorCode());
					ur.setMessage(e.getMessage());
					ur.setSuccessful(false);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   
		  return ur;
			}
	
	/**
	 * Leifert die ausgewählte Rechnung.
	 *
	 * @param Sessionid SessionID zur Authentifizierung
	 * @param Rechungsid der Rechnung
	 * @return {@link de.autovermietung.dto.RechnungsAResponse RechnungsAResponse}
	 */
	public RechnungsAResponse getRechnung(@WebParam(name="Sessionid") int session,@WebParam(name="Rechnungsid") int id){
		RechnungsAResponse rr = new RechnungsAResponse();
		
		 try {
		   		Session Nsession = getSession(session);
		   		Rechnung rechnung = dao.findRechnungbyID(id);
				
					if (rechnung != null) {
						rr.setGesamtpreis(rechnung.getGesamtpreis());
						rr.setKunde(rechnung.getKunde().getEmail());
						rr.setMwst(rechnung.getMwst());
						rr.setRabatt(rechnung.getRabatt());
						rr.setRid(rechnung.getRid());
						rr.setTimestamp(rechnung.getTimestamp());
						rr.setVorpreis(rechnung.getVorpreis());
						rr.setDatensaetze(dao.getAllRechnungenposition(id));
					}
					else {
						
						throw new NichtVorhandenException("Auto ist nicht vorhanden");
					}
				}
				catch (OnlineIntegrationExceptions e) {
					rr.setReturnCode(e.getErrorCode());
					rr.setMessage(e.getMessage());
				}
			   
		  
		  
		  return rr;
		
		
	}
	
	 
}
