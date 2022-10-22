package com.example.app.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.commands.ViewCommand;
import com.example.app.repositories.UserRepository;

@Controller
public class ViewController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="/view")
	public String displayPage(@ModelAttribute("command")ViewCommand command,
			HttpSession session) {
		
		Long id = (Long)session.getAttribute("selectedUserId");
		command.setName(userRepository.findById(id).get().getName());
		return "view";
		
	}

}