package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jsons.AuthRequestJson;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Value;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

@RestController
public class TokenController {
	
	@Value("${token.secret.key}")
	private String tokenSecretKey;
	
	private final AuthenticationManager authorizationManager;
	
	@Autowired
	public TokenController(AuthenticationManager authorizationManager) {
		this.authorizationManager = authorizationManager;
	}

	@PostMapping("/token")
    public String token(@RequestBody AuthRequestJson authRequest) throws ServletException {
		
		String token = null;
		
		try {
            
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());
			Authentication authenticate = authorizationManager.authenticate(usernamePasswordAuthenticationToken);
			token = generateToken(authenticate);
			            
        } catch (UsernameNotFoundException exception) {
        	throw new UsernameNotFoundException("User with following username not found: " + authRequest.getUsername());
        } catch (ServletException e) {
			throw e;
		}
		
		return token;
		
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
