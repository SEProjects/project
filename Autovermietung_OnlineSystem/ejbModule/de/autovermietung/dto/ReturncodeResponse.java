package de.autovermietung.dto;

import java.io.Serializable;


/**
* @author Kevin Haase
 *  Responseklasse für alle Aufrufe
 */
public class ReturncodeResponse implements Serializable {

	/**  Constant serialVersionUID. */
	private static final long serialVersionUID = 3397348747136795401L;
	
	/** Constant CODE_OK standard falls erfolgreich */
	private static final int CODE_OK = 0;
	
	/** Fehlercode */
	private int returnCode;
	
	/** Fehlermessage. */
	private String message;
	
	/**
	 * Instantiates a new returncode response.
	 */
	public ReturncodeResponse() {
		this.returnCode = CODE_OK;
	}

	/**
	 * Gets return code.
	 *
	 * @return return code
	 */
	public int getReturnCode() {
		return returnCode;
	}

	/**
	 * Sets return code  in allen Responses.
	 *
	 * @param returnCode neuer return code
	 */
	public void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}

	/**
	 * Gets message.
	 *
	 * @return  message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets message in Allen Responses.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
