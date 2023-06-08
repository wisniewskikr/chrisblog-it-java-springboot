package com.example.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

import com.example.handlers.KeycloakLogoutHandler;

@Configuration
@EnableWebSecurity
class SecurityConfig {

    private final KeycloakLogoutHandler keycloakLogoutHandler;

    @Autowired
    SecurityConfig(KeycloakLogoutHandler keycloakLogoutHandler) {
        this.keycloakLogoutHandler = keycloakLogoutHandler;
    }

    @Bean
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
            .build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http            
            .authorizeHttpRequests((requests) -> requests
				.requestMatchers("/user").hasAnyRole("USER", "ADMIN")
                .requestMatchers("/admin").hasAnyRole("ADMIN")
                .anyRequest().permitAll()
			)
            .oauth2Login(Customizer.withDefaults())
            .logout(logout -> logout
                .addLogoutHandler(keycloakLogoutHandler)
                .logoutSuccessUrl("/")
            )
            .oauth2ResourceServer(configurer -> configurer.jwt(Customizer.withDefaults()))
            .exceptionHandling(exception -> exception
                .accessDeniedPage("/access-denied")
            )
            .csrf(Customizer.withDefaults());
        
        return http.build();

    }
    
}