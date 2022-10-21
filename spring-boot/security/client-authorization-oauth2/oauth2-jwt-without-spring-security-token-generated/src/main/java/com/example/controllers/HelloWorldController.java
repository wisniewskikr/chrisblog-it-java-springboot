package com.example.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Claims;

@RestController
public class HelloWorldController {

	@RequestMapping(value="/")
	public String helloWorld(HttpServletRequest request) {
		
		Claims claims = (Claims) request.getAttribute("claims");		
		return claims.get("message", String.class);
		
	}
	
}