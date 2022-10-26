package com.example.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Value;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

@RestController
public class TokenController {
	
	@Value("${token.secret.key}")
	private String tokenSecretKey;

	@GetMapping("/token")
    public String token() throws ServletException {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();		
		return generateToken(authentication);
		
	}
	
	private String generateToken(Authentication authenticate) throws ServletException {
		
		String token = null;
		
		GrantedAuthority[] grantedAuthorities = authenticate.getAuthorities().toArray(new GrantedAuthority[authenticate.getAuthorities().size()]);
		
		try {			
			
			Algorithm algorithm = Algorithm.HMAC256(tokenSecretKey);
		    token = JWT.create()
		    		.withClaim("name", authenticate.getName())
		    		.withClaim("role", grantedAuthorities[0].getAuthority())
		    		.sign(algorithm);
		    
		} catch (JWTCreationException exception){
			throw new ServletException("Problem with creation of token");
		}
		
		return token;
		
	}

}
