package com.example.filters;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.micrometer.common.util.StringUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class SecurityFilter extends OncePerRequestFilter  {

    @Value(value = "${basic.username.user}")
    private String usernameUser;
	@Value(value = "${basic.password.user}")
    private String passwordUser;
	@Value(value = "${basic.username.admin}")
    private String usernameAdmin;
	@Value(value = "${basic.password.admin}")
    private String passwordAdmin;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String redirect = request.getParameter("redirect");
            SecurityContext context = SecurityContextHolder.getContext();
            HttpSession session = request.getSession();

            if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
                filterChain.doFilter(request, response); 
                return;	
            }

            if (usernameUser.equals(username) && passwordUser.equals(password)) {
                Set<SimpleGrantedAuthority> roles = Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));			
                context.setAuthentication(new UsernamePasswordAuthenticationToken(username, password, roles));
                session.setAttribute("SPRING_SECURITY_CONTEXT", context);
                filterChain.doFilter(request, response); 
                return;	
            }
    
            if (usernameAdmin.equals(username) && passwordAdmin.equals(password)) {
                Set<SimpleGrantedAuthority> roles = Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"));
                context.setAuthentication(new UsernamePasswordAuthenticationToken(username, password, roles));
                session.setAttribute("SPRING_SECURITY_CONTEXT", context);
                filterChain.doFilter(request, response); 
                return;	
            }

            response.sendRedirect("/login?error&redirect=" + redirect);

    }
    
}
