package com.example.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

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
                .logoutSuccessUrl("/")
            )
            .exceptionHandling(exception -> exception
                .accessDeniedPage("/access-denied")
            )
            .csrf(Customizer.withDefaults());
        
        return http.build();
        
    }



}