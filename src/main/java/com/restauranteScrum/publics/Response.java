package com.restauranteScrum.publics;

public class Response<T> {
	
	private String code; //* 200 OK */
	
	private T body;
	
	private String message;
	

	public Response() {
		super();
	}

	public Response(String code, T body, String message) {
		super();
		this.code = code;
		this.body = body;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
