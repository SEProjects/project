package de.autovermietung.dto;

import java.util.List;

import de.autovermietung.entities.Bewertung;
import de.autovermietung.entities.Dreck;
import de.autovermietung.entities.Mieten;
import de.autovermietung.entities.Schaden;



// TODO: Auto-generated Javadoc
/**
 * @author Kevin Haase
 * Responseklasse für den Aufruf getAuto
 * {@link de.autovermietung.onlineSystem.OnlineAdminIntegration#getAuto(int, int) getAuto}
 */
public class AutoResponse extends ReturncodeResponse {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** AutoID. */
	private int aid;
	
	/** Position des Autos. */
	private String position;
	
	/** Bezeichnung des Autos */
	private String bez;
	
	/** Autoartid. */
	private int aa;
	
	private List<Integer> gemietet;
	
	/** Schaden. */
	private List<Schaden> schaden;
	
	/** Bewertungen. */
	private List<Bewertung> bewertungen;
	
	/** Dreck. */
	private List<Dreck> dreck;


	/**
	 * Instantiates a new auto response.
	 */
	public AutoResponse(){
		
	}
	
	/**
	 * Gets AutoID.
	 *
	 * @return  aid
	 */
	public int getAid() {
		return aid;
	}
	
	/**
	 * Sets AutoID in der Response.
	 *
	 * @param aid neue aid
	 */
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	/**
	 * Gets Position des Autos.
	 *
	 * @return position
	 */
	public String getPosition() {
		return position;
	}
	
	/**
	 * Sets position in der Response 
	 *
	 * @param position neue position
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	
	/**
	 * Gets Bezeichnung des Autos.
	 *
	 * @return bez
	 */
	public String getBez() {
		return bez;
	}
	
	/**
	 * Sets Bezeichnung des Autos in der Response.
	 *
	 * @param bez neue bez
	 */
	public void setBez(String bez) {
		this.bez = bez;
	}
	
	/**
	 * Gets AutoartID.
	 *
	 * @return the aa
	 */
	public int getAa() {
		return aa;
	}
	
	/**
	 * Sets AutoartID in der Response.
	 *
	 * @param aa neue aa
	 */
	public void setAa(int aa) {
		this.aa = aa;
	}

	public List<Integer> getGemietet() {
		return gemietet;
	}

	public void setGemietet(List<Integer> gemietet) {
		this.gemietet = gemietet;
	}

	public List<Schaden> getSchaden() {
		return schaden;
	}

	public void setSchaden(List<Schaden> schaden) {
		this.schaden = schaden;
	}

	public List<Bewertung> getBewertungen() {
		return bewertungen;
	}

	public void setBewertungen(List<Bewertung> bewertungen) {
		this.bewertungen = bewertungen;
	}

	public List<Dreck> getDreck() {
		return dreck;
	}

	public void setDreck(List<Dreck> dreck) {
		this.dreck = dreck;
	}
	
}
