package de.autovermietung.onlineSystem;



import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

import org.jboss.logging.Logger;

import de.autovermietung.dao.AutovermietungDAOAdminLocal;
import de.autovermietung.dao.Databuilder;
import de.autovermietung.dto.AlleAutosResponse;
import de.autovermietung.dto.AlleKundenResponse;
import de.autovermietung.dto.AlleMarkenResponse;
import de.autovermietung.dto.AutoArtBildResponse;
import de.autovermietung.dto.AutoArtResponse;
import de.autovermietung.dto.AutoResponse;
import de.autovermietung.dto.GetAllResponse;
import de.autovermietung.dto.KSResponse;
import de.autovermietung.dto.KundeEditResponse;
import de.autovermietung.dto.KundeResponse;
import de.autovermietung.dto.KundenLoginResponse;
import de.autovermietung.dto.MarkeResponse;
import de.autovermietung.dto.UpdateResponse;
import de.autovermietung.dto.neueMarkeResponse;
import de.autovermietung.dto.neuerEintragResponse;
import de.autovermietung.entities.Auto;
import de.autovermietung.entities.Autoart;
import de.autovermietung.entities.Kraftstoff;
import de.autovermietung.entities.Kunde;
import de.autovermietung.entities.Marke;
import de.autovermietung.entities.Session;
import de.autovermietung.exceptions.InsertException;
import de.autovermietung.exceptions.InvalidLoginException;
import de.autovermietung.exceptions.KeineAutosException;
import de.autovermietung.exceptions.KeineKundenException;
import de.autovermietung.exceptions.KeineMarkenException;
import de.autovermietung.exceptions.KeineSessioException;
import de.autovermietung.exceptions.KundeNichtVorhandenException;
import de.autovermietung.exceptions.NichtVorhandenException;
import de.autovermietung.exceptions.OnlineIntegrationExceptions;
import de.autovermietung.exceptions.SessionabgelaufenException;
import de.autovermietung.util.DtoAssembler;

/**
 * Session Bean implementation class OnlineAdminIntegration
 */
@Stateless
@WebService
public class OnlineAdminIntegration {

