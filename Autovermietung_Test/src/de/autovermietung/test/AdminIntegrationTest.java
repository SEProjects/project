package de.autovermietung.test;



import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceClient;

import org.junit.BeforeClass;
import org.junit.Test;

import de.autovermietung.onlinesystem.OnlineAdminIntegration;
import de.autovermietung.onlinesystem.OnlineAdminIntegrationService;



public class AdminIntegrationTest{
	public static int sessionid;
	
	private static OnlineAdminIntegration remoteSystem;
		@BeforeClass
	    public static  void StartUp(){
	try {
		   OnlineAdminIntegrationService service = new   OnlineAdminIntegrationService();
		   remoteSystem = service.getOnlineAdminIntegrationPort();
	       
	       //Zeige, welche Referenz auf das Server-Objekt der Client erhalten hast:
	       System.out.println("Client hat folgendes Server-Objekt erhalten:");
	       System.out.println(remoteSystem.toString());
	       System.out.println();
	       sessionid = remoteSystem.adminlogin("Kevin@web.de", "1234").getSession();
	       //Test-Szeanarien ausfuehren:
		
		   
		}
		catch (Exception ex) {
		   	System.out.println(ex);
		   	ex.printStackTrace();
		}
	    }
		@Test
		public void Ĺogin(){
			 assertEquals(remoteSystem.adminlogin("Kevin@web.de", "1234").getReturnCode(),0);
		
		}
		@Test
		public void ĹoginfalscherKunde(){
			 assertEquals(remoteSystem.adminlogin("", "1234").getReturnCode(),20);
		
		}
		@Test
		public void ĹoginfalschesPW(){
			 assertEquals(remoteSystem.adminlogin("Kevin@web.de", "123433").getReturnCode(),20);
		
		}
		@Test 
		public void SessionFalsch(){
			assertEquals(remoteSystem.getAllAutos(-2).getReturnCode(),10);
		}
		@Test
		public void getAllAutos(){
			assertEquals(remoteSystem.getAllAutos(sessionid).getReturnCode(),0);
		}
		@Test
		public void getAllAA(){
			assertEquals(remoteSystem.getAllAA(sessionid).getReturnCode(),0);
		}
		@Test
		public void getAllDreck(){
			assertEquals(remoteSystem.getAllDreck(sessionid).getReturnCode(),0);
		}
		@Test
		public void getAllSchaeden(){
			assertEquals(remoteSystem.getAllSchaeden(sessionid).getReturnCode(),0);
		}
		@Test
		public void getAllRechnungen(){
			assertEquals(remoteSystem.getAllRechnungen(sessionid).getReturnCode(),0);
		}
		@Test
		public void getAllMarken(){
			assertEquals(remoteSystem.getAllMarken(sessionid).getReturnCode(),0);
		}
		@Test
		public void getAllKS(){
			assertEquals(remoteSystem.getAllKS(sessionid).getReturnCode(),0);
		}
		
		
		
		
}
