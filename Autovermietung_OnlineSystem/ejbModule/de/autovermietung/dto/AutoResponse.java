package de.autovermietung.dto;



public class AutoResponse extends ReturncodeResponse {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int aid;
	private String position;
	private String bez;
	private int aa;


	public AutoResponse(){
		
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getBez() {
		return bez;
	}
	public void setBez(String bez) {
		this.bez = bez;
	}
	public int getAa() {
		return aa;
	}
	public void setAa(int aa) {
		this.aa = aa;
	}
	
}
