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
import com.example.filters.OAuth2Filter;

@Configuration
public class SecurityConfig {
    
    private ApiKeyFilter apiKeyFilter; 

    private OAuth2Filter oAuth2Filter; 
    
    @Autowired
    public SecurityConfig(ApiKeyFilter apiKeyFilter, OAuth2Filter oAuth2Filter) {
        this.apiKeyFilter = apiKeyFilter;
        this.oAuth2Filter = oAuth2Filter;
    }

    @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

            http
                .authorizeHttpRequests((requests) -> requests
                    .requestMatchers("/").permitAll()
                    .requestMatchers("/token").hasAnyRole("USER_TOKEN", "ADMIN_TOKEN")
                    .requestMatchers("/user").hasAnyRole("USER", "ADMIN")
                    .requestMatchers("/admin").hasAnyRole("ADMIN") 
                    .anyRequest().permitAll()              
                )
                .addFilterBefore(apiKeyFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(oAuth2Filter, UsernamePasswordAuthenticationFilter.class)
                .csrf(Customizer.withDefaults())
                .sessionManagement(session -> session
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );
            
            return http.build();
            
        }

}