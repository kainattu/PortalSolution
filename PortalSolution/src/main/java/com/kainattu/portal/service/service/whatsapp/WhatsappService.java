package com.kainattu.portal.service.service.whatsapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kainattu.portal.service.dto.whatsapp.WhatsappRequest;


@Service
public class WhatsappService {
	private final WhatsappSender whatsappSender;

	@Autowired
	public WhatsappService(@Qualifier("twilio") WhatsappSender whatsappSender) {
		this.whatsappSender = whatsappSender;
	}
	
	public void sendMessage(WhatsappRequest request) {
		whatsappSender.sendMessgae(request);
	}
}
