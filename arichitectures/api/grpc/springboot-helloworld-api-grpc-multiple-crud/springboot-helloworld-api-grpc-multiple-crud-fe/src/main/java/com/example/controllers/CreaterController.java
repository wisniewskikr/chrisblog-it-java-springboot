package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.commands.CreateCommand;
import com.example.dtos.UserDto;
import com.example.services.UserService;

@RestController
public class CreaterController {
	
	private UserService userService;
	
	@Autowired
	public CreaterController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/create")
	public UserDto create(@RequestBody CreateCommand command) {			
		return userService.save(new UserDto(command.getName()));		
	}

}