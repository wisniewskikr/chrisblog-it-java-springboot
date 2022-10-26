package com.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/")
	public String helloWorld() {		
		return "Hello World!";		
	}
	
	@GetMapping("/user")
	public String helloWorldUser() {		
		return "Hello World User!";		
	}
	
	@GetMapping("/admin")
	public String helloWorldAdmin() {		
		return "Hello World Admin!";		
	}
	
}