package de.autovermietung.dto;

import java.util.List;


// TODO: Auto-generated Javadoc
/**
 * The Class AlleMarkenResponse.
 */
public class AlleMarkenResponse extends ReturncodeResponse {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3173158310918408228L;
	
	/** The marken. */
	private List<Object[]> marken;
	

	/**
	 * Instantiates a new alle marken response.
	 */
	public AlleMarkenResponse(){

	}
	
	/**
	 * Gets the marken.
	 *
	 * @return the marken
	 */
	public List<Object[]> getMarken() {
		return marken;
	}


	/**
	 * Sets the marken.
	 *
	 * @param marken the new marken
	 */
	public void setMarken(List<Object[]> marken) {
		this.marken = marken;
	}






}
