package com.example.controllers;

import java.util.Collections;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	@Value(value = "${basic.username.user}")
    private String usernameUser;
	@Value(value = "${basic.password.user}")
    private String passwordUser;
	@Value(value = "${basic.username.admin}")
    private String usernameAdmin;
	@Value(value = "${basic.password.admin}")
    private String passwordAdmin;

	@GetMapping("/login")
	public String display(HttpServletRequest request) {	
		return "login";		
	}

	@PostMapping("/login")
	public String login(HttpSession session, HttpServletRequest request) {	
		
		String username = request.getParameter("username");
        String password = request.getParameter("password");
		String redirect = request.getParameter("redirect");

        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return "redirect:/login?error";	
        }

		if (usernameUser.equals(username) && passwordUser.equals(password)) {
			Set<SimpleGrantedAuthority> roles = Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
			SecurityContext context = SecurityContextHolder.getContext();
			context.setAuthentication(new UsernamePasswordAuthenticationToken(username, password, roles));
			session.setAttribute("SPRING_SECURITY_CONTEXT", context);
			return "redirect:/" + redirect;	
		}

		if (usernameAdmin.equals(username) && passwordAdmin.equals(password)) {
			Set<SimpleGrantedAuthority> roles = Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"));
			SecurityContext context = SecurityContextHolder.getContext();
			context.setAuthentication(new UsernamePasswordAuthenticationToken(username, password, roles));
			session.setAttribute("SPRING_SECURITY_CONTEXT", context);
			return "redirect:/" + redirect;	
		}

		return "redirect:/login?error";	
	}
	
}
