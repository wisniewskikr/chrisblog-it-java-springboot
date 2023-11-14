package com.example.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

	@RequestMapping(produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String display() {
		return "Hello World!";		
	}
	
}
