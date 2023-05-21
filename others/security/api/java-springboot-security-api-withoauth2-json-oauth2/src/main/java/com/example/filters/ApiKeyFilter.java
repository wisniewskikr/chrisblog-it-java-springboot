package com.example.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Collections;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.jsons.UserJson;
import com.google.gson.Gson;

public class ApiKeyFilter extends OncePerRequestFilter  {

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
        
        UserJson userJson = getUserJson(request);
        SecurityContextHolder.getContext().setAuthentication(getAuthentication(userJson));
        filterChain.doFilter(request, response);        

    }

    private UserJson getUserJson(HttpServletRequest request) throws IOException {

        String requestData = request.getReader().lines().collect(Collectors.joining());
        if (StringUtils.isBlank(requestData)) {
            return null;
        }

        System.out.println("requestData: " + requestData);
        return new Gson().fromJson(requestData, UserJson.class);

    }

    private Authentication getAuthentication(UserJson userJson ) {

        if (userJson == null) {
            return null;
        }

        if (userName.equals(userJson.getName()) && userPassword.equals(userJson.getPassword())) {
            return new UsernamePasswordAuthenticationToken(null, null, Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
        }

        if (adminName.equals(userJson.getName()) && adminPassword.equals(userJson.getPassword())) {
            return new UsernamePasswordAuthenticationToken(null, null, Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN")));
        }

        return null;

    }

}