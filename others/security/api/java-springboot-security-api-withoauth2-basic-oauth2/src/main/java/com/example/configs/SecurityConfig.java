package com.example.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.filters.BasicFilter;
import com.example.filters.OAuth2Filter;

@Configuration
public class SecurityConfig {
    
    private BasicFilter basicFilter; 

    private OAuth2Filter oAuth2Filter; 
    
    @Autowired
    public SecurityConfig(BasicFilter basicFilter, OAuth2Filter oAuth2Filter) {
        this.basicFilter = basicFilter;
        this.oAuth2Filter = oAuth2Filter;
    }

    @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

            http
                .authorizeHttpRequests((requests) -> requests
                    .requestMatchers("/").permitAll()
                    .requestMatchers("/token").hasAnyRole("USER", "ADMIN")
                    .requestMatchers("/user").hasAnyRole("USER", "ADMIN")
                    .requestMatchers("/admin").hasAnyRole("ADMIN") 
                    .anyRequest().permitAll()              
                )
                .addFilterBefore(basicFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(oAuth2Filter, UsernamePasswordAuthenticationFilter.class)
                .csrf(Customizer.withDefaults())
                .sessionManagement(session -> session
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );
            
            return http.build();
            
        }

}