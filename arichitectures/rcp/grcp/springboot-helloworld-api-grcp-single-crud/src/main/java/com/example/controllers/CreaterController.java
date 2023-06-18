package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.commands.CreateCommand;
import com.example.dtos.UserDto;
import com.example.services.UserService;

public class CreaterController {
	
	private UserService userService;
	
	@Autowired
	public CreaterController(UserService userService) {
		this.userService = userService;
	}
	
	public UserDto create(CreateCommand command) {		
		return userService.save(new UserDto(command.getName()));		
	}

}