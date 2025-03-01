package com.example.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@RequestMapping(value="/admin")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public String display() {
		return "admin";		
	}
	
}