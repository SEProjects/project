package de.autovermietung.onlineSystem;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.logging.Logger;

import de.autovermietung.dao.Databuilder;
import de.autovermietung.entities.Kunde;
import de.autovermietung.entities.Rechnung;
import de.autovermietung.entities.Mieten;

// TODO: Auto-generated Javadoc
/**
 * Session Bean für die Übergabe der Strings an die MessageDrivenBean
 */
@Stateless
@LocalBean
public class OutputRequesterBean {
	
	/** jms factory für die Connection. */
	@Resource(mappedName="java:/JmsXA")
	private ConnectionFactory jmsFactory;
	 
 	/** Output queue für alle allgemeinen Nachrichten. */
 	@Resource(mappedName="java:jboss/exported/jms/queue/OnlineSystemOut")
	  private Queue outputQueue;
	 
 	/** Rechnungs queue für Alle Rechnungen. */
 	@Resource(mappedName="java:jboss/exported/jms/queue/RechnungsSystemOut")
	  private Queue RechnungsQueue;
	 
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(Databuilder.class);
	
	
	/** The connection. */
	private Connection connection;
    /**
     * Default constructor. 
     */
    public OutputRequesterBean() {
        // TODO Auto-generated constructor stub
    }
    
    /**
     * Versendet Rechnungen an den Nutzer per Email.
     *
     * @param r Rechnung die Übergeben werden soll
     */
    public void sendMessage(Rechnung r){
    	try{
    		SimpleDateFormat f = null;
    		f =(SimpleDateFormat) DateFormat.getDateInstance(DateFormat.FULL, Locale.GERMAN);
    		 String content="<p><b>Rechnung</b><br>Rechnungsnummer:" + r.getRid() + "<br>Datum: " + f.format(new Date())+ "<br>Firma: Autovermietung GmbH<br>Plz:48153<br>Wohnort:Münster<br>Stra&szlig;e:Scheibenstraße 84</p><p>Kundenname: " + r.getKunde().getKvorname() + " " + r.getKunde().getKnachname() + "<br>Kundenemail: " + r.getKunde().getEmail() + "<br>Plz:" + r.getKunde().getKplz().getPlz() + "<br>Wohnort: " + r.getKunde().getKplz().getWohnort() + "<br>Stra&szlig;e:" + r.getKunde().getStrasse() + "</p><hr style='float:left; width:400px; height:1px; border:1px solid; border-color:#004400;'><br><br>Guten Tag,<br>vielen Dank f&uuml;r die Nutzung unserer Mietautos. <br>Hier die Kostenaufstellung Ihrer Nutzung:<br><table><tr>  <tr>               <th>ID</th>                <th>Anfangskm</th>                <th>Endkm</th>            <th>Diff</th>               <th>Auto</th>                <th>Preis je Km</th>                <th>Datum</th>                   <th>Preis</th>           </tr></tr>";
    		String table ="";
    		 for(Mieten m: r.getRechnungspositionen()){
    		 
    		table = table + "<tr><td>" + m.getMid() + "</td><td>"+ m.getAnfangskm() + "</td><td>"+ m.getEndkm() + "</td><td>"+( m.getEndkm()-m.getAnfangskm() )+"</td><td>" + m.getAuto().getAutoart().getBeschreibung() + "</td><td>" + m.getAuto().getAutoart().getPjk() + "</td><td>" + f.format(m.getTimestamp()) +"</td><td>" + (m.getAuto().getAutoart().getPjk().multiply(new BigDecimal(m.getEndkm()-m.getAnfangskm()))) + "</td></tr>";
    		}
    		String endcontent="</table><hr style='float:left; width:400px; height:1px; border:1px solid; border-color:#004400;'><br><br>Preis vor Rabatt: " + r.getVorpreis() + "<br>Rabatt: " + r.getRabatt() + "<br>GesamtPreis: " + r.getGesamtpreis() + "<br>Bitte Zahlen Sie die Summe innerhalb von 30 Tagen mit den vorgebenen Bezahlmethoden.<br>Ich hoffe Sie waren mit unserer Leistung zufrieden. Bei Beanstandunge können Sie mich jederzeit erreichen.<br>Mit freundlichen Grüßen<br>Kevin Haase";
    		content= content + table + endcontent;
    		JMSContext context = jmsFactory.createContext(JMSContext.AUTO_ACKNOWLEDGE);
    		TextMessage message = context.createTextMessage();
    		
    		message.setText(content);
    	
    		context.createProducer().send(RechnungsQueue, message);
    		
    	}
    	catch (JMSException e){
    		e.printStackTrace();
    	}
    }
    
    /**
     * Sendet Kundenregisteriung an die Kunden mit Bestätigungslink.
     *
     * @param k registierter Kunde
     */
    public void sendMessage(Kunde k){
    	try{
    
    		String url="http://10.11.32.175:3000";
    		String content = "Hallo " + k.getKvorname() + " " +k.getKnachname() +  ",<br>Danke das du dich bei  unsere Autovermietung registiert hast.<br>Bitte best&auml;tige deine Email unter folgendem Link:<br> <a href='" + url + "/users/hash/"+ k.getLink() +"'>KlickMich!!</a> <br>Solltest du dich nicht bei uns registiert haben, kannst du diese Email ignorieren.<br>Bei weiteren Fragen kannst du mich gerne unter folgender Email Kontaktieren:<br> <a href='mailto:Kevin.haase.kh@googlemail.com'>Kevin.haase.kh@googlemail.com</a><br>Mit freundlichen Grü&szlig;en<br>Kevin Haase";
    		JMSContext context = jmsFactory.createContext(JMSContext.AUTO_ACKNOWLEDGE);
    		TextMessage message = context.createTextMessage();
    		
    		message.setText(content);
    	
    		context.createProducer().send(outputQueue, message);
    		
    	}
    	catch (JMSException e){
    		e.printStackTrace();
    	}
    }

   
  
}
