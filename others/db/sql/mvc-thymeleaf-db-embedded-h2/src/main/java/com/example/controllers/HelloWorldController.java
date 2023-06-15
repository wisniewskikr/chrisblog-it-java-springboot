package com.example.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.commands.HelloWorldCommand;
import com.example.entities.HelloWorldEntity;
import com.example.repositories.HelloWorldRepository;


@Controller
public class HelloWorldController {
	
	@Autowired
	private HelloWorldRepository helloWorldRepository;

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String helloWorld(@ModelAttribute("command") HelloWorldCommand command) {
		
		Optional<HelloWorldEntity> helloWorldEntity = helloWorldRepository.findById(1L);		
		command.setText(helloWorldEntity.get().getText());
		return "helloworld";
		
	}
	
}