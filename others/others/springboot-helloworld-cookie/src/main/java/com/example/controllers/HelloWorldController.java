package com.example.controllers;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	private static final String COOKIE_NAME = "message";

	@RequestMapping(value="/")
	public void helloWorld(HttpServletResponse response) throws IOException {
		
		response.addCookie(new Cookie(COOKIE_NAME, "Hello_World_Cookie!"));
		response.sendRedirect("/cookie");	
		
	}
	
	@RequestMapping(value="/cookie")
	public String helloWorldCookie(HttpServletRequest request) {
		
		Map<String, String> cookieMap = 
                Arrays.stream(request.getCookies())
                      .collect(Collectors.toMap(Cookie::getName, Cookie::getValue));
		
		return cookieMap.get(COOKIE_NAME);	
		
	}
	
}