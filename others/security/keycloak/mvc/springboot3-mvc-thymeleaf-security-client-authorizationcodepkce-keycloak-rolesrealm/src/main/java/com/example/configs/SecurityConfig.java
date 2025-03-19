package com.example.configs;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUserAuthority;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import lombok.RequiredArgsConstructor;

import java.util.Set;

import org.springframework.core.convert.converter.Converter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    @Value("${jwt.auth.post-logout-uri}")
    private String postLogoutUri;
    

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, ClientRegistrationRepository clientRegistrationRepository) throws Exception {

        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/login", "/logout", "/public").permitAll()
                .requestMatchers("/user").hasAnyRole("USER","ADMIN")
                .requestMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated()
            );

        http
            .oauth2Login(Customizer.withDefaults());

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

    interface AuthoritiesConverter extends Converter<Map<String, Object>, Collection<GrantedAuthority>> {}

    @Bean
    AuthoritiesConverter realmRolesAuthoritiesConverter() {
        return claims -> {  

            Map<String, Object> realmAccess;
            Collection<String> resourceRoles;

            if (claims.get("realm_access") == null) {
                return Set.of();
            }
            realmAccess = (Map<String, Object>) claims.get("realm_access");

            resourceRoles = (Collection<String>) realmAccess.get("roles");
            return resourceRoles
                    .stream()
                    .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                    .collect(Collectors.toSet());
                    
        };
    }

    @Bean
    GrantedAuthoritiesMapper authenticationConverter(
    Converter<Map<String, Object>, Collection<GrantedAuthority>> realmRolesAuthoritiesConverter) {

        return (authorities) -> authorities.stream()
                .filter(authority -> authority instanceof OidcUserAuthority)
                .map(OidcUserAuthority.class::cast)
                .map(OidcUserAuthority::getIdToken)
                .map(OidcIdToken::getClaims)
                .map(realmRolesAuthoritiesConverter::convert)
                .flatMap(roles -> roles.stream())
                .collect(Collectors.toSet());
    }

    @Bean
    public LogoutSuccessHandler oidcLogoutSuccessHandler(ClientRegistrationRepository clientRegistrationRepository) {

        OidcClientInitiatedLogoutSuccessHandler oidcLogoutSuccessHandler = 
            new OidcClientInitiatedLogoutSuccessHandler(clientRegistrationRepository);        
        oidcLogoutSuccessHandler.setPostLogoutRedirectUri(postLogoutUri);        
        return oidcLogoutSuccessHandler;
        
    }   

}