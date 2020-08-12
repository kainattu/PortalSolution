package com.kainattu.portal.service.dto.whatsapp;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class WhatsappRequest {


	private final String phoneNumber;//destination number
	private final String message;

	public WhatsappRequest(@JsonProperty("phoneNumber") String phoneNumber,
			@JsonProperty("message") String message) {
		this.phoneNumber = phoneNumber;
		this.message = message;
	}

}
