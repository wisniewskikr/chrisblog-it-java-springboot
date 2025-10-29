package com.example.interceptor;

import java.io.IOException;
import com.example.service.KeycloakService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class JwtInterceptor implements ClientHttpRequestInterceptor {

    private final KeycloakService keycloakService;

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {

        request.getHeaders().setBearerAuth(keycloakService.getAccessTokenForRole("ADMIN"));
        return execution.execute(request, body);

    }
    
}