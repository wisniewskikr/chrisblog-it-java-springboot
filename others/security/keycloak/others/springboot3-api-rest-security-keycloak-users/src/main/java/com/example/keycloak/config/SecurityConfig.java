package com.example.keycloak.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                    .disable()
                .authorizeHttpRequests()
                    .requestMatchers("/api/v1/demo")
                        .permitAll()
                    .anyRequest()
                        .authenticated();

        http
                .oauth2ResourceServer()
                    .jwt();

        http
                .sessionManagement()
                    .sessionCreationPolicy(STATELESS);

        return http.build();
    }
}
