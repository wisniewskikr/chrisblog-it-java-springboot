package com.example.filters;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

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

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

@Component
public class JwtFilter extends OncePerRequestFilter {
	
	@Value("${token.secret.key}")
	private String tokenSecretKey;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String authorizationHeader = request.getHeader("authorization");
		if (authorizationHeader == null) {
            filterChain.doFilter(request, response);
            return;
        }
		
		SecurityContextHolder.getContext().setAuthentication(getUsernamePasswordAuthenticationToken(authorizationHeader));
		filterChain.doFilter(request, response);
		
	}
	
	private UsernamePasswordAuthenticationToken getUsernamePasswordAuthenticationToken(String authorizationHeader) throws ServletException {
	
		UsernamePasswordAuthenticationToken authentication = null;;
		
		try {
			
			String token = authorizationHeader.substring(7);
			
		    Algorithm algorithm = Algorithm.HMAC256(tokenSecretKey);
		    JWTVerifier verifier = JWT.require(algorithm).build();
		    DecodedJWT jwt = verifier.verify(token);
		    String name = jwt.getClaim("name").as(String.class);
		    String role = jwt.getClaim("role").as(String.class);
		    
			Set<SimpleGrantedAuthority> roles = Collections.singleton(new SimpleGrantedAuthority(role));
			authentication = new UsernamePasswordAuthenticationToken(name, null, roles);
		    
		} catch (JWTVerificationException exception){
			throw new ServletException("Wrong key");
		}
		
		return authentication;
		
	}

}
