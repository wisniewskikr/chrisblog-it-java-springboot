package com.example.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping(value="/")
	public String helloWorld() {		
		return "Hello World!";		
	}
	
	@RequestMapping(value="/user")
	public String helloWorldUser() {		
		return "Hello World User!";		
	}
	
	@RequestMapping(value="/admin")
	public String helloWorldAdmin() {		
		return "Hello World Admin!";		
	}
	
}