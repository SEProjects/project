package de.autovermietung.onlineSystem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

import org.jboss.logging.Logger;

import de.autovermietung.dao.AutovermietungDAOLocal;
import de.autovermietung.dao.Databuilder;
import de.autovermietung.dto.AutoArtBildResponse;
import de.autovermietung.dto.AutoArtResponse;
import de.autovermietung.dto.AutoListResponse;
import de.autovermietung.dto.AutoResponse;
import de.autovermietung.dto.EditResponse;
import de.autovermietung.dto.KSResponse;
import de.autovermietung.dto.KundeResponse;
import de.autovermietung.dto.KundenLoginResponse;
import de.autovermietung.dto.MarkeResponse;
import de.autovermietung.dto.MietenListResponse;
import de.autovermietung.dto.MietenResponse;
import de.autovermietung.dto.RechnungsResponse;
import de.autovermietung.dto.ReturncodeResponse;
import de.autovermietung.dto.UpdateResponse;
import de.autovermietung.dto.neuerEintragResponse;
import de.autovermietung.entities.Auto;
import de.autovermietung.entities.Autoart;
import de.autovermietung.entities.Bezahlmethode;
import de.autovermietung.entities.Kraftstoff;
import de.autovermietung.entities.Kunde;
import de.autovermietung.entities.Marke;	    		
import de.autovermietung.entities.Mieten;
import de.autovermietung.entities.PLZ;
import de.autovermietung.entities.Rechnung;
import de.autovermietung.entities.Session;
import de.autovermietung.exceptions.InsertException;
import de.autovermietung.exceptions.InvalidLoginException;
import de.autovermietung.exceptions.KeineSessionException;
import de.autovermietung.exceptions.KundeNichtVorhandenException;
import de.autovermietung.exceptions.NichtVorhandenException;
import de.autovermietung.exceptions.OnlineIntegrationExceptions;
import de.autovermietung.exceptions.SessionabgelaufenException;
import de.autovermietung.util.DtoAssembler;

// TODO: Auto-generated Javadoc
/**
 * Diese Stateless Session bean ist der Webendpoint für die Clientapp
 */
@Stateless
@WebService
public class OnlineIntegration {

	/** Laden des DataAccessObject aus der Autovermietung_Persistense */
	@EJB(beanName = "AutovermietungDAO", beanInterface = de.autovermietung.dao.AutovermietungDAOLocal.class)
	private AutovermietungDAOLocal dao;
	
	/** The ws context. */
	@Resource
	private WebServiceContext wsContext;
	
	/** Laden des dtoAssembler,welcher größere DTO erstellt */
	@EJB
	private DtoAssembler dto;
	
	/** Laden der MessageDrivenBean Insert Klasse. */
	@EJB
	private OutputRequesterBean outputRequester;
	
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(Databuilder.class);
    
    /**
     * @author Marian Vennewald
     * Interne Methode zum Checken der aktiven Session mit Ablauf
     *
     * @param  Id der Session
     * @return SessionID zur Authentifizierung
     * @throws SessionabgelaufenException wenn Session älter als 5 Minuten
     * @throws KeineSessionException wenn Session nicht vorhanden
     */
    private Session getSession(int Id) throws SessionabgelaufenException, KeineSessionException{
  	   Session session = dao.findSessionbyId(Id);
  	   if(session == null)
  		   throw new KeineSessionException("Bitte loggen Sie sich zuerst ein.");
  	   else {
  		   Date created  = session.getTimestamp();
  		   long startTime = created.getTime();
  			long jetzt = new Date().getTime();
  			long seconds=jetzt-startTime;
  		   
  		   logger.info(seconds*0.001);
  		   if(seconds > 300000){
  			   dao.deleteSession(session);
  			   throw new SessionabgelaufenException("Ihre Session ist leider abgelaufen. Bitte loggen sie sich erneurt ein");
  		   } else {
  		   
  			   session.updateTimestamp();
  			   return session;
  		   }  
  	   }
     }
    
