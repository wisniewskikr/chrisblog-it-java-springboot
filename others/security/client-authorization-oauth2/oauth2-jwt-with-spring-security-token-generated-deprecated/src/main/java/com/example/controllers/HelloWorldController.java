package com.example.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping(value="/")
	public String helloWorld(HttpServletRequest request) {		
		return "Hello World!";		
	}
	
}