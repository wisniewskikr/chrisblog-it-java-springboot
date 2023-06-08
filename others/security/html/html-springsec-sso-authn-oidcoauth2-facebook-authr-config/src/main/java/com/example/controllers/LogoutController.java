package com.example.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.oauth2.core.OAuth2AccessToken;
// import org.springframework.security.oauth2.core.OAuth2RefreshToken;
// import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

	@RequestMapping(value="/logout-custom")
	public String login(HttpServletRequest request, HttpServletResponse response) {
		
		// Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    // if (auth != null){    
	    //     new SecurityContextLogoutHandler().logout(request, response, auth);
	    // }
		
        // String authorization = request.getHeader("Authorization");
        // if (authorization != null && authorization.contains("Bearer")) {
        //     String tokenValue = authorization.replace("Bearer", "").trim();

        //     OAuth2AccessToken accessToken = tokenStore.readAccessToken(tokenValue);
        //     tokenStore.removeAccessToken(accessToken);

        //     //OAuth2RefreshToken refreshToken = tokenStore.readRefreshToken(tokenValue);
        //     OAuth2RefreshToken refreshToken = accessToken.getRefreshToken();
        //     tokenStore.removeRefreshToken(refreshToken);
        // }

		return "redirect:/?logout";		
	}
	
}
