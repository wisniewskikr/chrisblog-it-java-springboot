package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.services.UserService;

@Controller
public class RegisterController {
	
	private UserService userService;	

	@Autowired
	public RegisterController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value="/register")
	public String displayPage() {
		return "register";		
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String handleRegistration(@RequestParam("email") String email, @RequestParam("password") String password) {		
		
		userService.registrationBeforeConfirmation(email, password);
		return "redirect:/login?register";		
		
	}
	
	@RequestMapping(value="/confirm")
	public String handleConfirmation(@RequestParam("token") String token) {		
		
		userService.registrationAfterConfirmation(token);
		return "redirect:/login?confirm";		
		
	}
	
}
