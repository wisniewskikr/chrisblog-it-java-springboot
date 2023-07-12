package com.example.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@Value(value = "${message_hello}")
	private String messageHello;
	
	@Value(value = "${message_world}")
	private String messageWorld;
	
	@Value(value = "${message_exclamation}")
	private String messageExclamation;

	@RequestMapping(value="/")
	public String greeting() {		
		return messageHello + " " + messageWorld + messageExclamation;
	}
	
}