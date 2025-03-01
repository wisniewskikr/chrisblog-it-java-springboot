package com.example.configs;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.example.users.CustomOidcUser;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, ClientRegistrationRepository clientRegistrationRepository) throws Exception {

        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/login", "/public").permitAll()
                .anyRequest().authenticated()
            );

        http
            .oauth2Login(oauth2 -> oauth2
                .userInfoEndpoint(userInfo -> userInfo.oidcUserService(this.oidcUserService()))
            );

        http
            .logout(logout -> logout
                .logoutSuccessHandler(oidcLogoutSuccessHandler(clientRegistrationRepository))
            );

        http
            .exceptionHandling(exception -> exception
                .accessDeniedPage("/access-denied")
            );
        
        return http.build();
        
    }

    @Bean
    public LogoutSuccessHandler oidcLogoutSuccessHandler(ClientRegistrationRepository clientRegistrationRepository) {

        OidcClientInitiatedLogoutSuccessHandler oidcLogoutSuccessHandler = 
            new OidcClientInitiatedLogoutSuccessHandler(clientRegistrationRepository);
        
        // Configure the post-logout redirect URI
        oidcLogoutSuccessHandler.setPostLogoutRedirectUri("http://localhost:9090/");
        
        return oidcLogoutSuccessHandler;
    }

     @Bean
    public OidcUserService oidcUserService() {
        return new OidcUserService() {
            @Override
            public OidcUser loadUser(OidcUserRequest userRequest) {
                OidcUser oidcUser = super.loadUser(userRequest);

                Set<GrantedAuthority> mappedAuthorities = new HashSet<>(oidcUser.getAuthorities());

                // Extract roles from the token
                Collection<String> roles = oidcUser.getClaimAsStringList("roles");
                if (roles != null) {
                    mappedAuthorities.addAll(
                        roles.stream()
                            .map(role -> new SimpleGrantedAuthority("ROLE_" + role.toUpperCase()))
                            .collect(Collectors.toSet())
                    );
                }

                return new CustomOidcUser(mappedAuthorities, oidcUser);
            }
        };
    }

}