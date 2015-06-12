package de.autovermietung.dto;

import java.util.ArrayList;
import java.util.List;

import de.autovermietung.entities.Kunde;

public class AlleKundenResponse extends ReturncodeResponse {

		private static final long serialVersionUID = -3173158310918408228L;
		private List<Object[]> kunden;
		
		
		public AlleKundenResponse(){
	
		}


		public List<Object[]> getKunden() {
			return kunden;
		}


		public void setKunden(List<Object[]> kunden) {
			this.kunden = kunden;
		}



	
		
	
}
