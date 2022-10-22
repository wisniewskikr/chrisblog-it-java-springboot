package com.example.app.controllers.decryption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.app.commands.encryption.EncryptionCommand;
import com.example.app.services.EncryptionService;


@Controller
public class DecryptionController {
	
	@Autowired
	private EncryptionService encryptionService;

	@RequestMapping(value="/decryption", method = RequestMethod.GET)
	public String display(@ModelAttribute("command") EncryptionCommand command) {
		return "decryption/decryption";
		
	}
	
	@RequestMapping(value="/decryption", method = RequestMethod.POST)
	public String handleSubmit(@ModelAttribute("command") EncryptionCommand command) {
				
		command.setText(encryptionService.decryptText(command.getEncryptedText()));
		return "decryption/decryption";
		
	}
	
}