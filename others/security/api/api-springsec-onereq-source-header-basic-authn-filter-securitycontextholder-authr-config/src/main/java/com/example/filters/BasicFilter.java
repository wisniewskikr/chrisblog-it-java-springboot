package com.example.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class BasicFilter extends OncePerRequestFilter  {

    @Value("${basic.username.user}")
	private String usernameUser;

    @Value("${basic.password.user}")
	private String passwordUser;

    @Value("${basic.username.admin}")
	private String usernameAdmin;

    @Value("${basic.password.admin}")
	private String passwordAdmin;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        final String authorization = request.getHeader("Authorization");
        if (authorization == null || !authorization.toLowerCase().startsWith("basic")) {
            filterChain.doFilter(request, response);
        }

        String base64Credentials = authorization.substring("Basic".length()).trim();
        byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
        String credentials = new String(credDecoded, StandardCharsets.UTF_8);
        final String[] values = credentials.split(":", 2);
        String userName = values[0];
        String password = values[1];
        
        SecurityContextHolder.getContext().setAuthentication(getAuthentication(userName, password));
        filterChain.doFilter(request, response);        

    }

    private Authentication getAuthentication(String username, String password) {

        if (usernameUser.equals(username) && passwordUser.equals(password)) {
            return new UsernamePasswordAuthenticationToken(null, null, Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
        }

        if (usernameAdmin.equals(username) && passwordAdmin.equals(password)) {
            return new UsernamePasswordAuthenticationToken(null, null, Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN")));
        }

        return null;

    }

}