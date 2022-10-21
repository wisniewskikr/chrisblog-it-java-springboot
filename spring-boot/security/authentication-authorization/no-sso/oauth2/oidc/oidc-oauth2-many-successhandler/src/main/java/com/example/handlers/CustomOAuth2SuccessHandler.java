package com.example.handlers;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomOAuth2SuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		
		System.out.println("***** CustomOAuth2SuccessHandler *****" );
		
		OAuth2User user = (OAuth2User) authentication.getPrincipal();
		
		Map<String, Object> attributes = user.getAttributes();
		Set<String> keys = attributes.keySet();
		for (String key : keys) {
			System.out.println("ATTRIBURE - Key: " + key + "; Value: " + attributes.get(key));
		}
		
		Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			System.out.println("GRANTEDAUTHORITY - Name: " + grantedAuthority.getAuthority());
		}
		
		response.sendRedirect("/helloworld");
		
		super.onAuthenticationSuccess(request, response, authentication);
	}
	
	

}
