package fh_muenster.de.autovermietung;

import java.util.Date;


public class Schaden {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int sid;

	private Kunde kunde;

	private Auto auto;
	private String beschreibung;

	private Date timestamp;
	public Schaden(){
		
	}
	public Schaden(Kunde kunde, Auto auto, String beschreibung) {
		super();
		this.kunde = kunde;
		this.auto = auto;
		this.beschreibung = beschreibung;
		
	
	}
	public Kunde getKunde() {
		return kunde;
	}
	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}
	public Auto getAuto() {
		return auto;
	}
	public void setAuto(Auto auto) {
		this.auto = auto;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	
	public int getSid() {
		return sid;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	
		
}
