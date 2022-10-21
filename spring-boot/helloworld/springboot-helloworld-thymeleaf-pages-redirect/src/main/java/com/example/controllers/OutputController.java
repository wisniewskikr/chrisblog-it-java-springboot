package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.commands.OutputCommand;


@Controller
public class OutputController {

	@RequestMapping(value="/output")
	public String greeting(@ModelAttribute("command") OutputCommand command) {
		
		command.setText("Hello World! To go back please click this");
		return "output/output";
		
	}
	
}