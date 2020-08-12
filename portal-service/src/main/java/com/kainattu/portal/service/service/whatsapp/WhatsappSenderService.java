package com.kainattu.portal.service.service.whatsapp;

import java.net.URI;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kainattu.portal.service.config.whatsapp.TwilioConfiguration;
import com.kainattu.portal.service.dto.whatsapp.WhatsappRequest;
import com.twilio.rest.api.v2010.account.Message;


@Service("twilio")
public class WhatsappSenderService implements WhatsappSender{

	private final TwilioConfiguration twilioConfiguration;

	@Autowired
	public WhatsappSenderService(TwilioConfiguration twilioConfiguration) {
		this.twilioConfiguration = twilioConfiguration;
	}
	
	@Override
	public void sendMessgae(WhatsappRequest request) {
//		Message message = Message.creator(
//	               new com.twilio.type.PhoneNumber("whatsapp:+919730190468"),
//	               new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
//	               "Hello from your friendly neighborhood Java application!")
//	           .create();
		
		Message message = Message.creator(
	               new com.twilio.type.PhoneNumber("whatsapp:"+request.getPhoneNumber()),
	               new com.twilio.type.PhoneNumber("whatsapp:"+twilioConfiguration.getTrial_number()),
	               request.getMessage())
				.setMediaUrl(
		                Arrays.asList(URI.create("https://i.pinimg.com/474x/4c/dc/7e/4cdc7e170575a5d53286e9175664cbc8.jpg")))
	           .create();
		
	}

}
