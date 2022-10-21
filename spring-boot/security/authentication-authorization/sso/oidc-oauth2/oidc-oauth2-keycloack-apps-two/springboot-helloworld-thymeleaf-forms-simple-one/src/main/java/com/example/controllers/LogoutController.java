package com.example.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

	@GetMapping(path = "/log-out")
	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.logout();
		response.sendRedirect("http://localhost:8083/auth/realms/helloworld/protocol/openid-connect/logout");
		// http://auth-server/auth/realms/{realm-name}/protocol/openid-connect/logout?redirect_uri=encodedRedirectUri

	}
	
}