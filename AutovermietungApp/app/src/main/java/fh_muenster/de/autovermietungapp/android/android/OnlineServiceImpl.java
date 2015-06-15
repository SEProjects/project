package fh_muenster.de.autovermietungapp.android.android;

import android.util.Log;
import org.ksoap2.HeaderProperty;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import java.util.List;

import fh_muenster.de.autovermietung.AutovermietungOnlineService;
import fh_muenster.de.autovermietung.Kunde;
import fh_muenster.de.autovermietung.exceptions.InvalidLoginException;
import fh_muenster.de.autovermietung.exceptions.NoSessionException;

/**
 * Created by marian on 10.06.15.
 */
public class OnlineServiceImpl implements AutovermietungOnlineService {

	/**
	 * Namespace is the targetNamespace in the WSDL.
	 */
	private static final String NAMESPACE = "http://onlineSystem.autovermietung.de/";
	/**
	 * The WSDL URL. Its value is the location attribute of the soap:address element for a port
	 * element in a WSDL. Unless the web service is also hosted on the Android device, the hostname
	 * should not be specified as localhost, because the application runs on the Android device while
	 * the web service is hosted on the localhost server. Specify hostname as the IP address of the
	 * server hosting the web service (or "10.0.2.2 instead of 'localhost' when running in the emulator).
	 */
		private static final String URL = "http://10.60.70.14:8080/Autovermietung_OnlineSystem/OnlineIntegration";

	/**
	 * TAG contains the class name and is used for logging.
	 */
	private static final String TAG = OnlineServiceImpl.class.getName();

	private int sessionId;

	@Override
	public Kunde login(String email, String password) throws InvalidLoginException {
		Kunde result = null;
		String METHOD_NAME = "login";
		SoapObject response = null;
		try {
			response = executeSoapAction(METHOD_NAME, email, password);
			Log.d(TAG, response.toString());
			this.sessionId = Integer.parseInt(response.getPrimitivePropertySafelyAsString("session"));
			if (sessionId != 0) {
				result = new Kunde(email, password);
				return result;
			}
			else {
				throw new InvalidLoginException("Login not successful!");
			}
		} catch (SoapFault e) {
			throw new InvalidLoginException(e.getMessage());
		}
	}

	@Override
	public void logout() throws NoSessionException {

	}

	/**
	 * Diese Methode delegiert einen Methodenaufruf an den hinterlegten WebService.
	 * @param methodName
	 * @return
	 */
	private SoapObject executeSoapAction(String methodName, Object... args) throws SoapFault {

		Object result = null;

	    /* Create a org.ksoap2.serialization.SoapObject object to build a SOAP request. Specify the namespace of the SOAP object and method
	     * name to be invoked in the SoapObject constructor.
	     */
		SoapObject request = new SoapObject(NAMESPACE, methodName);

	    /* The array of arguments is copied into properties of the SOAP request using the addProperty method. */
		/*for (int i=0; i<args.length; i++) {
			request.addProperty(args[i].toString(), args[i]);
		}*/
		request.addProperty("email", args[0]);
		request.addProperty("password", args[1]);
	    /* Next create a SOAP envelop. Use the SoapSerializationEnvelope class, which extends the SoapEnvelop class, with support for SOAP
	     * Serialization format, which represents the structure of a SOAP serialized message. The main advantage of SOAP serialization is portability.
	     * The constant SoapEnvelope.VER11 indicates SOAP Version 1.1, which is default for a JAX-WS webservice endpoint under JBoss.
	     */
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

	    /* Assign the SoapObject request object to the envelop as the outbound message for the SOAP method call. */
		envelope.setOutputSoapObject(request);

	    /* Create a org.ksoap2.transport.HttpTransportSE object that represents a J2SE based HttpTransport layer. HttpTransportSE extends
	     * the org.ksoap2.transport.Transport class, which encapsulates the serialization and deserialization of SOAP messages.
	     */
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
	        /* Make the soap call using the SOAP_ACTION and the soap envelop. */
			List<HeaderProperty> reqHeaders = null;

			@SuppressWarnings({"unused", "unchecked"})
			//List<HeaderProperty> respHeaders = androidHttpTransport.call(NAMESPACE + methodName, envelope, reqHeaders);
							//fuehrt zu CXF-Fehler! neue Version ohne SOAP-Action funktioniert:
							List<HeaderProperty> respHeaders = androidHttpTransport.call("", envelope, reqHeaders);

	        /* Get the web service response using the getResponse method of the SoapSerializationEnvelope object.
	         * The result has to be cast to SoapPrimitive, the class used to encapsulate primitive types, or to SoapObject.
	         */
			result = envelope.getResponse();

			if (result instanceof SoapFault) {
				throw (SoapFault) result;
			}
		}
		catch (SoapFault e) {
			e.printStackTrace();
			throw e;
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return (SoapObject) result;
	}
}
