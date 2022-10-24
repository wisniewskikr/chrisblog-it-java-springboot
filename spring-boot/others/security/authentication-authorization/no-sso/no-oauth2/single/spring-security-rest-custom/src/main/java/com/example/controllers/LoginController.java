package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jsons.AuthRequestJson;

@RestController
public class LoginController {
	
	private final AuthenticationManager authorizationManager;
	
	@Autowired
	public LoginController(AuthenticationManager authorizationManager) {
		this.authorizationManager = authorizationManager;
	}

	@PostMapping("/auth/login")
    public String login(@RequestBody AuthRequestJson authRequest) {
		
		try {
            
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());
			authorizationManager.authenticate(usernamePasswordAuthenticationToken);			
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            
        } catch (UsernameNotFoundException exception) {
        	throw new UsernameNotFoundException("User with email not found: " + authRequest.getUsername());
        }
		
		return "You are successfully logged!";
		
	}

}
