package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.commands.EditCommand;
import com.example.dtos.UserDto;
import com.example.services.UserService;

@RestController
public class EditController {
	
	private UserService userService;

	@Autowired
	public EditController(UserService userService) {
		this.userService = userService;
	}
	
	@PutMapping("/edit/{id}")
	public UserDto edit(@PathVariable Long id, @RequestBody EditCommand command) {		
		return userService.save(new UserDto(id, command.getName()));		
	}

}