    /**
     * @author Marian Vennewald
     * Login Methode für die App
     *
     * @param email Die Email des Regristierten Benutzer muss übergeben werden
     * @param password Das Password des Regristierten Benutzer muss übergeben werden
     * @return the kunden login response {@link de.autovermietung.dio.KundenLoginResponse KundenLoginResponse }
     * @throws InvalidLoginException wenn Email noch nicht bestätigt wurde, der Kunde gesperrt oder der Kunde unbekannt nzw. das Passwort falsch ist
     * @throws SessionabgelaufenException falls die Session abgelaufen ist
     */
    public KundenLoginResponse login(@WebParam(name="email") String email, @WebParam(name="password") String password)   {
        
    	KundenLoginResponse klr = new KundenLoginResponse();
    	
		try {
			Kunde kunde = this.dao.findKundebyEmail(email);	
			
			if (kunde != null && kunde.getKpassword().equals(password) ) {
				if(kunde.isAktive() == true ){
					if(kunde.getLink().equals("true")){
					Session session = dao.createSession(kunde);
					klr.setSession(session.getSid());
					} else {
						throw new InvalidLoginException("Login fehlgeschlagen, da Email noch nicht bestätigt. username=" + email + " " + password);	
					}
				} else {
					throw new InvalidLoginException("Login fehlgeschlagen, da Kunde gesperrt. username=" + email + " " + password);
				}
			} else {
				throw new InvalidLoginException("Login fehlgeschlagen, da Kunde unbekannt oder Passwort falsch. username=" + email + " " + password);
			}
		} catch (InvalidLoginException e) {
			klr.setReturnCode(e.getErrorCode());
			klr.setMessage(e.getMessage());
		}
		return klr;
    }
    
