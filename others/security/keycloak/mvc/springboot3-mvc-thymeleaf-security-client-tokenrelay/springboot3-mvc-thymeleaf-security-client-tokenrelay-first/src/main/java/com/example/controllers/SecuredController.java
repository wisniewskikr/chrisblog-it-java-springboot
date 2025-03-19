package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecuredController {

	@RequestMapping(value="/secured")
	public String display() {
		return "secured";		
	}
	
}