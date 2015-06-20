package de.autovermietung.dto;




// TODO: Auto-generated Javadoc
/**
 * @author Kevin Haase
 *  Responseklasse für den Aufruf  {@link de.autovermietung.onlineSystem.OnlineAdminIntegration#getMarke(int, int) getMarke}
 */
public class MarkeResponse extends ReturncodeResponse {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3173158310918408228L;
	
	/** Markenid. */
	private int markeid;
	
	/** Markenname. */
	private String markenname;
	
	/**
	 * Instantiates a new marke response.
	 */
	public MarkeResponse(){
		
	}
	
	/**
	 * Gets the markeid.
	 *
	 * @return the markeid
	 */
	public int getMarkeid() {
		return markeid;
	}
	
	/**
	 * Sets the markeid.
	 *
	 * @param markeid the new markeid
	 */
	public void setMarkeid(int markeid) {
		this.markeid = markeid;
	}
	
	/**
	 * Gets Markenname.
	 *
	 * @return markenname
	 */
	public String getMarkenname() {
		return markenname;
	}
	
	/**
	 * Sets Markenname in der Response.
	 *
	 * @param markenname the new markenname
	 */
	public void setMarkenname(String markenname) {
		this.markenname = markenname;
	}
	
	
	




	
}
