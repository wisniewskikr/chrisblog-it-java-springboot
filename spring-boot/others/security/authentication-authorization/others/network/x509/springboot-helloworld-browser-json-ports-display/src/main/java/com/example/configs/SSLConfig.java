package com.example.configs;

import java.io.FileNotFoundException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.util.ResourceUtils;

@Configuration
public class SSLConfig {
	
    @Autowired
    private Environment env;

    @PostConstruct
    private void configureSSL() throws FileNotFoundException {
    	// set to TLSv1.1 or TLSv1.2
    	// System.setProperty("https.protocols", "TLSv1.1");

    	System.setProperty("javax.net.ssl.trustStore", ResourceUtils.getFile(env.getProperty("truststore.path")).getAbsolutePath()); 
    	System.setProperty("javax.net.ssl.trustStorePassword", env.getProperty("truststore.password"));
    }
}
