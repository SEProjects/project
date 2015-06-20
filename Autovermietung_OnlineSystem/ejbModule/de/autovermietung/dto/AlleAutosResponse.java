package de.autovermietung.dto;

import java.util.List;


// TODO: Auto-generated Javadoc
/**
 * The Class AlleAutosResponse.
 */
public class AlleAutosResponse extends ReturncodeResponse {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3173158310918408228L;
	
	/** The autos. */
	private List<Object[]> autos;
	
	
	/**
	 * Instantiates a new alle autos response.
	 */
	public AlleAutosResponse(){

	}


	/**
	 * Gets the autos.
	 *
	 * @return the autos
	 */
	public List<Object[]> getAutos() {
		return autos;
	}


	/**
	 * Sets the autos.
	 *
	 * @param autos the new autos
	 */
	public void setAutos(List<Object[]> autos) {
		this.autos = autos;
	}



}
