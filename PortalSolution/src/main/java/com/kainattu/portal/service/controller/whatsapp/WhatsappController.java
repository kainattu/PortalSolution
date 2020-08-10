package com.kainattu.portal.service.controller.whatsapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kainattu.portal.service.dto.whatsapp.WhatsappRequest;
import com.kainattu.portal.service.model.whatsapp.WhatsappMessage;
import com.kainattu.portal.service.repo.whatsapp.MessageRepo;
import com.kainattu.portal.service.service.whatsapp.WhatsappService;
import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Media;
import com.twilio.twiml.messaging.Message;

@RestController
//@RequestMapping("whatsapp")
@CrossOrigin
public class WhatsappController {

	@Autowired
	private WhatsappService whatsappService;
	
	@PostMapping("/whatsapp/send")
	public void sendMessage(@RequestBody WhatsappRequest request) {
		whatsappService.sendMessage(request);
	}
	
    
	@PostMapping("/sms")
	 public void recive(HttpServletRequest request, HttpServletResponse response)
			 throws IOException {
		
		String from = request.getParameter("From");
		String to = request.getParameter("To");
		String body1 = request.getParameter("Body");
		int numMedia = Integer.parseInt(request.getParameter("NumMedia"));
		
		String result = whatsappService.recieveMessage(from, to, body1, numMedia);
		
		response.setContentType("text/xml");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.write(result);
		
		out.flush();
		out.close();
	}
	
	@GetMapping("/fetchMessage")
	public List<WhatsappMessage> fetchMessage() {
		return whatsappService.fetchMessage();
	}
}
