package de.autovermietung.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Marke implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int markeid;
	
	private String markenname;
	
	private List<Autoart> autoart;
	public Marke(){
		
	}
	public Marke(String markenname) {
		super();
		this.markenname = markenname;
		this.autoart = new ArrayList<>();
	}
	public String getMarkenname() {
		return markenname;
	}
	public void setMarkenname(String markenname) {
		this.markenname = markenname;
	}
	public List<Autoart> getAutoart() {
		return autoart;
	}
	public void setAutoart(List<Autoart> autoart) {
		this.autoart = autoart;
	}
	public int getMarkeid() {
		return markeid;
	}
	public void addAutoart(Autoart aa){
		autoart.add(aa);
	}


}
