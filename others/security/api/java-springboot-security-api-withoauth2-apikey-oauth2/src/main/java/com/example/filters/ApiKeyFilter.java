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

import org.springframework.security.core.Authentication;

@Component
public class ApiKeyFilter extends OncePerRequestFilter {
	
	@Value("${api.key.name}")
	private String apiKeyName;

    @Value("${api.key.value.user}")
	private String apiKeyValueUser;

    @Value("${api.key.value.admin}")
	private String apiKeyValueAdmin;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
        String apiKeyValue = request.getHeader(apiKeyName);
		if (apiKeyValue == null) {
            filterChain.doFilter(request, response);
            return;
        }
		
		UserJson userJson = new UserJson(apiKeyName, apiKeyValue); 
		SecurityContextHolder.getContext().setAuthentication(getAuthentication(userJson));
		filterChain.doFilter(request, response);
		
	}	
	
	private Authentication getAuthentication(UserJson userJson ) {

        if (userJson == null) {
            return null;
        }

        if (apiKeyName.equals(userJson.getName()) && apiKeyValueUser.equals(userJson.getPassword())) {
            return new UsernamePasswordAuthenticationToken(null, null, Collections.singleton(new SimpleGrantedAuthority("ROLE_USER_TOKEN")));
        }

        if (apiKeyName.equals(userJson.getName()) && apiKeyValueAdmin.equals(userJson.getPassword())) {
            return new UsernamePasswordAuthenticationToken(null, null, Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN_TOKEN")));
        }

        return null;

    }

}
