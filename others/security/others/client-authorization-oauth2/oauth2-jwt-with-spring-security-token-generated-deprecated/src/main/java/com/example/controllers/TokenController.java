package com.example.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class TokenController {
	
	@Value("${token.expriration.milliseconds}")
	private long tokenExpirationMilliseconds;
	
	@Value("${token.secret.key}")
	private String tokenSecretKey;

	@RequestMapping(value="/token")
	public String token() {
		
		return Jwts.builder()
			.setSubject("JWT")
			.claim("name", "JWT")
			.claim("role", "ROLE_USER")			
			.setIssuedAt(new Date(System.currentTimeMillis()))
			.setExpiration(new Date(System.currentTimeMillis() + tokenExpirationMilliseconds))
			.signWith(SignatureAlgorithm.HS512, tokenSecretKey)
			.compact();
		
	}
	
}