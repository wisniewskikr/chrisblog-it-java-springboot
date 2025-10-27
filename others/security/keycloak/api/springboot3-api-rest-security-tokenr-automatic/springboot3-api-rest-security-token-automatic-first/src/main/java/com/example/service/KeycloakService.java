package com.example.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Service
public class KeycloakService {

    @Value("${keycloak.credentials.user}")
    private String keycloakUser;

    @Value("${keycloak.credentials.password}")
    private String keycloakPassword;

    private final RestClient restClientKeycloak;

    public KeycloakService(RestClient.Builder restClientBuilder,
                           @Value("${api.keycloak.url}") String apiKeycloakUrl) {
        this.restClientKeycloak = restClientBuilder
                .baseUrl(apiKeycloakUrl)
                .build();
    }

    public String getAccessToken() {

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("grant_type", "password");
        formData.add("client_id", "helloworld-client");
        formData.add("username", keycloakUser);
        formData.add("password", keycloakPassword);

        // Send POST request
        Map response = restClientKeycloak.post()
                .uri("/realms/helloworld-realm/protocol/openid-connect/token")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .body(formData)
                .retrieve()
                .body(Map.class);

        return (String) response.get("access_token");

    }

}
