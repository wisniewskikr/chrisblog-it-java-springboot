package com.example.controllers;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
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

		String redirect = request.getParameter("redirect");

		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		if (authentication != null && !"anonymousUser".equals(authentication.getPrincipal())) {
			return "redirect:/" + redirect;	
		}

		return "login";		
	}

	@PostMapping("/login")
	public String login(HttpSession session, HttpServletRequest request) {	
		
		String username = request.getParameter("username");
        String password = request.getParameter("password");
		String redirect = request.getParameter("redirect");

        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return "redirect:/login?error&redirect=" + redirect;	
        }		

		return "redirect:/" + redirect;	

	}
	
}