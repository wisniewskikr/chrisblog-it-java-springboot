package com.example.configs;

import feign.Feign;
import feign.Retryer;
import feign.hc5.ApacheHttp5Client;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.client5.http.io.HttpClientConnectionManager;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactoryBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.util.ResourceUtils;
import org.apache.http.ssl.SSLContextBuilder;

import javax.net.ssl.SSLContext;

public class FeignConfig {
	
	@Value("${truststore.path}")
	private String truststorePath;
	
	@Value("${truststore.password}")
	private String truststorePassword;

    @Bean
    public Feign.Builder feignBuilder() throws Exception {
    	
        SSLContext sslContext = getSSLContext();
        SSLConnectionSocketFactory sslConnectionSocketFactory = SSLConnectionSocketFactoryBuilder.create().setSslContext(sslContext).build();
        HttpClientConnectionManager connectionManager = PoolingHttpClientConnectionManagerBuilder.create().setSSLSocketFactory(sslConnectionSocketFactory).build();
        
        return Feign.builder()
            .retryer(Retryer.NEVER_RETRY)
            .client(new ApacheHttp5Client(HttpClients.custom()
                .setConnectionManager(connectionManager)
                .build()));
        
    }

    private SSLContext getSSLContext() throws Exception {
        
    	return new SSLContextBuilder()
    		      .loadTrustMaterial(ResourceUtils.getFile(truststorePath), truststorePassword.toCharArray())
    		      .build();
    	
    }
}
