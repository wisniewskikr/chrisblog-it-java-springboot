package com.example.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.commands.DeleteCommand;
import com.example.services.UserService;

@Controller
public class DeleteController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/delete")
	public String displayPage(@ModelAttribute("command")DeleteCommand command,
			HttpSession session) {
		
		Long id = (Long)session.getAttribute("selectedUserId");	
		command.setName(userService.findById(id).get().getName());
		return "delete";
		
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String handleButtonEdit(@ModelAttribute("command")DeleteCommand command,
			HttpSession session) {
		
		Long id = (Long)session.getAttribute("selectedUserId");	
		userService.deleteById(id);
		return "redirect:/list";
		
	}

}