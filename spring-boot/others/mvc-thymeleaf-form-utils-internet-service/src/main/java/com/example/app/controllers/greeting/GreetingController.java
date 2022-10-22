package com.example.app.controllers.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.app.commands.greeting.GreetingCommand;
import com.example.app.services.internet.InternetService;


@Controller
public class GreetingController {
	
	private InternetService internetService;

	@Autowired
	public GreetingController(InternetService pageReaderService) {
		this.internetService = pageReaderService;
	}

	@RequestMapping(value="/greeting", method = RequestMethod.GET)
	public String display(@ModelAttribute("command") GreetingCommand command) {
		return "greeting/greeting";		
	}
	
	@RequestMapping(value="/greeting", method = RequestMethod.POST)
	public String handleSubmit(@ModelAttribute("command") GreetingCommand command) {
		
		String page = internetService.providePageAsString(command.getUrl());
		int count = StringUtils.countOccurrencesOf(page, "Hello World");
						
		command.setMessage(String.format("Text 'Hello World' count: %d", count));
		command.setUrl(null);
		return "greeting/greeting";
		
	}
	
}