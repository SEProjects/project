package de.autovermietung.dto;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class GetAllResponse.
 */
public class GetAllResponse extends ReturncodeResponse {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3173158310918408228L;
	
	/** The Datensaetze. */
	private List<Object[]> Datensaetze;
	
	/**
	 * Instantiates a new gets the all response.
	 */
	public GetAllResponse(){
		
	}

	/**
	 * Gets the datensaetze.
	 *
	 * @return the datensaetze
	 */
	public List<Object[]> getDatensaetze() {
		return Datensaetze;
	}

	/**
	 * Sets the datensaetze.
	 *
	 * @param datensaetze the new datensaetze
	 */
	public void setDatensaetze(List<Object[]> datensaetze) {
		Datensaetze = datensaetze;
	};
	




}
