package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.HelloWorldService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class SecuredController {

	private final HelloWorldService helloWorldService;

	@RequestMapping(value="/secured")
	public String display(Model model) {
		model.addAttribute("message", helloWorldService.getMessage());
		return "secured";		
	}
	
}