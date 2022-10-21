package com.example.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

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
		
		try {
			
			String token = authorizationHeader.substring(7);
			Claims claims = Jwts.parser().setSigningKey(tokenSecretKey).parseClaimsJws(token).getBody();
			request.setAttribute("claims", claims);
			
		} catch (Exception e) {
			throw new ServletException("Wrong key");
		}
		
		chain.doFilter(request, response);
		
	}

}
