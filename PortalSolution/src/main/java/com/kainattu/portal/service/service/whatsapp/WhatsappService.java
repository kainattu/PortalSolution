package com.kainattu.portal.service.service.whatsapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kainattu.portal.service.dto.whatsapp.WhatsappRequest;
import com.kainattu.portal.service.model.whatsapp.WhatsappMessage;
import com.kainattu.portal.service.repo.whatsapp.MessageRepo;
import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Media;
import com.twilio.twiml.messaging.Message;


@Service
public class WhatsappService {
	private final WhatsappSender whatsappSender;
	
	@Autowired
	MessageRepo messageRepo;

	@Autowired
	public WhatsappService(@Qualifier("twilio") WhatsappSender whatsappSender) {
		this.whatsappSender = whatsappSender;
	}
	
	public void sendMessage(WhatsappRequest request) {
		whatsappSender.sendMessgae(request);
	}
	
    private static final String GOOD_BOY_URL = "https://images.unsplash.com/photo-1518717758536-85ae29035b6d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80";

	public String recieveMessage(String from, String to, String body1, int numMedia) {
		
		WhatsappMessage mess = new WhatsappMessage();
		mess.setFromContact(from);
		mess.setToContact(to);
		mess.setMessage(body1);
		messageRepo.save(mess);
		
		String message = "The Robots are coming! Head for the hills!";
		if (body1.equals("hello")) {
			message = "Hi there!";
		} else if (body1.equals("bye")) {
			message = "Goodbye!";
		}
		
		com.twilio.twiml.MessagingResponse.Builder twimlResponse = new MessagingResponse.Builder();
		if (numMedia > 0) {
			twimlResponse.message(
					new Message.Builder().body(new Body.Builder("Thanks for the image! Here's one for you!").build())
					.media(new Media.Builder(GOOD_BOY_URL).build()).build());
		} else {
			twimlResponse.message(new Message.Builder().body(new Body.Builder(message).build()).build());
		}

		return twimlResponse.build().toXml();
	}

	public List<WhatsappMessage> fetchMessage() {
		return messageRepo.findAll();
	}
}
