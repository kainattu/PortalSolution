package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WhatsappRequest {

	private final String phoneNumber;//destination number
	private final String message;
	
	public WhatsappRequest(@JsonProperty("phoneNumber") String phoneNumber,
			@JsonProperty("message") String message) {
		this.phoneNumber = phoneNumber;
		this.message = message;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getMessage() {
		return message;
	}
	
	
}
