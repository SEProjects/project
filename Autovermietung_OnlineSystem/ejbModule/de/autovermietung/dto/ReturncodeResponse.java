package de.autovermietung.dto;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class ReturncodeResponse.
 */
public class ReturncodeResponse implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3397348747136795401L;
	
	/** The Constant CODE_OK. */
	private static final int CODE_OK = 0;
	
	/** The return code. */
	private int returnCode;
	
	/** The message. */
	private String message;
	
	/**
	 * Instantiates a new returncode response.
	 */
	public ReturncodeResponse() {
		this.returnCode = CODE_OK;
	}

	/**
	 * Gets the return code.
	 *
	 * @return the return code
	 */
	public int getReturnCode() {
		return returnCode;
	}

	/**
	 * Sets the return code.
	 *
	 * @param returnCode the new return code
	 */
	public void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
