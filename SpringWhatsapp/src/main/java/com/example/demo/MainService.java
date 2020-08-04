package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MainService {

	private final WhatsappSender whatsappSender;

	@Autowired
	public MainService(@Qualifier("twilio") WhatsappSender whatsappSender) {
		this.whatsappSender = whatsappSender;
	}
	
	public void sendMessage(WhatsappRequest request) {
		whatsappSender.sendMessgae(request);
	}
}
