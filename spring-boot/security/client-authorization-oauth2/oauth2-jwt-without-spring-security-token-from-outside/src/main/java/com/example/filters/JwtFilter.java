package com.example.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

public class JwtFilter implements Filter {
	
	private String tokenSecretKey;

	public JwtFilter(String tokenSecretKey) {
		this.tokenSecretKey = tokenSecretKey;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String authorizationHeader = httpRequest.getHeader("authorization");
		
		if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
			throw new ServletException("Wrong or empty header");
		}
		
		handleAuthorization(authorizationHeader);		
		chain.doFilter(request, response);
		
	}
	
	private void handleAuthorization(String authorizationHeader) throws ServletException {
		
		String role = null;
		
		try {
			
			String token = authorizationHeader.substring(7);
			
		    Algorithm algorithm = Algorithm.HMAC256(tokenSecretKey);
		    JWTVerifier verifier = JWT.require(algorithm).build();
		    DecodedJWT jwt = verifier.verify(token);
			role = jwt.getClaim("role").as(String.class);
			
		} catch (Exception e) {
			throw new ServletException("Wrong token");
		}
		
		if (role == null || !"ROLE_USER".equals(role)) {
			throw new ServletException("Wrong role in token");
		}
		
	}

}
