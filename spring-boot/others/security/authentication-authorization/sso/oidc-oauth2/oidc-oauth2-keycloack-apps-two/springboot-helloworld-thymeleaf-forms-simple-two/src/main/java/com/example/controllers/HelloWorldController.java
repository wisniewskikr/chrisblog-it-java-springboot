package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.commands.HelloWorldCommand;


@Controller
@RequestMapping(value="/")
public class HelloWorldController {

	@RequestMapping(method = RequestMethod.GET)
	public String display(@ModelAttribute("command") HelloWorldCommand command) {
		return "helloworld/helloworld";		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String handleSubmit(
			@ModelAttribute("command") HelloWorldCommand command) {
				
		command.setMessage(String.format("Hello World %s!", command.getName()));
		command.setName(null);
		return "helloworld/helloworld";
		
	}
	
}