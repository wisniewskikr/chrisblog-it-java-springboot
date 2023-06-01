package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/access-denied")
public class AccessDeniedController {

	@RequestMapping(method = RequestMethod.GET)
	public String display() {
		return "access-denied";		
	}
	
}