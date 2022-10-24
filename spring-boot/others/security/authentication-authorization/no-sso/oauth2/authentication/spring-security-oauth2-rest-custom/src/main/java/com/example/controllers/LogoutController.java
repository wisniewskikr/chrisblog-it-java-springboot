package com.example.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogoutController {

	@GetMapping("/auth/logout")
    public String logout() {
		
		SecurityContextHolder.getContext().setAuthentication(null);		
		return "You are successfully logged out!";
		
	}

}
