package com.example.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.example.jsons.UserJson;
import com.google.gson.Gson;

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
	public String token(HttpServletRequest request) throws ServletException, IOException {

		UserJson userJson = getUserJson(request);
		return createToken(userJson);	
		
	}

	private UserJson getUserJson(HttpServletRequest request) throws IOException {

        String requestData = request.getReader().lines().collect(Collectors.joining());
        if (StringUtils.isBlank(requestData)) {
            return null;
        }

        return new Gson().fromJson(requestData, UserJson.class);

    }

	private String createToken(UserJson userJson) throws ServletException {

		if (userJson == null) {
            return null;
        }

		if (userName.equals(userJson.getName()) && userPassword.equals(userJson.getPassword())) {
			return createTokenByNameAndRole(userName, "ROLE_USER");
		}

		if (adminName.equals(userJson.getName()) && adminPassword.equals(userJson.getPassword())) {
			return createTokenByNameAndRole(adminName, "ROLE_ADMIN");
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
