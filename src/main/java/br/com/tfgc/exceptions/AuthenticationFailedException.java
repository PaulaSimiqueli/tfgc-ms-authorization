package br.com.tfgc.exceptions;

public class AuthenticationFailedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8275219862679327874L;
	public AuthenticationFailedException(String msg) {
		
		super(msg);
	}
}
