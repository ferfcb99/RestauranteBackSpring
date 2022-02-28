package com.restauranteScrum.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends RestauranteException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NotFoundException(String code, String message) {
		super(code, HttpStatus.NOT_FOUND.value(), message);
	}

}
