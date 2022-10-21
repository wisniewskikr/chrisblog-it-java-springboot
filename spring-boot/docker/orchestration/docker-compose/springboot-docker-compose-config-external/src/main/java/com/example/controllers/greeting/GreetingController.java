package com.example.controllers.greeting;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@Value(value = "${message:}")
	private String message;

	@RequestMapping(value="/")
	public String greeting() {		
		return !"".equals(message) ? message : "Can not read message from configuration!";
	}
	
}