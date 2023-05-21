package com.example.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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

        if (!isPathSecured(path)) {
            filterChain.doFilter(request, response); 
            return;
        }

        if (apiKey == null) {
            throw new BadCredentialsException("The API key was not definied.");
        }

        Authentication authentication = getAuthentication(apiKey);
        if (authentication == null) {
            throw new BadCredentialsException("The API key was not found or not the expected value.");
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);        

    }

    private boolean isPathSecured(String path) {

        if ("/user".equals(path) || "/admin".equals(path)) {
            return true;
        }

        return false;

    }

    private Authentication getAuthentication(String apiKey) {

        if (apiKeyValueUser.equals(apiKey)) {
            return new UsernamePasswordAuthenticationToken(apiKey, null, Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
        }

        if (apiKeyValueAdmin.equals(apiKey)) {
            return new UsernamePasswordAuthenticationToken(apiKey, null, Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN")));
        }

        return null;

    }

}