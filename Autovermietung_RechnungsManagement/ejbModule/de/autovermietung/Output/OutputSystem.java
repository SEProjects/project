package de.autovermietung.Output;

import java.util.Properties;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJBException;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.jboss.logging.Logger;




// TODO: Auto-generated Javadoc
/**
 * @author Kevin Haase
 * Message-Driven Bean  für den Rechnungsversand in der Nacht + Druck in der Nacht
 */
@MessageDriven(
		activationConfig = {  
				 @ActivationConfigProperty(
				      propertyName = "destinationType",
				      propertyValue = "javax.jms.Queue"),
				 @ActivationConfigProperty(
				      propertyName = "destination",
				      propertyValue = "java:jboss/exported/jms/queue/RechnungsSystemOut")})
public class OutputSystem implements MessageListener {

/** The Constant logger. */
private static final Logger logger = Logger.getLogger(OutputSystem.class);

/** anmeldung für den Googlemailserver */
@Resource(name = "java:jboss/mail/gmail")
private Session session;
	/**
	 * Messages werden aus der Queue abgerufen und als Email zum Kunden versendet.
	 */
	@Override
	public void onMessage(Message message) {
       try {
    	  TextMessage msg = (TextMessage) message;
          logger.info("Received message from queue/BankingOutput: " + msg.getText());
       // Recipient's email ID needs to be mentioned.
          
        

          try{
              
            	  
        	  javax.mail.Message message1 =  new javax.mail.internet.MimeMessage(session);
                  message1.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse("autovermietungfhm@gmail.com"));
                  message1.setSubject("Rechnung");
                  Multipart mp = new MimeMultipart();
                  MimeBodyPart htmlPart = new MimeBodyPart();
            

              
                 
                  htmlPart.setContent(msg.getText(), "text/html; charset=utf-8");
                  mp.addBodyPart(htmlPart);
                  message1.setContent(mp);
                  Transport.send(message1);

          
             System.out.println("Sent message successfully....");
          }catch (MessagingException mex) {
             mex.printStackTrace();
          }
       }
       catch (JMSException e) {
            throw new EJBException(e);
       }
    }

}
