package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

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

	@GetMapping("/token")
    public String token(HttpServletRequest request) throws ServletException {
		
		String token = null;
		
		String authorizationHeader = request.getHeader("authorization");		
		if (authorizationHeader == null) {
			throw new ServletException("This resource is secured by Basic Authorization");
		}
		
		try {
            
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = getUsernamePasswordAuthenticationToken(authorizationHeader);
			Authentication authenticate = authorizationManager.authenticate(usernamePasswordAuthenticationToken);
			token = generateToken(authenticate);
			            
        } catch (UsernameNotFoundException exception) {
        	throw new UsernameNotFoundException("Wrong username or password");
        } catch (ServletException e) {
			throw e;
		}
		
		return token;
		
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
