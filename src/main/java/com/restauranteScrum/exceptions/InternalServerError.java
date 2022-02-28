package com.restauranteScrum.exceptions;

import org.springframework.http.HttpStatus;

public class InternalServerError extends RestauranteException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InternalServerError(String code, String message) {
		super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
	}
	
}
