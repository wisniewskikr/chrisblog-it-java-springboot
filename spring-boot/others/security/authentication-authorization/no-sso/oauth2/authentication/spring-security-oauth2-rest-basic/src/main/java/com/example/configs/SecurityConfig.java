package com.example.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.filters.JwtFilter;

@EnableWebSecurity
public class SecurityConfig {
	
	@Value(value = "${basic.username.user}")
    private String usernameUser;
	@Value(value = "${basic.password.user}")
    private String passwordUser;
	@Value(value = "${basic.username.admin}")
    private String usernameAdmin;
	@Value(value = "${basic.password.admin}")
    private String passwordAdmin;

	@Bean
    public PasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
    public AuthenticationManager authorizationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
	
	@Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {		
		
        UserDetails user = User
        	.withUsername(usernameUser)
            .password(bcryptPasswordEncoder().encode(passwordUser))
            .roles("USER")
            .build();
        
        UserDetails admin = User
            	.withUsername(usernameAdmin)
                .password(bcryptPasswordEncoder().encode(passwordAdmin))
                .roles("ADMIN")
                .build();
        
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(user);
        manager.createUser(admin);
        
        return manager;
        
    }
	
	@Bean
	public JwtFilter jwtFilter() {
		return new JwtFilter("/user", "/admin");
	}
	
	@Bean
	@Order(1)
    public SecurityFilterChain filterChainBasic(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http
			.antMatcher("/auth/login")
			.authorizeHttpRequests(authorize -> authorize
					.anyRequest().hasAnyRole("USER", "ADMIN")
			);
		
		http.httpBasic();
        
        return http.build();
        
    }
	
	@Bean
	@Order(2)
    public SecurityFilterChain filterChainTokenUser(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http
			.antMatcher("/user")
			.authorizeHttpRequests(authorize -> authorize
				.anyRequest().hasAnyRole("USER", "ADMIN")
			);
		
		http
    		.addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class);
        
        return http.build();
        
    }
	
	@Bean
	@Order(3)
    public SecurityFilterChain filterChainTokenAdmin(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http
			.antMatcher("/admin")
			.authorizeHttpRequests(authorize -> authorize
					.anyRequest().hasAnyRole("ADMIN")
			);
		
		http
    		.addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class);
        
        return http.build();
        
    }

}
