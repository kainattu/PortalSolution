package com.kainattu.portal.service.repo.whatsapp;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kainattu.portal.service.model.whatsapp.WhatsappMessage;

public interface MessageRepo extends JpaRepository<WhatsappMessage, Long>{

}
