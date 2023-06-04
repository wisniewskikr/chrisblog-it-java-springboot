package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccessDeniedController {

	@RequestMapping(value="/access-denied")
	public String display() {
		return "access-denied";		
	}
	
}