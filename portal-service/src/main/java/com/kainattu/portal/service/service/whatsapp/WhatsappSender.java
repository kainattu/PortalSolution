package com.kainattu.portal.service.service.whatsapp;

import com.kainattu.portal.service.dto.whatsapp.WhatsappRequest;

public interface WhatsappSender {
	void sendMessgae(WhatsappRequest request);
	
}
