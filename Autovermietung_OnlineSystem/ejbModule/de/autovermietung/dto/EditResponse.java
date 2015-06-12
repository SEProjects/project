package de.autovermietung.dto;

public class EditResponse extends ReturncodeResponse {
	private static final long serialVersionUID = -3173158310918408228L;
	private boolean successful; 
	public EditResponse(){
		
	}
	public boolean isSuccessful() {
		return successful;
	}
	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}
	
}
