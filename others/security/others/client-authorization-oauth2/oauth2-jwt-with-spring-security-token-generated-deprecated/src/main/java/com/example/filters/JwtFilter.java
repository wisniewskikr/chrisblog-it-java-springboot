package com.example.filters;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JwtFilter extends BasicAuthenticationFilter {
	
	private String tokenSecretKey;

	public JwtFilter(String tokenSecretKey, AuthenticationManager authenticationManager) {
		super(authenticationManager);
		this.tokenSecretKey = tokenSecretKey;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String authorizationHeader = httpRequest.getHeader("authorization");
		
		if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
			throw new ServletException("Wrong or empty header");
		}
		
		SecurityContextHolder.getContext().setAuthentication(getUsernamePasswordAuthenticationToken(authorizationHeader));
		chain.doFilter(request, response);
		
	}
	
	

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		
		String path = request.getRequestURI();
	    return "/token".equals(path);
	    
	}

	private UsernamePasswordAuthenticationToken getUsernamePasswordAuthenticationToken(String authorizationHeader) throws ServletException {
		
		UsernamePasswordAuthenticationToken authentication = null;;
		
		try {
			
			String token = authorizationHeader.substring(7);
			Claims claims = Jwts.parser().setSigningKey(tokenSecretKey).parseClaimsJws(token).getBody();
			
			String name = claims.get("name", String.class);
			String role = claims.get("role", String.class);
			Set<SimpleGrantedAuthority> roles = Collections.singleton(new SimpleGrantedAuthority(role));
			authentication = new UsernamePasswordAuthenticationToken(name, null, roles);
			
		} catch (Exception e) {
			throw new ServletException("Wrong key");
		}
		
		return authentication;
		
	}

}
