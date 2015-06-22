package de.autovermietung.dto;

import java.util.List;

public class MietenListResponse extends ReturncodeResponse {

	private static final long serialVersionUID = 1L;
	private List<MietenResponse> mietenList;
	/**
	 * @return the mietenList
	 */
	public List<MietenResponse> getMietenList() {
		return mietenList;
	}
	/**
	 * @param mietenList the mietenList to set
	 */
	public void setMietenList(List<MietenResponse> mietenList) {
		this.mietenList = mietenList;
	}
	
}
