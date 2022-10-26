package com.example.controllers;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	private final AuthenticationManager authorizationManager;
	
	@Autowired
	public LoginController(AuthenticationManager authorizationManager) {
		this.authorizationManager = authorizationManager;
	}

	@GetMapping("/auth/login")
    public String login(HttpServletRequest request) throws ServletException {
		
		String authorizationHeader = request.getHeader("authorization");		
		if (authorizationHeader == null) {
			throw new ServletException("This resource is secured by Basic Authorization");
		}
		
		try {
            
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = getUsernamePasswordAuthenticationToken(authorizationHeader);
			authorizationManager.authenticate(usernamePasswordAuthenticationToken);			
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            
        } catch (UsernameNotFoundException exception) {
        	throw new UsernameNotFoundException("Wrong username or password");
        }
		
		return "You are successfully logged in!";
		
	}
	
	private UsernamePasswordAuthenticationToken getUsernamePasswordAuthenticationToken(String authorizationHeader) throws ServletException {
		
		UsernamePasswordAuthenticationToken authentication = null;
		
		String credentialsEncoded = authorizationHeader.substring(6);		
		byte[] credentialsDecoded = Base64.getDecoder().decode(credentialsEncoded);
		String credentials = new String(credentialsDecoded, StandardCharsets.UTF_8);
		String username = credentials.split(":")[0];
		String password = credentials.split(":")[1];
		authentication = new UsernamePasswordAuthenticationToken(username, password);
		
		return authentication;
		
	}

}
