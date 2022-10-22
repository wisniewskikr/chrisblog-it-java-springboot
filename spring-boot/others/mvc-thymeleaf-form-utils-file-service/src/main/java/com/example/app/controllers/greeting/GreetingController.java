package com.example.app.controllers.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.app.commands.greeting.GreetingCommand;
import com.example.app.services.file.FileService;


@Controller
public class GreetingController {
	
	private static final String FILE_PATH = "tmp.txt";
	
	private FileService fileService;
	
	@Autowired
	public GreetingController(FileService fileService) {
		this.fileService = fileService;
	}

	@RequestMapping(value="/greeting", method = RequestMethod.GET)
	public String display(@ModelAttribute("command") GreetingCommand command) {
		return "greeting/greeting";		
	}
	
	@RequestMapping(value="/greeting", method = RequestMethod.POST)
	public String handleSubmit(@ModelAttribute("command") GreetingCommand command) {
				
		fileService.writeToFile(FILE_PATH, command.getName());
		String name = fileService.readFromFile(FILE_PATH);
		
		command.setMessage(String.format("Hello World %s!", name));
		command.setName(null);
		return "greeting/greeting";
		
	}
	
}