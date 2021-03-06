package de.autovermietung.util;



import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import de.autovermietung.dto.AutoArtResponse;
import de.autovermietung.dto.AutoResponse;
import de.autovermietung.dto.KundeResponse;
import de.autovermietung.dto.MietenResponse;
import de.autovermietung.entities.Auto;
import de.autovermietung.entities.Autoart;
import de.autovermietung.entities.Kunde;
import de.autovermietung.entities.Mieten;



// TODO: Auto-generated Javadoc
/**
 * @author Kevin Haase
 * DTOAssembler erstellt größere DTOs
 */
@Stateless
public class DtoAssembler {
	  
  	/**
  	 * Make dto.
  	 *
  	 * @param kunde Kunde der geparsed werden soll
  	 * @return KundeRespnse fertiges DTO
  	 */
  	public KundeResponse makeDTO(Kunde kunde) {
		  KundeResponse kr = new KundeResponse();
		  kr.setEmail(kunde.getEmail());
		  kr.setAktive(kunde.isAktive());
		  kr.setKvorname(kunde.getKvorname());
		  kr.setKnachname(kunde.getKnachname());
		  kr.setFsnummer(kunde.getFsnummer());
		  kr.setPan(kunde.getPan());
		  kr.setStrasse(kunde.getStrasse());
		
		  kr.setAdmin(kunde.isAdmin());
		  
		  kr.setPlz(kunde.getKplz().getPlz());
		  kr.setWohnort(kunde.getKplz().getWohnort());
		  
		  List<Integer> mId = new ArrayList<Integer>();
		  List<Mieten> mieten = kunde.getGemietet();
			for(int i = 0; i < mieten.size(); i++) {
				mId.add(mieten.get(i).getMid());
			}
		  kr.setGemietet(mId);
		  return kr;
	  }
	  
	/**
  	 * Make dto.
  	 *
  	 * @param auto Auto der geparsed werden soll
  	 * @return AutoResponse fertiges DTO
  	 */
  	public AutoResponse makeDTO(Auto auto) {
		  AutoResponse autoR = new AutoResponse();
		  autoR.setAid(auto.getAid());
		  autoR.setBez(auto.getBez());
		  autoR.setPosition(auto.getPosition());
		  autoR.setAa(auto.getAutoart().getAaid());
		  
		  return autoR;
	  }
	  
  	/**
  	 * Make dto.
  	 *
  	 * @param aa Autoart der geparsed werden soll
  	 * @return AutoArtResponse fertiges DTO
  	 */
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
		  aar.setBildlink(aa.getBild());
		  return aar;
	  }
  	
  	public MietenResponse makeDTO(Mieten m) {
  		MietenResponse mr = new MietenResponse();
  		mr.setMid(m.getMid());
		mr.setAnfangskm(m.getAnfangskm());
		mr.setDiff(m.getDiff());
		mr.setAutoId(m.getAuto().getAid());
		mr.setKundeEmail(m.getKunde().getEmail());
		mr.setEndkm(m.getEndkm());
		return mr;
  	}
	  
  	/**
  	 * Make dto.
  	 *
  	 * @param auto the auto
  	 * @return the list
  	 */
  	public List<AutoResponse> makeDTO(List<Auto> auto) {
		  ArrayList<AutoResponse> dtoList = new ArrayList<>();
		  for (Auto a : auto) {
			  dtoList.add(this.makeDTO(a));
		  }
		  return dtoList;
	}
  	
  	public List<MietenResponse> makeDto(List<Mieten> mieten) {
  		ArrayList<MietenResponse> dtoList = new ArrayList<>();
  		for(Mieten m : mieten) {
  			dtoList.add(this.makeDTO(m));
  		}
  		return dtoList;
  	}
}
