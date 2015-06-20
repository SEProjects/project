package de.autovermietung.dto;



// TODO: Auto-generated Javadoc
/**
 * The Class AutoResponse.
 */
public class AutoResponse extends ReturncodeResponse {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The aid. */
	private int aid;
	
	/** The position. */
	private String position;
	
	/** The bez. */
	private String bez;
	
	/** The aa. */
	private int aa;

	/**
	 * Instantiates a new auto response.
	 */
	public AutoResponse(){
		
	}
	
	/**
	 * Gets the aid.
	 *
	 * @return the aid
	 */
	public int getAid() {
		return aid;
	}
	
	/**
	 * Sets the aid.
	 *
	 * @param aid the new aid
	 */
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	/**
	 * Gets the position.
	 *
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}
	
	/**
	 * Sets the position.
	 *
	 * @param position the new position
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	
	/**
	 * Gets the bez.
	 *
	 * @return the bez
	 */
	public String getBez() {
		return bez;
	}
	
	/**
	 * Sets the bez.
	 *
	 * @param bez the new bez
	 */
	public void setBez(String bez) {
		this.bez = bez;
	}
	
	/**
	 * Gets the aa.
	 *
	 * @return the aa
	 */
	public int getAa() {
		return aa;
	}
	
	/**
	 * Sets the aa.
	 *
	 * @param aa the new aa
	 */
	public void setAa(int aa) {
		this.aa = aa;
	}
	
}
