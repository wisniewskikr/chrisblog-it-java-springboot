package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.services.UserService;

@RestController
public class DeleteController {
	
	private UserService userService;
	
	@Autowired
	public DeleteController(UserService userService) {
		this.userService = userService;
	}
	
	@DeleteMapping("/delete/{id}")
	public String handleButtonEdit(@PathVariable Long id) {
		
		userService.deleteById(id);
		return "Deleted";
		
	}

}