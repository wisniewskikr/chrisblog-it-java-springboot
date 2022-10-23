package com.example.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Value(value = "${basic.username}")
    private String username;
	@Value(value = "${basic.password}")
    private String password;

	@Bean
    public PasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
		
        UserDetails user = User
        	.withUsername(username)
            .password(bcryptPasswordEncoder().encode(password))
            .roles("USER")
            .build();
        
        return new InMemoryUserDetailsManager(user);
        
    }
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
        
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http
        	.authorizeRequests((authReq) -> authReq
        		.antMatchers("/").hasRole("USER")
        	);  
		
		http.httpBasic();
        
        return http.build();
        
    }

}
