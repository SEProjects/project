package de.autovermietung.dto;




public class MarkeResponse extends ReturncodeResponse {

	private static final long serialVersionUID = -3173158310918408228L;
	private int markeid;
	private String markenname;
	public MarkeResponse(){
		
	}
	public int getMarkeid() {
		return markeid;
	}
	public void setMarkeid(int markeid) {
		this.markeid = markeid;
	}
	public String getMarkenname() {
		return markenname;
	}
	public void setMarkenname(String markenname) {
		this.markenname = markenname;
	}
	
	
	




	
}
