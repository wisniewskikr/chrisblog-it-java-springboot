package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.services.UserService;

public class DeleteController {
	
	private UserService userService;
	
	@Autowired
	public DeleteController(UserService userService) {
		this.userService = userService;
	}
	
	public String delete(Long id) {
		
		userService.deleteById(id);
		return "Deleted";
		
	}

}