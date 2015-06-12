package de.autovermietung.dto;

import java.util.List;

public class GetAllResponse extends ReturncodeResponse {
	private static final long serialVersionUID = -3173158310918408228L;
	private List<Object[]> Datensaetze;
	
	public GetAllResponse(){
		
	}

	public List<Object[]> getDatensaetze() {
		return Datensaetze;
	}

	public void setDatensaetze(List<Object[]> datensaetze) {
		Datensaetze = datensaetze;
	};
	




}
