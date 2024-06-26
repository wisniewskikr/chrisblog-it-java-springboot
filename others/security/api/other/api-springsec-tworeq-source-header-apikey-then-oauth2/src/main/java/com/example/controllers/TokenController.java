package com.example.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
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

	@Value("${api.key.name}")
	private String apiKeyName;

    @Value("${api.key.value.user}")
	private String apiKeyValueUser;

    @Value("${api.key.value.admin}")
	private String apiKeyValueAdmin;

	@RequestMapping(value="/token")
	public String token(HttpServletRequest request) throws ServletException, IOException {

		UserJson userJson = getUserJson(request);
		return createToken(userJson);	
		
	}

	private UserJson getUserJson(HttpServletRequest request) throws IOException {

		String apiKeyValue = request.getHeader(apiKeyName);
		return new UserJson(apiKeyName, apiKeyValue); 

    }

	private String createToken(UserJson userJson) throws ServletException {

		if (userJson == null) {
            return null;
        }

		if (apiKeyName.equals(userJson.getName()) && apiKeyValueUser.equals(userJson.getPassword())) {
			return createTokenByNameAndRole(apiKeyName, "ROLE_USER");
		}

		if (apiKeyName.equals(userJson.getName()) && apiKeyValueAdmin.equals(userJson.getPassword())) {
			return createTokenByNameAndRole(apiKeyName, "ROLE_ADMIN");
		}

		return null;

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
