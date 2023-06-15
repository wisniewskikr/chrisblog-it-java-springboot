package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.commands.HelloWorldCommand;
import com.example.dtos.HelloWorldDto;
import com.example.services.HelloWorldService;


@Controller
public class HelloWorldController {
	
	private HelloWorldService helloWorldService;

	@Autowired
	public HelloWorldController(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String helloWorld(@ModelAttribute("command") HelloWorldCommand command) {
		
		HelloWorldDto helloWorldDto = helloWorldService.findById(1L);		
		command.setText(helloWorldDto.getText());
		return "helloworld";
		
	}
	
}