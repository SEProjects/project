package de.autovermietung.util;



import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import de.autovermietung.dto.AutoArtResponse;
import de.autovermietung.dto.AutoResponse;
import de.autovermietung.dto.KundeResponse;
import de.autovermietung.entities.Auto;
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
	  public AutoResponse makeDTO(Auto auto) {
		  AutoResponse autoR = new AutoResponse();
		  autoR.setAid(auto.getAid());
		  autoR.setBez(auto.getBez());
		  autoR.setPosition(auto.getPosition());
		  autoR.setAa(auto.getAutoart().getAaid());
		  return autoR;
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
	  public List<AutoResponse> makeDTO(List<Auto> auto) {
		  ArrayList<AutoResponse> dtoList = new ArrayList<>();
		  for (Auto a : auto) {
			  dtoList.add(this.makeDTO(a));
		  }
		  return dtoList;
	  }
}