    /**
     * @author Marian Vennewald
     * Logout Methode für die App
     *
     * @param session id vom Aktiven Benutzer übergeben
     * @return the returncode response {@link de.autovermietung.dio.ReturncodeResponse ReturncodeResponse }
     * @throws KeineSessionException wenn Session nicht vorhanden
     * @throws SessionabgelaufenException falls die Session abgelaufen ist
     */
    public ReturncodeResponse logout(@WebParam(name="sessionId") int sessionId) {
    	Session session;
		try {
			session = getSession(sessionId);
			dao.deleteSession(session);
		} catch (SessionabgelaufenException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeineSessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ReturncodeResponse response = new ReturncodeResponse();
		logger.info("Logout erfolgreich. Session=" + sessionId);
		return response;
	}
    
    /**
     * @author Marian Vennewald
     * Liefert den gesuchten Kunden
     *
     * @param ssession id vom Aktiven Benutzer übergeben
     * @param email vom Kunden übergeben
     * @return KundeResponse {@link de.autovermietung.dio.KundeResponse KundeResponse }
     * @throws KeineSessionException wenn Session nicht vorhanden
     * @throws NichtVorhandenException falls der Kunde nicht vorhanden ist
     */
    public KundeResponse getKunde(@WebParam(name="Sessionid") int session,@WebParam(name="Kundeemail") String email){
        KundeResponse kr = new KundeResponse();
     	try {
     		Session sessionId = getSession(session);
 			Kunde kunde = dao.findKundebyEmail(email);
 			if (kunde != null) {
 				kr = dto.makeDTO(kunde);
 			} else {
 				throw new KundeNichtVorhandenException("Kunde nicht vorhanden");
 			}
 		}
 		catch (OnlineIntegrationExceptions e) {
 			kr.setReturnCode(e.getErrorCode());
 			kr.setMessage(e.getMessage());
 		}
     	return kr;
     }
    
    /**
     * @author Marian Vennewald
     * Liefert das gesuchte Auto zurück
     * 
     * @param Session id vom Aktiven Benutzer übergeben
     * @param Auto Id des Erwarteten Autos übergeben
     * @return AutoResponse {@link de.autovermietung.dio.AutoResponse AutoResponse }
     * @throws KeineSessionException wenn Session nicht vorhanden
     * @throws NichtVorhandenException falls das Auto nicht vorhanden ist
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
				List<Integer> mId = dao.getAllMietenId();
				List<Integer> mieten = new ArrayList<Integer>();
				for(int i = 0; i < mId.size(); i++) {
					Mieten m = dao.findMietenbyID(mId.get(i));
					if(m != null)
						mieten.add(m.getMid());
				}
				ar.setGemietet(mieten);
				//TODO DRECK und SCHADEN
			} else {						
				throw new NichtVorhandenException("Auto ist nicht vorhanden");
			}
		} catch (OnlineIntegrationExceptions e) {
			ar.setReturnCode(e.getErrorCode());
			ar.setMessage(e.getMessage());
		}  
		return ar;
	}
    
    /**
     * @author Marian Vennewald
     * Liefert die gesuchte Marke zurück
     *
     * @param Session id vom Aktiven Benutzer übergeben
     * @param Marke Id der gesuchten Marke
     * @return MarkeResponse {@link de.autovermietung.dio.MarkeResponse MarkeResponse }
     * @throws KeineSessionException wenn Session nicht vorhanden
     * @throws NichtVorhandenException falls die Marke nicht vorhanden ist
     */
    public MarkeResponse getMarke(@WebParam(name="Sessionid")int session, @WebParam(name="MarkeId")int markeId) {
    	MarkeResponse mR = new MarkeResponse();
    	try {
			Session sessionId = getSession(session);
			Marke marke = dao.findMarkebyID(markeId);
			if(marke != null) {
				mR.setMarkeid(marke.getMarkeid());
				mR.setMarkenname(marke.getMarkenname());
			} else {
				throw new NichtVorhandenException("Marke ist nicht vorhanden");
			}
    	} catch (OnlineIntegrationExceptions e) {
			mR.setReturnCode(e.getErrorCode());
			mR.setMessage(e.getMessage());
		}  
    	return mR;
    }
    
    /**
     * @author Marian Vennewald
     * Liefert den gesuchten Kraftstoff zurück
     *
     * @param Session id vom Aktiven Benutzer übergeben
     * @param Kraftstoff Id des gesuchten Kraftstoffs
     * @return KSResponse {@link de.autovermietung.dio.KSResponse KSResponse }
     * @throws KeineSessionException wenn Session nicht vorhanden
     * @throws NichtVorhandenException falls der Kraftstoff nicht vorhanden ist
     */
    public KSResponse getKraftstoff(@WebParam(name="Sessionid")int session, @WebParam(name="KsId")int ksId) {
    	KSResponse kR = new KSResponse();
    	try {
			Session sessionId = getSession(session);
			Kraftstoff kraftstoff = dao.findKsbyId(ksId);
			if(kraftstoff != null) {
				kR.setKsid(kraftstoff.getKsid());
				kR.setBezeichnung(kraftstoff.getKsbezeichnung());
			} else {
				throw new NichtVorhandenException("Kraftstoff ist nicht vorhanden");
			}
    	} catch (OnlineIntegrationExceptions e) {
			kR.setReturnCode(e.getErrorCode());
			kR.setMessage(e.getMessage());
		}  
    	return kR;
    }
    
    /**
     * @author Marian Vennewald
     * Liefert alle Autos zurück
     *
     * @param Session id vom Aktiven Benutzer übergeben
     * @return AutoListResponse {@link de.autovermietung.dio.AutoListResponse AutoListResponse }
     * @throws KeineSessionException wenn Session nicht vorhanden
     */
    public AutoListResponse getAllAutos(@WebParam(name="Sessionid") int session){	
    	AutoListResponse aar = new AutoListResponse();
    	try {
    		Session sessionId = getSession(session);
    		List<Integer> aId = dao.getAllAutosA();
    		List<Auto> autoList = new ArrayList<>();
    		for(int i = 0; i < aId.size(); i++) {
    			Auto auto = dao.findAutobyID(aId.get(i));
    			autoList.add(auto);
    		}
    		aar.setAutoList(dto.makeDTO(autoList));
		} catch (OnlineIntegrationExceptions e) {
			aar.setReturnCode(e.getErrorCode());
			aar.setMessage(e.getMessage());
		}
    	return aar;
    }
    
    /**
     * @author Marian Vennewald
     * Liefert ein Auto Art zurück
     *
     * @param Session id vom Aktiven Benutzer übergeben
     * @param id des gesuchten Autoartes
     * @return AutoArtResponse {@link de.autovermietung.dio.AutoArtResponse AutoArtResponse }
     * @throws KeineSessionException wenn Session nicht vorhanden
     * @throws NichtVorhandenException falls die Autoart nicht vorhanden ist
     */
    public AutoArtResponse getAutoArt(@WebParam(name="Sessionid") int sessionId, @WebParam(name="AutoArtId") int id) {
    	AutoArtResponse aar = new AutoArtResponse();
    	try {
			Session sessionid = getSession(sessionId);  
	    	Autoart autoArt = dao.findAutoartbyID(id);
	    	if(autoArt != null) {
	    		aar = dto.makeDTO(autoArt);
	    	} else {
				throw new NichtVorhandenException("Die Autoart ist nicht vorhanden");
			}
		} catch (OnlineIntegrationExceptions e) {
			aar.setReturnCode(e.getErrorCode());
			aar.setMessage(e.getMessage());
		}
    	return aar;
    }
    
    /**
     * @author Marian Vennewald
     * Liefert vom Auto Art das Bild
     *
     * @param Session id vom Aktiven Benutzer übergeben
     * @param id des Autoartes
     * @return AutoArtBildResponse {@link de.autovermietung.dio.AutoArtBildResponse AutoArtBildResponse }
     * @throws KeineSessionException wenn Session nicht vorhanden
     * @throws NichtVorhandenException falls die Autoart nicht vorhanden ist
     */
    public AutoArtBildResponse getAABild(@WebParam(name="Sessionid") int session,@WebParam(name="Aaid") int aaid){
		AutoArtBildResponse aar = new AutoArtBildResponse(); 
		try {
			Session Nsession = getSession(session);
		   	Autoart aa = dao.findAutoartbyID(aaid);	
			if (aa != null) {
				aar.setBild(aa.getBild());
			} else {
				throw new NichtVorhandenException("Die Autoart ist nicht vorhanden");
			}
		} catch (OnlineIntegrationExceptions e) {
			aar.setReturnCode(e.getErrorCode());
			aar.setMessage(e.getMessage());
		}	   
		return aar;
	}
    
    /**
     * @author Marian Vennewald
     * Speichert eine neue Miete an
     *
     * @param Session id vom Aktiven Benutzer übergeben
     * @param anfangskm von dem gemieteten Auto
     * @param autoId Id des gemieteten Autos
     * @param kundeEmail email des aktiven Benutzer der das Auto Mieten möchte
     * @return neuerEintragResponse {@link de.autovermietung.dio.neuerEintragResponse neuerEintragResponse }
     * @throws KeineSessionException wenn Session nicht vorhanden
     * @throws NichtVorhandenException falls der Kunde oder das Auto nicht vorhanden ist
     * @throws InsertException falls beim einfügen ein Fehler aufgetreten ist
     */
    public neuerEintragResponse saveMieten(@WebParam(name="Sessionid")int session, @WebParam(name="Anfangskm") double anfangskm,
    									   @WebParam(name="Autoid")int autoId, @WebParam(name="Kundeemail")String kundeEmail) {
    	neuerEintragResponse neu = new neuerEintragResponse();
    	try {
    		Session Nsession = getSession(session);
			if (dao.findAutobyID(autoId) != null && dao.findKundebyEmail(kundeEmail) != null) {
				Auto auto = dao.findAutobyID(autoId);
				Kunde kunde = dao.findKundebyEmail(kundeEmail);
			   	Mieten mieten = dao.createMieten(anfangskm, auto, kunde);
			   	if (mieten != null) {
					neu.setSuccessful(true);
				} else {
					neu.setSuccessful(false);
					throw new InsertException("Einfügen des Mieten ist fehlgeschlagen");
				}
			} else {
				throw new NichtVorhandenException("Kunde oder Auto nicht vorhanden");
			}
		} catch (OnlineIntegrationExceptions e) {
			neu.setReturnCode(e.getErrorCode());
			neu.setMessage(e.getMessage());
			neu.setSuccessful(false);
		}
    	return neu;
    }
    
    /**
     * @author Marian Vennewald
     * Liefert eine Miete zurück
     *
     * @param Session id vom Aktiven Benutzer übergeben
     * @param mid Id der Miete
     * @return MietenResponse {@link de.autovermietung.dio.MietenResponse MietenResponse }
     * @throws KeineSessionException wenn Session nicht vorhanden
     * @throws NichtVorhandenException falls die Miete nicht vorhanden ist
     */
    public MietenResponse getMieten(@WebParam(name="Sessionid")int session, @WebParam(name="Mietenid") int mid) {
    	MietenResponse mr = new MietenResponse();
    	try {
    		Session Nsession = getSession(session);
			Mieten m = dao.findMietenbyID(mid);
				if (m != null) {
					mr.setMid(mid);
					mr.setAnfangskm(m.getAnfangskm());
					mr.setEndkm(m.getEndkm());
					mr.setDiff(m.getDiff());
					mr.setAutoId(m.getAuto().getAid());
					mr.setKundeEmail(m.getKunde().getEmail());
					mr.setTimestamp(m.getTimestamp().toString());
				} else {
					throw new NichtVorhandenException("Die Miete ist nicht vorhanden");
				}
		} catch (OnlineIntegrationExceptions e) {
			mr.setReturnCode(e.getErrorCode());
			mr.setMessage(e.getMessage());
		}
    	return mr;
    }
    
    /**
     * @author Marian Vennewald
     * Liefert alle Mieten zurück
     *
     * @param Session id vom Aktiven Benutzer übergeben
     * @return MietenListResponse {@link de.autovermietung.dio.MietenListResponse MietenListResponse }
     * @throws KeineSessionException wenn Session nicht vorhanden
     */
    public MietenListResponse getAllMieten(@WebParam(name="Sessionid") int session){	
    	MietenListResponse mr = new MietenListResponse();
    	try {
    		Session sessionId = getSession(session);
    		List<Integer> mId = dao.getAllMietenId();
    		List<Mieten> mietenList = new ArrayList<>();
    		for(int i = 0; i < mId.size(); i++) {
    			Mieten mieten = dao.findMietenbyID(mId.get(i));
    			mietenList.add(mieten);
    		}
    		mr.setMietenList(dto.makeDto(mietenList));
		} catch (OnlineIntegrationExceptions e) {
			mr.setReturnCode(e.getErrorCode());
			mr.setMessage(e.getMessage());
		}
    	return mr;
    }
    
    /**
     * @author Marian Vennewald
     * Liefert alle Mieten eines Autos zurück
     *
     * @param Session id vom Aktiven Benutzer übergeben
     * @param aid id des gewählten Autos
     * @return MietenListResponse {@link de.autovermietung.dio.MietenListResponse MietenListResponse }
     * @throws KeineSessionException wenn Session nicht vorhanden
     */
    public MietenListResponse getAllMietenAid(@WebParam(name="Sessionid") int session, @WebParam(name="Aid") int aid){	
    	MietenListResponse mr = new MietenListResponse();
    	try {
    		Session sessionId = getSession(session);
    		List<Integer> mId = dao.getAllMietenId();
    		List<Mieten> mietenList = new ArrayList<>();
    		for(int i = 0; i < mId.size(); i++) {
    			Mieten mieten = dao.findMietenbyID(mId.get(i));
    			if(mieten.getAuto().getAid() == aid)
    				mietenList.add(mieten);
    		}
    		mr.setMietenList(dto.makeDto(mietenList));
		} catch (OnlineIntegrationExceptions e) {
			mr.setReturnCode(e.getErrorCode());
			mr.setMessage(e.getMessage());
		}
    	return mr;
    }
    
    /**
     * @author Marian Vennewald
     * Liefert alle Mieten eines Kundens zurück
     *
     * @param Session id vom Aktiven Benutzer übergeben
     * @param email des aktiven Benutzers
     * @return MietenListResponse {@link de.autovermietung.dio.MietenListResponse MietenListResponse }
     * @throws KeineSessionException wenn Session nicht vorhanden
     */
    public MietenListResponse getAllMietenKEmail(@WebParam(name="Sessionid") int session, @WebParam(name="Kemail") String email){	
    	MietenListResponse mr = new MietenListResponse();
    	try {
    		Session sessionId = getSession(session);
    		List<Integer> mId = dao.getAllMietenId();
    		List<Mieten> mietenList = new ArrayList<>();
    		for(int i = 0; i < mId.size(); i++) {
    			Mieten mieten = dao.findMietenbyID(mId.get(i));
    			if(mieten.getKunde().getEmail().equals(email));
    				mietenList.add(mieten);
    		}
    		mr.setMietenList(dto.makeDto(mietenList));
		} catch (OnlineIntegrationExceptions e) {
			mr.setReturnCode(e.getErrorCode());
			mr.setMessage(e.getMessage());
		}
    	return mr;
    }
    
    /**
     * @author Marian Vennewald
     * Aktualisiert eine Miete (Auto wird abgegeben)
     *
     * @param Session id vom Aktiven Benutzer übergeben
     * @param mid id der gewählten Miete
     * @param endKm des Autos das Gemietet wurde
     * @param position des Autos das Gemietet wurde
     * @return UpdateResponse {@link de.autovermietung.dio.UpdateResponse UpdateResponse }
     * @throws KeineSessionException wenn Session nicht vorhanden
     * @throws NichtVorhandenException falls die Miete nicht vorhanden ist
     */
    public UpdateResponse updateMieten(@WebParam(name="Sessionid")int session, @WebParam(name="Mietenid") int mid, 
    								   @WebParam(name="Endkilometer") String endKm, @WebParam(name="Position") String position) {
    	UpdateResponse uM = new UpdateResponse();
    	try {
    		Session Nsession = getSession(session);
			Mieten m = dao.findMietenbyID(mid);
			if (m != null) {
				m.setEndkm(Double.parseDouble(endKm));
				m.getAuto().setPosition(position);
				uM.setSuccessful(true);
			} else {
				throw new NichtVorhandenException("Die Miete ist nicht vorhanden");
			}
		} catch (OnlineIntegrationExceptions e) {
			uM.setReturnCode(e.getErrorCode());
			uM.setMessage(e.getMessage());
			uM.setSuccessful(false);
		}
    	return uM;
    }
    
    /**
     * @author Carlo Eefting
     * Liefert eine Rechnung zurück
     *
     * @param Session id vom Aktiven Benutzer übergeben
     * @param rid id der Rechnung 
     * @return RechnungsResponse {@link de.autovermietung.dio.RechnungsResponse} RechnungsResponse
     * @throws KeineSessionException wenn Session nicht vorhanden
     * @throws NichtVorhandenException falls die Rechnung nicht vorhanden ist
     */
    public RechnungsResponse getRechnung(@WebParam(name="Sessionid") int session,@WebParam(name="Rechnungsid") int rid){
		RechnungsResponse rechnung = new RechnungsResponse();
		try {
			Session Nsession = getSession(session);	
		   	Rechnung r = dao.findRechnungbyID(rid);	
			if (r != null) {
				rechnung.setGesamtpreis(r.getGesamtpreis());
				rechnung.setMwst(r.getMwst());
				rechnung.setRechnungspositionen(r.getRechnungspositionen());
				rechnung.setKunde(r.getKunde());
				rechnung.setRid(rid);
				rechnung.setTimestamp(r.getTimestamp());
				rechnung.setAbgerechnet(r.isAbgerechnet());
			} else {
				throw new NichtVorhandenException("Rechnung ist nicht vorhanden");
			}
		} catch (OnlineIntegrationExceptions e) {
			rechnung.setReturnCode(e.getErrorCode());
			rechnung.setMessage(e.getMessage());
		}
		return rechnung;
	}
    /*
     * Aktualisierung der Kunden Daten
     */
    /**
     * @author Carlo Eefting
     * Aktualisiert einen Kunden
     *
     * @param Session id vom Aktiven Benutzer übergeben
     * @param email des Kunden
     * @param kpassword password des Kunden
     * @param knachname nachname des Kunden
     * @param kvorname vorname des Kunden
     * @param strasse des Kunden
     * @param plz des Kunden
     * @param fsnummer führerscheinnummer des Kunden
     * @param pan Personalausweisnummer des Kunden
     * @return EditResponse {@link de.autovermietung.dio.EditResponse EditResponse }
     * @throws KeineSessionException wenn Session nicht vorhanden
     * @throws NichtVorhandenException falls der Kunde nicht vorhanden ist
     */
    public EditResponse updateKunde(@WebParam(name="Sessionid") int session,@WebParam(name="email") String email,
    		@WebParam(name="Password") String kpassword,
    		@WebParam(name="Nachname")String knachname,
    		@WebParam(name="Vorname")String kvorname,
    		@WebParam(name="Strasse")String strasse,
    		@WebParam(name="PLZ")String plz,
    		@WebParam(name="Fsnummer")String fsnummer,
    		@WebParam(name="Pan")String pan){
		EditResponse up = new EditResponse();
		
		 try {
			Session Nsession = getSession(session);
		   	Kunde k = dao.findKundebyEmail(email);
				if (k != null) {
					k.setEmail(email);
					k.setKpassword(kpassword);
					k.setKnachname(knachname);
					k.setKvorname(kvorname);
					k.setStrasse(strasse);
					k.setKplz(dao.findPlzByID(plz));
					k.setFsnummer(fsnummer);
					k.setPan(pan);
					up.setSuccessful(true);
					} else {
						throw new NichtVorhandenException("Kunde ist nicht vorhanden");
					}
				} catch (OnlineIntegrationExceptions e) {
					up.setReturnCode(e.getErrorCode());
					up.setMessage(e.getMessage());
				}
		  return up;
	}
    
    /*
     * Rechnung auf bezahlt setzen
     */
    /**
     * @author Carlo Eefting
     * Rechnung bezahlen.
     *
     * @param Session id vom Aktiven Benutzer übergeben
     * @param rid id einer Rechnung
     * @return EditResponse {@link de.autovermietung.dio.EditResponse EditResponse}
     * @throws KeineSessionException wenn Session nicht vorhanden
     * @throws NichtVorhandenException falls die Rechnung nicht vorhanden ist
     */
    public EditResponse rechnungBezahlen(@WebParam(name="Sessionid") int session,@WebParam(name="Rechnungsid") int rid){
    	EditResponse response = new EditResponse();
		 try {
			Session Nsession = getSession(session);
		   	Rechnung rechn = dao.findRechnungbyID(rid);
				if (rechn != null) {
					rechn.setBezahlt(true);
					response.setSuccessful(true);		
					} else {
						throw new NichtVorhandenException("Rechnung ist nicht vorhanden");
					}
				} catch (OnlineIntegrationExceptions e) {
					response.setReturnCode(e.getErrorCode());
					response.setMessage(e.getMessage());
				}
		  return response;	
	}
    /*
     * Bezahlmethode hinzufügen
     */
    /**
     * @author Carlo Eefting
     * Fügt eine Bezahlmethode hinzu
     *
     * @param Session id vom Aktiven Benutzer übergeben
     * @param email des Kunden
     * @param bezmeth Bezahlmethode
     * @return EditResponse {@link de.autovermietung.dio.EditResponse EditResponse }
     * @throws KeineSessionException wenn Session nicht vorhanden
     * @throws NichtVorhandenException falls der Kunde nicht vorhanden ist
     */
    public EditResponse addBezahlmethode(@WebParam(name="Sessionid") int session,@WebParam(name="email") String email,
    		@WebParam(name="addBezmeth") Bezahlmethode bezmeth){
		EditResponse edit = new EditResponse();
		 try {
			Session Nsession = getSession(session);
		   	Kunde kunde = dao.findKundebyEmail(email);
				if (kunde != null) {
					kunde.addBezahlmethoden(bezmeth);
					edit.setSuccessful(true);
				} else {
					throw new NichtVorhandenException("Kunde ist nicht vorhanden");
				}
			} catch (OnlineIntegrationExceptions e) {
				edit.setReturnCode(e.getErrorCode());
				edit.setMessage(e.getMessage());
			}
		  return edit;
	}
    /*
     * register Kunde
     */
    /**
     * @author Carlo Eefting
     * Neuen Kunden anlegen
     *
     * @param Session id vom Aktiven Benutzer übergeben
     * @param Email des Kunden
     * @param kpassword password des Kunden
     * @param knachname Nachname des Kunden
     * @param kvorname Vorname des Kunden
     * @param strasse des kunden
     * @param kplz Plz des Kunden
     * @param fsn Führerscheinnummer des Kunden
     * @param pan Personalausweisnummer des Kunden
     * @return neuerEintragResponse {@link de.autovermietung.dio.neuerEintragResponse neuerEintragResponse }
     * @throws KeineSessionException wenn Session nicht vorhanden
     * @throws NichtVorhandenException falls der Kunde schon angelegt wurde
     */
    public neuerEintragResponse regisKunde(@WebParam(name="Sessionid") int session,
    		@WebParam(name="email") String Email,
    		@WebParam(name="Password") String kpassword,
    		@WebParam(name="Nachname")String knachname,
    		@WebParam(name="Vorname")String kvorname,
    		@WebParam(name="Strasse")String strasse,
    		@WebParam(name="PLZ")String kplz,
    		@WebParam(name="fsn")String fsn,
    		@WebParam(name="pan")String pan) {
		neuerEintragResponse up = new neuerEintragResponse();
		
		try {
			Session Nsession = getSession(session);
			Kunde k = dao.findKundebyEmail(Email);
				if (k == null) {
					outputRequester.sendMessage(dao.createKunde(Email,kvorname, knachname,  kpassword, fsn, pan, strasse, dao.findPlzByID(kplz)));
					up.setSuccessful(true);
				} else {
					throw new NichtVorhandenException("Kunde ist schon vorhanden");
				}
		} catch (OnlineIntegrationExceptions e) {
			up.setReturnCode(e.getErrorCode());
			up.setMessage(e.getMessage());
		}
		return up;
    }
}