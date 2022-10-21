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


public class CustomCodeAuthenticationFilter implements Filter {
	
	private String code;
	private String path;

	public CustomCodeAuthenticationFilter(String code, String path) {
		this.code = code;
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
		
		if (notAuthenticated(httpRequest)) {
			throw new AuthenticationException("Wrong Code");
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
	
	private boolean notAuthenticated(HttpServletRequest httpRequest) {
		
		boolean result = true;
		
		String codeParam = httpRequest.getParameter("code");
		if (code.equals(codeParam)) {
			result = false;
		}
			
		return result;
		
	}
		

}
