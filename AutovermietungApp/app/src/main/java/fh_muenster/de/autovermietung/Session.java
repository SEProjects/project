package fh_muenster.de.autovermietung;

import java.util.Date;


public class Session {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Kunde kunde;

	private int sid;

	private Date timestamp;
	public Session(){
		
	}
	public Session(Kunde kunde) {
		super();
		this.kunde = kunde;
				
	}
	public Kunde getKunde() {
		return kunde;
	}
	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void updateTimestamp(){
		
		Date jetzt = new Date();
		timestamp = jetzt;
	}
	
	
	
	
}
