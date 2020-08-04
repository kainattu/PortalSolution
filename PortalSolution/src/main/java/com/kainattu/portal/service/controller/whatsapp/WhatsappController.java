package com.kainattu.portal.service.controller.whatsapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kainattu.portal.service.dto.whatsapp.WhatsappRequest;
import com.kainattu.portal.service.service.whatsapp.WhatsappService;

@RestController
@RequestMapping("whatsapp")
public class WhatsappController {

	@Autowired
	private WhatsappService whatsappService;
	
	@PostMapping("/send")
	public void sendMessage(@RequestBody WhatsappRequest request) {
		whatsappService.sendMessage(request);
	}
}
