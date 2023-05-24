package com.example.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.filters.BasicFilter;
import com.example.filters.JwtFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig { 
    
    @Configuration
	@Order(1)
    public class ConfigurationBasic {

        private BasicFilter basicFilter;    

        @Autowired
        public ConfigurationBasic(BasicFilter basicFilter) {
            this.basicFilter = basicFilter;
        }

        @Bean
        public SecurityFilterChain filterChainBasic(HttpSecurity http) throws Exception {

            http
                .authorizeHttpRequests((requests) -> requests
                    .requestMatchers("/").permitAll()
                    .requestMatchers("/token").hasAnyRole("USER", "ADMIN")
                )
                .addFilterBefore(basicFilter, UsernamePasswordAuthenticationFilter.class)
                .csrf(Customizer.withDefaults())
                .sessionManagement(session -> session
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );
            
            return http.build();
            
        }

    }

    @Configuration
	@Order(2)
    public class ConfigurationOAuth2 {

        private JwtFilter jwtFilter;    

        @Autowired
        public ConfigurationOAuth2(JwtFilter jwtFilter) {
            this.jwtFilter = jwtFilter;
        }

        @Bean
        public SecurityFilterChain filterChainOAuth2(HttpSecurity http) throws Exception {

            http
                .authorizeHttpRequests((requests) -> requests
                    .requestMatchers("/").permitAll()
                    .requestMatchers("/user").hasAnyRole("USER", "ADMIN")
                    .requestMatchers("/admin").hasAnyRole("ADMIN")               
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .csrf(Customizer.withDefaults())
                .sessionManagement(session -> session
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );
            
            return http.build();
            
        }

    }    

}