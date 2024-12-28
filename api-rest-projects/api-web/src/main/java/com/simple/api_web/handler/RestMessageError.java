package com.simple.api_web.handler;

import org.springframework.http.HttpStatus;

public class RestMessageError {
	
	private HttpStatus httpStatus;
	private String message;

	public RestMessageError(HttpStatus httpStatus, String message) {
		this.httpStatus = httpStatus;
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}