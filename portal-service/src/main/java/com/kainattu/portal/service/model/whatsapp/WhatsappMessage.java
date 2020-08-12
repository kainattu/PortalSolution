package com.kainattu.portal.service.model.whatsapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WhatsappMessage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String fromContact;
	private String toContact;
	private String message;
}
