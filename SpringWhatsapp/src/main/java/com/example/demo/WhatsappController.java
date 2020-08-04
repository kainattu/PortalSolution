package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/whatsapp")
public class WhatsappController {

	@Autowired
	private MainService mainService;
	
	@PostMapping
	public void sendMessage(@RequestBody WhatsappRequest request) {
		mainService.sendMessage(request);
	}
}
