package de.autovermietung.dto;

import java.util.List;


public class AutoListResponse extends ReturncodeResponse {

	private static final long serialVersionUID = -3173158310918408228L;
	private List<AutoResponse> autoList;
	
	public AutoListResponse() { }
	
	public List<AutoResponse> getAutoList() {
		return autoList;
	}
	public void setAutoList(List<AutoResponse> autoList) {
		this.autoList = autoList;
	}
	
	

}
