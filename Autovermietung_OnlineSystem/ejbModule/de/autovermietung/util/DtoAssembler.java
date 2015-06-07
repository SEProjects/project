package de.autovermietung.util;



import javax.ejb.Stateless;

import de.autovermietung.dto.KundeResponse;
import de.autovermietung.entities.Kunde;


@Stateless
public class DtoAssembler {
	  public KundeResponse makeDTO(Kunde kunde) {
		  KundeResponse kr = new KundeResponse();
		  kr.setEmail(kunde.getEmail());
			kr.setKvorname(kunde.getKvorname());
			kr.setKnachname(kunde.getKnachname());
			kr.setFsnummer(kunde.getFsnummer());
			kr.setPan(kunde.getPan());
		    kr.setSaf(kunde.isSaf());
			kr.setAdmin(kunde.isAdmin());
			
	
		  return kr;
	  }

}
