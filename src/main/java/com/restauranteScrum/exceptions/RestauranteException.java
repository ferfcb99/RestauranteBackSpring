package com.restauranteScrum.exceptions;

public class RestauranteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String code; /* 401 ERROR  */
	
	private final int responseCode; /* 401 */

	
	public RestauranteException(String code, int responseCode, String message) {
		super(message);
		this.code = code;
		this.responseCode = responseCode;
	}


	public String getCode() {
		return code;
	}


	public int getResponseCode() {
		return responseCode;
	}
	
	
	
	
}
