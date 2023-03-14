package com.example.app.controllers.greeting;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.app.commands.greeting.GreetingCommand;
import com.example.app.services.PropertyService;


@Controller
public class GreetingController {
	
	@Autowired
	private PropertyService propertyService;

	@RequestMapping(value="/greeting", method = RequestMethod.GET)
	public String greeting(@ModelAttribute("command") GreetingCommand command) {
		
		Properties properties = propertyService.getPropertiesFromFile(null);
		command.setText(properties.getProperty("greeting"));
		return "greeting/greeting";
		
	}
	
}