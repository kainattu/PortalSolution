package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;

@Configuration
public class TwilioInitiazer {

	private final TwilioConfiguration twilioConfiguration;

	private final static Logger LOGGER =  LoggerFactory.getLogger(TwilioInitiazer.class);
	
	@Autowired
	public TwilioInitiazer(TwilioConfiguration twilioConfiguration) {
		this.twilioConfiguration = twilioConfiguration;
		Twilio.init(
				twilioConfiguration.getAccount_sid(),
				twilioConfiguration.getAuth_token()
				);
		LOGGER.info("Twillo intialized...");
	}
	
	
}
