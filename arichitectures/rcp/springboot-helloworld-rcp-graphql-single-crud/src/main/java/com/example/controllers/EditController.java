package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import com.example.commands.EditCommand;
import com.example.dtos.UserDto;
import com.example.services.UserService;

@Controller
public class EditController {
	
	private UserService userService;

	@Autowired
	public EditController(UserService userService) {
		this.userService = userService;
	}
	
	@MutationMapping
	public UserDto edit(@Argument Long id, @Argument EditCommand command) {		
		return userService.save(new UserDto(id, command.getName()));		
	}

}