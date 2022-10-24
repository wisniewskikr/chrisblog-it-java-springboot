package com.example.app.controllers.greeting;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.app.commands.greeting.GreetingCommand;
import com.example.app.entities.GreetingEntity;
import com.example.app.repositories.GreetingRepository;


@Controller
public class GreetingController {
	
	@Autowired
	private GreetingRepository greetingRepository;

	@RequestMapping(value="/greeting", method = RequestMethod.GET)
	public String greeting(@ModelAttribute("command") GreetingCommand command) {
		
		Optional<GreetingEntity> greetingEntity = greetingRepository.findById(1L);		
		command.setText(greetingEntity.get().getText());
		return "greeting/greeting";
		
	}
	
}