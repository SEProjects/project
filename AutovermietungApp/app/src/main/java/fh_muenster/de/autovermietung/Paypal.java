package fh_muenster.de.autovermietung;

public class Paypal extends Bezahlmethode {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String email;
	
	public Paypal(){
		
	}
	
	public Paypal(String email,Kunde kunde) {
		super(kunde);
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



}
