package com.example.controllers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entities.UserEntity;
import com.example.repositories.UserRepository;

@Controller
public class RegisterController {
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private UserRepository userRepository;	

	public RegisterController(BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.userRepository = userRepository;
	}

	@RequestMapping(value="/register")
	public String displayPage() {
		return "register";		
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String handleAction(@RequestParam("username") String userName, @RequestParam("password") String password) {		
		
		userRepository.save(new UserEntity(userName, bCryptPasswordEncoder.encode(password), "USER"));
		return "redirect:/login?register";		
		
	}
	
}
