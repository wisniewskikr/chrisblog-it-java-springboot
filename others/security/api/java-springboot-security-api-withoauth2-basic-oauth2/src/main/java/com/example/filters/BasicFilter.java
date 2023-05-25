package com.example.filters;

import java.io.IOException;
import java.util.Collections;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.jsons.UserJson;
import com.example.utils.JsonUtils;

import org.springframework.security.core.Authentication;

@Component
public class BasicFilter extends OncePerRequestFilter {
	
	@Value("${credentials.user.name}")
	private String userName;

    @Value("${credentials.admin.name}")
	private String adminName;

    @Value("${credentials.user.password}")
	private String userPassword;

    @Value("${credentials.admin.password}")
	private String adminPassword;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String authorizationHeader = request.getHeader("authorization");
		if (authorizationHeader == null || !authorizationHeader.toLowerCase().startsWith("basic")) {
            filterChain.doFilter(request, response);
            return;
        }
		
		UserJson userJson = JsonUtils.getUserJson(authorizationHeader);
		SecurityContextHolder.getContext().setAuthentication(getAuthentication(userJson));
		filterChain.doFilter(request, response);
		
	}	
	
	private Authentication getAuthentication(UserJson userJson ) {

        if (userJson == null) {
            return null;
        }

        if (userName.equals(userJson.getName()) && userPassword.equals(userJson.getPassword())) {
            return new UsernamePasswordAuthenticationToken(null, null, Collections.singleton(new SimpleGrantedAuthority("ROLE_USER_TOKEN")));
        }

        if (adminName.equals(userJson.getName()) && adminPassword.equals(userJson.getPassword())) {
            return new UsernamePasswordAuthenticationToken(null, null, Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN_TOKEN")));
        }

        return null;

    }

}
