package de.autovermietung.dto;
/*
 * Author: Carlo Eefting
 */


public class Auto {
	public int aID;
	public String bezeichnung;
	public char position;
	public int autoArt;
	public int schaden; 
	/*
	 * Schadensstufen:
	 *  0= Zustand Gut
	 *  1= Zustand Kratzer
	 *  2= Zustand Blechschäden
	 *  3= Zustand total Schaden
	 */

	public Auto(int aID, String bez, char pos, int autoArt){ 
		schaden = 0;
		this.aID = aID;
		this.bezeichnung = bez;
		this.position = pos;
		this.autoArt = autoArt;
	}
	
	public void setPosition(char pos){
		this.position = pos;
	}
	
	public void setSchaden(int zustand){
		if(zustand >3 | zustand <0){
			setSchaden(zustand);
		}
		else{ 
			this.schaden = zustand;
		}
	}
	
	public String getSchaden(){
		if(schaden == 0){return 'Einwandfrei'}
	}
}
