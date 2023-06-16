package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
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
	
	@MutationMapping
	public UserDto create(@Argument CreateCommand command) {		
		return userService.save(new UserDto(command.getName()));		
	}

}