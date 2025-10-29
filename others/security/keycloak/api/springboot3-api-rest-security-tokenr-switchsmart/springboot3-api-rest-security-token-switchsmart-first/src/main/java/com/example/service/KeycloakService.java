package com.example.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

@Service
@Slf4j
public class KeycloakService {

    @Value("${keycloak.administrator.username}")
    private String keycloakUsername;

    @Value("${keycloak.administrator.password}")
    private String keycloakPassword;

    @Value("${jwt.auth.converter.principle-attribute}")
    private String principleAttribute;

    @Value("${jwt.auth.converter.resource-id}")
    private String resourceId;

    private final RestClient restClientKeycloak;

    public KeycloakService(RestClient.Builder restClientBuilder,
                           @Value("${keycloak.url}") String keycloakUrl) {
        this.restClientKeycloak = restClientBuilder
                .baseUrl(keycloakUrl)
                .build();
    }

    public String getAccessTokenForRole(String role) {

        String token = null;

        token = getCurrentTokenIfValidRole(role);
        if (token == null) {
            log.info("***** Switch role");
            token = getNewToken();
        } else {
            log.info("***** No switch role");
        }

        return token;

    }

    private String getCurrentTokenIfValidRole(String role) {

        String token = null;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof Jwt jwt) {

            Map<String, Object> resourceAccess;
            Map<String, Object> resource;
            Collection<String> resourceRoles;
            if (jwt.getClaim("resource_access") == null) {
                return token;
            }
            resourceAccess = jwt.getClaim("resource_access");

            if (resourceAccess.get(resourceId) == null) {
                return token;
            }
            resource = (Map<String, Object>) resourceAccess.get(resourceId);

            resourceRoles = (Collection<String>) resource.get("roles");

            if (resourceRoles.contains(role)) {
                token = jwt.getTokenValue();
            }

        }

        return token;

    }

    private String getNewToken() {

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("grant_type", "password");
        formData.add("client_id", "helloworld-client");
        formData.add("username", keycloakUsername);
        formData.add("password", keycloakPassword);

        Map response = restClientKeycloak.post()
                .uri("/realms/helloworld-realm/protocol/openid-connect/token")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .body(formData)
                .retrieve()
                .body(Map.class);

        return (String) response.get("access_token");

    }

}
