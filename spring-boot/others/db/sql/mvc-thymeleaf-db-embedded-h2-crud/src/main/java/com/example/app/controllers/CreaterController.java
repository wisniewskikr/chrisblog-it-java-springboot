package com.example.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.app.commands.CreateCommand;
import com.example.app.entities.UserEntity;
import com.example.app.repositories.UserRepository;

@Controller
public class CreaterController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String displayPage(@ModelAttribute("command")CreateCommand command) {
		return "create";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String handleCreate(@ModelAttribute("command")CreateCommand command) {
		
		userRepository.save(new UserEntity(command.getName()));
		return "redirect:/list";
		
	}

}