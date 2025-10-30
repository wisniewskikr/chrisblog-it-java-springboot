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

    public static final String ROLES = "roles";
    public static final String PASSWORD = "password";

    @Value("${keycloak.administrator.username}")
    private String keycloakAdminUsername;

    @Value("${keycloak.administrator.password}")
    private String keycloakAdminPassword;

    @Value("${keycloak.administrator.role}")
    private String keycloakAdminRole;

    @Value("${keycloak.resource-id}")
    private String keycloakResourceId;

    @Value("${keycloak.realm}")
    private String keycloakRealm;

    private final RestClient restClientKeycloak;

    public KeycloakService(RestClient.Builder restClientBuilder,
                           @Value("${keycloak.url}") String keycloakUrl) {
        this.restClientKeycloak = restClientBuilder
                .baseUrl(keycloakUrl)
                .build();
    }

    public String getAdminAccessToken() {

        String token = null;

        token = getCurrentAccessTokenIfAdmin();
        if (token == null) {
            log.info("Switch role. Current user is not in ADMIN role");
            token = getNewAdminAccessToken();
        } else {
            log.info("No switch role. Current user is in ADMIN role");
        }

        return token;

    }

    private String getCurrentAccessTokenIfAdmin() {

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

            if (resourceAccess.get(keycloakResourceId) == null) {
                return token;
            }
            resource = (Map<String, Object>) resourceAccess.get(keycloakResourceId);

            resourceRoles = (Collection<String>) resource.get(ROLES);

            if (resourceRoles.contains(keycloakAdminRole)) {
                token = jwt.getTokenValue();
            }

        }

        return token;

    }

    private String getNewAdminAccessToken() {

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("grant_type", PASSWORD);
        formData.add("client_id", keycloakResourceId);
        formData.add("username", keycloakAdminUsername);
        formData.add("password", keycloakAdminPassword);

        Map response = restClientKeycloak.post()
                .uri("/realms/" + keycloakRealm + "/protocol/openid-connect/token")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .body(formData)
                .retrieve()
                .body(Map.class);

        return (String) response.get("access_token");

    }

}
