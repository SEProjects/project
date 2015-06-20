package de.autovermietung.dto;

import java.util.List;


// TODO: Auto-generated Javadoc
/**
 * The Class AlleKundenResponse.
 */
public class AlleKundenResponse extends ReturncodeResponse {

		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = -3173158310918408228L;
		
		/** The kunden. */
		private List<Object[]> kunden;
		
		
		/**
		 * Instantiates a new alle kunden response.
		 */
		public AlleKundenResponse(){
	
		}


		/**
		 * Gets the kunden.
		 *
		 * @return the kunden
		 */
		public List<Object[]> getKunden() {
			return kunden;
		}


		/**
		 * Sets the kunden.
		 *
		 * @param kunden the new kunden
		 */
		public void setKunden(List<Object[]> kunden) {
			this.kunden = kunden;
		}



	
		
	
}
