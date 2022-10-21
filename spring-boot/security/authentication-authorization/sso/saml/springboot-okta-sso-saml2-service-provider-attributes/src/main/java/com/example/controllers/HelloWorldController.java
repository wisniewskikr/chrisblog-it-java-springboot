package com.example.controllers;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.saml2.provider.service.authentication.Saml2AuthenticatedPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.commands.HelloWorldCommand;


@Controller
@RequestMapping(value="/")
public class HelloWorldController {

	@RequestMapping(method = RequestMethod.GET)
	public String display(@ModelAttribute("command") HelloWorldCommand command, 
			@AuthenticationPrincipal Saml2AuthenticatedPrincipal saml2AuthenticatedPrincipal) {
		
		handleAttributesSaml2(saml2AuthenticatedPrincipal);		
		return "helloworld/helloworld";		
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String handleSubmit(
			@ModelAttribute("command") HelloWorldCommand command,
			@AuthenticationPrincipal Saml2AuthenticatedPrincipal saml2AuthenticatedPrincipal) {
				
		handleAttributesSaml2(saml2AuthenticatedPrincipal);	
		command.setMessage(String.format("Hello World %s!", command.getName()));
		command.setName(null);
		return "helloworld/helloworld";
		
	}
	
	private void handleAttributesSaml2(Saml2AuthenticatedPrincipal saml2AuthenticatedPrincipal) {
		
		Map<String, List<Object>> attributesMap = saml2AuthenticatedPrincipal.getAttributes();
		Set<String> attributes = attributesMap.keySet();
		
		if (attributes.isEmpty()) {
			System.out.println("No Attributes");
		}
		
		for (String attribute : attributes) {
			System.out.println(attribute + ": " + attributesMap.get(attribute).toString());
		}	
		
	}
	
}