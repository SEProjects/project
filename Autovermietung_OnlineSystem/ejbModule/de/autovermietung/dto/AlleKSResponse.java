package de.autovermietung.dto;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class AlleKSResponse.
 */
public class AlleKSResponse extends ReturncodeResponse {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3173158310918408228L;
	
	/** The ks. */
	private List<Object[]> ks;
	
	/**
	 * Instantiates a new alle ks response.
	 */
	public AlleKSResponse(){
		
	}

	/**
	 * Gets the ks.
	 *
	 * @return the ks
	 */
	public List<Object[]> getKs() {
		return ks;
	}

	/**
	 * Sets the ks.
	 *
	 * @param ks the new ks
	 */
	public void setKs(List<Object[]> ks) {
		this.ks = ks;
	}




	
}
