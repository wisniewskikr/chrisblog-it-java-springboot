package com.example.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {

	@GetMapping("/")
	public String helloWorld() {		
		return "helloworld";		
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasAuthority('USER')")
	public String helloWorldUser() {		
		return "helloworld-user";		
	}
	
	@GetMapping("/admin")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String helloWorldAdmin() {		
		return "helloworld-admin";		
	}
	
}