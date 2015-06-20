package de.autovermietung.dto;

import java.util.List;


// TODO: Auto-generated Javadoc
/**
 * The Class AutoListResponse.
 */
public class AutoListResponse extends ReturncodeResponse {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3173158310918408228L;
	
	/** The auto list. */
	private List<AutoResponse> autoList;
	
	/**
	 * Instantiates a new auto list response.
	 */
	public AutoListResponse() { }
	
	/**
	 * Gets the auto list.
	 *
	 * @return the auto list
	 */
	public List<AutoResponse> getAutoList() {
		return autoList;
	}
	
	/**
	 * Sets the auto list.
	 *
	 * @param autoList the new auto list
	 */
	public void setAutoList(List<AutoResponse> autoList) {
		this.autoList = autoList;
	}
	
	

}
