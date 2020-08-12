package com.kainattu.portal.service.exception;
public class ExceptionMessage {

	private final String code;

	private final String message;

	public ExceptionMessage(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	// ...
	
	


}