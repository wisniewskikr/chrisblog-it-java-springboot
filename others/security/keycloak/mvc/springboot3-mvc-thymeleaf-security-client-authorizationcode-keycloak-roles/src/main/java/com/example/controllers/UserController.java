package com.example.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping(value="/user")
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	public String display() {
		return "user";		
	}
	
}