package de.autovermietung.exceptions;

// TODO: Auto-generated Javadoc
/**
 * @author Kevin Haase
 * Superklasse von allen ContextExceptions Autovermietung
 */
public class OnlineIntegrationExceptions extends Exception {
	
		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = -1658425297634781761L;

		/** The error code. */
		private int errorCode;
		
		/**
		 * Instantiates a new online integration exceptions.
		 *
		 * @param errorCode spezifischer ErrorCode
		 * @param message Nachricht an den Benutzer
		 */
		public OnlineIntegrationExceptions(int errorCode, String message) {
			super(message);
			this.errorCode = errorCode;
		}

		/**
		 * Gets the error code.
		 *
		 * @return the error code
		 */
		public int getErrorCode() {
			return errorCode;
		}

		/**
		 * Sets the error code.
		 *
		 * @param errorCode the new error code
		 */
		public void setErrorCode(int errorCode) {
			this.errorCode = errorCode;
		}

	}


