package fh_muenster.de.autovermietung;

public class Bezahlmethode {
	/**
	 * 
	 */
	private int bmid;
	private static final long serialVersionUID = 1L;

	private Kunde kunde;
	
	public Bezahlmethode(){
		
	}

	public Bezahlmethode( Kunde kunde) {
		super();
		
		this.kunde = kunde;
	}


	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	public int getBmid() {
		return bmid;
	}

	public void setBmid(int bmid) {
		this.bmid = bmid;
	}

	
}
