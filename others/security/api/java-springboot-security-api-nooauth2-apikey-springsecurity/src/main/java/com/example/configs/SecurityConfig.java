package com.example.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.example.filters.ApiKeyFilter;

@Configuration
public class SecurityConfig {

    private ApiKeyFilter apiKeyFilter;

    @Autowired
	public SecurityConfig(ApiKeyFilter apiKeyFilter) {
		this.apiKeyFilter = apiKeyFilter;
	}

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
			.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/").permitAll()
                .requestMatchers("/user", "/admin")
                .authenticated()
			)
            .addFilterBefore(apiKeyFilter, UsernamePasswordAuthenticationFilter.class)
            .csrf(Customizer.withDefaults())
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            );
        
        return http.build();
        
    }

}