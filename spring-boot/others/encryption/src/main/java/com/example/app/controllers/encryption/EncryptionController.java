package com.example.app.controllers.encryption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.app.commands.encryption.EncryptionCommand;
import com.example.app.services.EncryptionService;


@Controller
public class EncryptionController {
	
	@Autowired
	private EncryptionService encryptionService;

	@RequestMapping(value="/encryption", method = RequestMethod.GET)
	public String display(@ModelAttribute("command") EncryptionCommand command) {
		return "encryption/encryption";
		
	}
	
	@RequestMapping(value="/encryption", method = RequestMethod.POST)
	public String handleSubmit(@ModelAttribute("command") EncryptionCommand command) {
				
		command.setEncryptedText(encryptionService.encryptText(command.getText()));
		return "encryption/encryption";
		
	}
	
}