    /**
     * Default constructor. 
     */
	@EJB(beanName = "AutovermietungDAO", beanInterface = de.autovermietung.dao.AutovermietungDAOAdminLocal.class)
	private AutovermietungDAOAdminLocal dao;
	@Resource
	private WebServiceContext wsContext;
	@EJB
	private DtoAssembler dto;
	private static final Logger logger = Logger.getLogger(Databuilder.class);
    public OnlineAdminIntegration() {
        // TODO Auto-generated constructor stub
    }
    
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
   private Session getSession(int Id) throws SessionabgelaufenException, KeineSessioException{
	   Session session = dao.findSessionbyId(Id);
	   if(session == null )
		   throw new KeineSessioException("Bitte loggen Sie sich zuerst ein.");
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
    
    public String test(@WebParam(name="Sessionid") int session)   {
    	
    	try{
    	Session Nsession = getSession(session);
    	return "ja";
    	}
    	catch (OnlineIntegrationExceptions e)
    	{
    		return "nein";
    	}
    }
    public AlleKundenResponse getAllKunden(@WebParam(name="Sessionid") int session){
    	AlleKundenResponse akr = new AlleKundenResponse();
    	try {
    		Session Nsession = getSession(session);
			List<Object[]> kunden = this.dao.getAllKunden();	
			
			if (kunden.isEmpty() == false) {
				akr.setKunden(kunden);
			}
			else {
				
				throw new KeineKundenException("Es sind noch keine Kunden vorhanden");
			}
		}
		catch (OnlineIntegrationExceptions e) {
			akr.setReturnCode(e.getErrorCode());
			akr.setMessage(e.getMessage());
		}
    	
    	
    	return akr;
    }
    
    public KundeResponse getKunde(@WebParam(name="Sessionid") int session,@WebParam(name="Kundeemail") String id){
       KundeResponse kr = new KundeResponse();
    	try {
    		Session Nsession = getSession(session);
			Kunde kunde = dao.findKundebyEmail(id);	
			
			if (kunde != null) {
				kr = dto.makeDTO(kunde);
			}
			else {
				
				throw new KundeNichtVorhandenException("Kunde nicht vorhanden");
			}
		}
		catch (OnlineIntegrationExceptions e) {
			kr.setReturnCode(e.getErrorCode());
			kr.setMessage(e.getMessage());
		}
    	
    	
    	return kr;
    
    }
    public KundeEditResponse saveKunde(@WebParam(name="Sessionid") int session,@WebParam(name="Kundeemail") String id,
    		@WebParam(name="kvorname") String kvorname,@WebParam(name="knachname") String knachname,@WebParam(name="fsnummer") String fsnummer,
    		@WebParam(name="pan") String pan,@WebParam(name="saf") boolean saf,@WebParam(name="admin") boolean admin){
    	KundeEditResponse ker = new KundeEditResponse();
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
    public AlleAutosResponse getAllAutos(@WebParam(name="Sessionid") int session){
    	
    	AlleAutosResponse aar = new AlleAutosResponse();
    	try {
    		Session Nsession = getSession(session);
			List<Object[]> autos = this.dao.getAllAutos();	
	
			if (autos.isEmpty() == false) {
				aar.setAutos(autos);
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
   public AlleMarkenResponse getAllMarken(@WebParam(name="Sessionid") int session){
    	
    	AlleMarkenResponse amr = new AlleMarkenResponse();
    	try {
    		Session Nsession = getSession(session);
			List<Object[]> marken = this.dao.getAllMarken();	
	
			if (marken.isEmpty() == false) {
				amr.setMarken(marken);
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
   public neueMarkeResponse createMarke(@WebParam(name="Sessionid") int session,@WebParam(name="Markenname") String Marke){
	   neueMarkeResponse nmr = new neueMarkeResponse();
	   try {
   		Session Nsession = getSession(session);
   		Marke marke = dao.createMarke(Marke);
			
			if (marke != null) {
				nmr.setSuccessful(true);
			}
			else {
				nmr.setSuccessful(false);
				throw new InsertException("Einfügen der Marke ist fehlgeschlagen");
			}
		}
		catch (OnlineIntegrationExceptions e) {
			nmr.setReturnCode(e.getErrorCode());
			nmr.setMessage(e.getMessage());
		}
	   
	   
	   
	   
	   
	   return nmr;  
	   
	   
   }
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
	public GetAllResponse getAllAA(@WebParam(name="Sessionid") int session){
	
	  GetAllResponse  agr = new  GetAllResponse();
	  	try {
	  		Session Nsession = getSession(session);
				List<Object[]> ks = this.dao.getAllAA();	
		
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
	public AutoArtResponse getAA(@WebParam(name="Sessionid") int session,@WebParam(name="AAid") int aaid){
		AutoArtResponse aar = new AutoArtResponse(); 
		 try {
		   		Session Nsession = getSession(session);
		   		Autoart aa = dao.findAutoartbyID(aaid);
				
					if (aa != null) {
						aar=dto.makeDTO(aa);
					}
					else {
						
						throw new NichtVorhandenException("Die Marke ist nicht vorhanden");
					}
				}
				catch (OnlineIntegrationExceptions e) {
					aar.setReturnCode(e.getErrorCode());
					aar.setMessage(e.getMessage());
				}
			   
		return aar;
	}
	public UpdateResponse saveAA(@WebParam(name="Sessionid") int session,@WebParam(name="AAid") int Id,@WebParam(name="beschreibung") String beschreibung,@WebParam(name="bildlink") String bildlink,@WebParam(name="kofferraumvolumen") int kofferraumvolumen,@WebParam(name="kraftstoffverbrauch") String kraftstoffverbrauch, @WebParam(name="ks") int ksid,@WebParam(name="marke") int markenid,@WebParam(name="pjk") double pjk,@WebParam(name="ps") int ps,@WebParam(name="sitzanzahl") int sitzanzahl){
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
	public GetAllResponse getAllRechungen(@WebParam(name="Sessionid") int session){
		
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
	public neuerEintragResponse createAllRechungen(@WebParam(name="Sessionid") int session,@WebParam(name="bez") String bez,@WebParam(name="AAid") int AAid){
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
	
	 
}
