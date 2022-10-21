package com.example.controllers;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

@RestController
public class TokenController {
	
	@Value("${token.secret.key}")
	private String tokenSecretKey;

	@RequestMapping(value="/token")
	public String token() throws ServletException {
		
		String token = null;
		
		try {
			
		    Algorithm algorithm = Algorithm.HMAC256(tokenSecretKey);
		    token = JWT.create()
		    		.withClaim("name", "Demo")
		    		.withClaim("role", "ROLE_USER")
		    		.sign(algorithm);
		    
		} catch (JWTCreationException exception){
			throw new ServletException("Problem with creation of token");
		}
		
		return token;
		
	}
	
}