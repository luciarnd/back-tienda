package com.tienda.tienda.controller;

import javax.mail.MessagingException;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tienda.tienda.entity.EmailEntity;
import com.tienda.tienda.provider.EmailProvider;

@Component
@RestController
@RequestMapping("/email")
public class EmailController {
	
	private final ObjectMapper objetMapper;
	private final EmailProvider emailProvider;

	public EmailController(ObjectMapper objetMapper, EmailProvider emailProvider) {
		this.objetMapper = objetMapper;
		this.emailProvider=emailProvider;
	}

	@PostMapping("/enviar")
	public void sendEmail(@RequestParam(value = "email") String email,
			@RequestParam(value = "file", required = false) MultipartFile file)
			throws MessagingException, UnsupportedClassVersionError {
		EmailEntity correo = null;
		try {
			correo = objetMapper.readValue(email, EmailEntity.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		emailProvider.SendEmail(correo, file);
		
	}
}
