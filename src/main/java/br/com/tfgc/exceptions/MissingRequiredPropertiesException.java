package br.com.tfgc.exceptions;

public class MissingRequiredPropertiesException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MissingRequiredPropertiesException(String msg) {
		super(msg);
	}

}
