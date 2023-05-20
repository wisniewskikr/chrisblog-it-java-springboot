package com.example.filters;

import java.io.IOException;

import javax.security.sasl.AuthenticationException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.www.BasicAuthenticationConverter;


public class CustomBasicAuthenticationFilter implements Filter {
	
	private String username;
	private String password;
	private String path;

	public CustomBasicAuthenticationFilter(String username, String password, String path) {
		this.username = username;
		this.password = password;
		this.path = path;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		UsernamePasswordAuthenticationToken authRequest = new BasicAuthenticationConverter().convert((HttpServletRequest)request);
		
		if (!shouldBeAuthenticated(httpRequest)) {
			chain.doFilter(request, response);
			return;
		}
		
		if (authRequest == null) {
			throw new AuthenticationException("No Basic Authentication");
		}
		
		if (notAuthenticated(authRequest)) {
			throw new AuthenticationException("Wrong Username or Password");
		}	
		
		chain.doFilter(request, response);
		
	}
	
	private boolean shouldBeAuthenticated(HttpServletRequest httpRequest) {
		
		boolean result = false;
		
		String currentPath = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());		
		if (path.equals(currentPath)) {
			result = true;
		}
		
		return result;
		
	}	
	
	private boolean notAuthenticated(UsernamePasswordAuthenticationToken authRequest) {
		
		boolean result = true;
		
		if (username.equals(authRequest.getName()) && password.equals(authRequest.getCredentials())) {
			result = false;
		}
			
		return result;
		
	}
		

}
