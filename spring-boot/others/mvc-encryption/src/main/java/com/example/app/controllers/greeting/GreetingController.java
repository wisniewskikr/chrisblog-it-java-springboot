package com.example.app.controllers.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.app.services.EncryptionService;

@Controller
public class GreetingController {
	
	@Autowired
	private EncryptionService encryptionService;

	@ResponseBody
	@RequestMapping(value="/greeting", method = RequestMethod.GET)	
	public String greeting() {	
		
		String textEncrypted = encryptionService.encryptText("Hello World!");
		String textDecrypted = encryptionService.decryptText(textEncrypted);
		
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("<h1>Text encrypted: %s</h1>", textEncrypted));
		sb.append(String.format("<h1>Text decrypted: %s</h1>", textDecrypted));
		
		return sb.toString();		
	}
	
}