package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.commands.HelloWorldCommand;


@Controller
public class HelloWorldController {

	@RequestMapping(value="/")
	public String greeting(@ModelAttribute("command") HelloWorldCommand command) {
		
		command.setText("Hello World!");
		return "helloworld/helloworld";
		
	}
	
}