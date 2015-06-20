package de.autovermietung.dto;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * @author Kevin Haase
 * Responseklasse für den Aufruf für alle GetALL
 * @see de.autovermietung.onlineSystem.OnlineAdminIntegration#getAllAA(int)
 * @see de.autovermietung.onlineSystem.OnlineAdminIntegration#getAllAutos(int)
 * @see de.autovermietung.onlineSystem.OnlineAdminIntegration#getAllKS(int)
 * @see de.autovermietung.onlineSystem.OnlineAdminIntegration#getAllKunden(int)
 * @see de.autovermietung.onlineSystem.OnlineAdminIntegration#getAllMarken(int)
 * @see de.autovermietung.onlineSystem.OnlineAdminIntegration#getAllRechnungen(int)
 * 
 */
public class GetAllResponse extends ReturncodeResponse {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3173158310918408228L;
	
	/** The Datensaetze. */
	private List<Object[]> Datensaetze;
	
	/**
	 * Instantiates a new gets the all response.
	 */
	public GetAllResponse(){
		
	}

	/**
	 * Gets the datensaetze.
	 *
	 * @return the datensaetze
	 */
	public List<Object[]> getDatensaetze() {
		return Datensaetze;
	}

	/**
	 * Sets the datensaetze.
	 *
	 * @param datensaetze the new datensaetze
	 */
	public void setDatensaetze(List<Object[]> datensaetze) {
		Datensaetze = datensaetze;
	};
	




}
