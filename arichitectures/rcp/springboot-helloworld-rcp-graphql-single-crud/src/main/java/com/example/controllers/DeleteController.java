package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import com.example.services.UserService;

@Controller
public class DeleteController {
	
	private UserService userService;
	
	@Autowired
	public DeleteController(UserService userService) {
		this.userService = userService;
	}
	
	@MutationMapping
	public String delete(@Argument Long id) {
		
		userService.deleteById(id);
		return "Deleted";
		
	}

}