package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.commands.CreateCommand;
import com.example.dtos.UserDto;
import com.example.services.UserService;

@Controller
public class CreaterController {
	
	private UserService userService;
	
	@Autowired
	public CreaterController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String displayPage(@ModelAttribute("command")CreateCommand command) {
		return "create";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String handleCreate(@ModelAttribute("command")CreateCommand command) {
		
		userService.save(new UserDto(command.getName()));
		return "redirect:/list";
		
	}

}