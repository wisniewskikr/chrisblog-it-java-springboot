package com.example.controllers;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.services.EmailSenderService;

@RestController
public class EmailSenderController {
	
	private static final String EMAIL_TEMPLATE = "helloworld-email";
	@Value("${email.from}")
	private String from;
	@Value("${email.to}")
	private String to;
	@Value("${email.subject}")
	private String subject;
	@Value("${email.text}")
	private String text;
	
	private EmailSenderService emailSenderService;

	@Autowired
	public EmailSenderController(EmailSenderService emailSenderService) {
		this.emailSenderService = emailSenderService;
	}

	@RequestMapping(value="/")
	public String sendEmail() {
		
		Map<String, Object> thymeleafProperties = Stream.of(new Object[][] { 
		     { "header", subject }, 
		     { "text", text }		     
		 }).collect(Collectors.toMap(data -> (String)data[0], data -> data[1]));
		
		emailSenderService.sendEmailText(from, to, subject, text);
		emailSenderService.sendEmailHtml(from, to, subject, EMAIL_TEMPLATE, thymeleafProperties);
		
		return "Emails - text and html - were sent!";
		
	}
	
}