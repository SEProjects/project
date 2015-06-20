package de.autovermietung.dto;



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
	
}
