package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {

	@GetMapping("/")
	public String helloWorld() {		
		return "helloworld";		
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