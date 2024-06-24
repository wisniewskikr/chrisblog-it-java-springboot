package com.example.controllers;

import jakarta.servlet.ServletException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.example.jsons.UserJson;

@RestController
public class TokenController {
	
	@Value("${token.secret.key}")
	private String tokenSecretKey;

	@Value("${credentials.user.name}")
	private String userName;

    @Value("${credentials.admin.name}")
	private String adminName;

    @Value("${credentials.user.password}")
	private String userPassword;

    @Value("${credentials.admin.password}")
	private String adminPassword;

	@RequestMapping(value="/token")
	public String token(@RequestBody(required = false) UserJson userJson) throws ServletException {
		return createToken(userJson);	
	}

	private String createToken(UserJson userJson) throws ServletException {

		if (userJson == null) {
            throw new BadCredentialsException("Credentials are not sent or are in not valid format !");
        }

		if (userName.equals(userJson.getName()) && userPassword.equals(userJson.getPassword())) {
			return createTokenByNameAndRole(userName, "ROLE_USER");
		}

		if (adminName.equals(userJson.getName()) && adminPassword.equals(userJson.getPassword())) {
			return createTokenByNameAndRole(adminName, "ROLE_ADMIN");
		}

		throw new BadCredentialsException("Credentials are not valid !");

	}

	private String createTokenByNameAndRole(String name, String role) throws ServletException {

		String token = null;
		
		try {
			
		    Algorithm algorithm = Algorithm.HMAC256(tokenSecretKey);
		    token = JWT.create()
		    		.withClaim("name", name)
		    		.withClaim("role", role)
		    		.sign(algorithm);
		    
		} catch (JWTCreationException exception){
			throw new ServletException("Problem with creation of token");
		}
		
		return token;

	}
	
}
