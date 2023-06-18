package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.commands.EditCommand;
import com.example.dtos.UserDto;
import com.example.services.UserService;

public class EditController {
	
	private UserService userService;

	@Autowired
	public EditController(UserService userService) {
		this.userService = userService;
	}
	
	public UserDto edit(Long id, EditCommand command) {		
		return userService.save(new UserDto(id, command.getName()));		
	}

}