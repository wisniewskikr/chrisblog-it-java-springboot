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

    @Value("${keycloak.administrator.username}")
    private String keycloakUsername;

    @Value("${keycloak.administrator.password}")
    private String keycloakPassword;

    private final RestClient restClientKeycloak;

    public KeycloakService(RestClient.Builder restClientBuilder,
                           @Value("${keycloak.url}") String keycloakUrl) {
        this.restClientKeycloak = restClientBuilder
                .baseUrl(keycloakUrl)
                .build();
    }

    public String getAccessToken() {

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
