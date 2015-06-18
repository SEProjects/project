package de.autovermietung.util;



import javax.ejb.Stateless;

import de.autovermietung.dto.AutoArtResponse;
import de.autovermietung.dto.KundeResponse;
import de.autovermietung.entities.Autoart;
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
		  kr.setStraße(kunde.getStrasse());
		  kr.setSaf(kunde.isSaf());
		  kr.setAdmin(kunde.isAdmin());
		  kr.setFsaName(kunde.getFsa().getFsaname());
		  kr.setPlz(kunde.getKplz().getPlz());
		  kr.setWohnort(kunde.getKplz().getWohnort());
		  return kr;
	  }
	  public AutoArtResponse makeDTO(Autoart aa){
		  AutoArtResponse aar = new AutoArtResponse(); 
		  aar.setAaid(aa.getAaid());
		  aar.setBeschreibung(aa.getBeschreibung());
		
		  aar.setKofferraumvolumen(aa.getKofferraumvolumen());
		  aar.setKraftstoffverbrauch(aa.getKraftstoffverbrauch());
		  aar.setKs(aa.getKs().getKsid());
		  aar.setMarke(aa.getMarke().getMarkeid());
		  aar.setPjk(aa.getPjk());
		  aar.setPs(aa.getPs());
		  aar.setSitzanzahl(aa.getSitzanzahl());
		  
		  return aar;
	  }
}
