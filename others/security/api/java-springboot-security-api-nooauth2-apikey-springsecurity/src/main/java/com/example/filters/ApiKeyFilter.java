package com.example.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class ApiKeyFilter extends OncePerRequestFilter  {

    @Value("${api.key.name}")
	private String apiKeyName;

    @Value("${api.key.value.user}")
	private String apiKeyValueUser;

    @Value("${api.key.value.admin}")
	private String apiKeyValueAdmin;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        String apiKey = request.getHeader(apiKeyName);
        String path = request.getRequestURI();
        ArrayList<String> apiKeyValues = getApiKeyValues(path);

        if (!isPathSecured(path)) {
            filterChain.doFilter(request, response); 
            return;
        }

        if (apiKey == null) {
            throw new BadCredentialsException("The API key was not definied.");
        }

        if (!apiKeyValues.contains(apiKey)) {
            throw new BadCredentialsException("The API key was not found or not the expected value.");
        }

        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(apiKey, null, null));
        filterChain.doFilter(request, response);        

    }

    private boolean isPathSecured(String path) {

        if ("/user".equals(path) || "/admin".equals(path)) {
            return true;
        }

        return false;

    }

    private ArrayList<String> getApiKeyValues(String path) {

        ArrayList<String> apiKeyValues = new ArrayList<String>();

        if ("/user".equals(path)) {
            apiKeyValues.add(apiKeyValueUser);
            apiKeyValues.add(apiKeyValueAdmin);
        }

        if ("/admin".equals(path)) {  
            apiKeyValues.add(apiKeyValueAdmin);
        }

        return apiKeyValues;

    }

}