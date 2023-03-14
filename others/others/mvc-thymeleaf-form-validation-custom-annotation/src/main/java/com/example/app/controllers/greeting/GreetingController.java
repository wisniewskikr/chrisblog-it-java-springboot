package com.example.app.controllers.greeting;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.app.commands.greeting.GreetingCommand;


@Controller
public class GreetingController {

	@RequestMapping(value="/greeting", method = RequestMethod.GET)
	public String display(@ModelAttribute("command") GreetingCommand command) {
		return "greeting/greeting";		
	}
	
	@RequestMapping(value="/greeting", method = RequestMethod.POST)
	public String handleSubmit(@Valid @ModelAttribute("command") GreetingCommand command,
			BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "greeting/greeting";
		}
				
		command.setMessage(String.format("Hello World %s!", command.getName()));
		command.setName(null);
		return "greeting/greeting";
		
	}
	
}