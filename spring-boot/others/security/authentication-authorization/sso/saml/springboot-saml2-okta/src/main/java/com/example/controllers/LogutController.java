package com.example.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LogutController {

	@GetMapping("/tmp")
	public String logout(HttpServletRequest request) throws ServletException {
		
		System.out.println("**** GET");
		request.logout();
		return "logout";	
		
	}
	
}