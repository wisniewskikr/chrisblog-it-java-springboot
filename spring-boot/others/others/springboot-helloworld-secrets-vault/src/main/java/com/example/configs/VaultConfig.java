package com.example.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.config.AbstractVaultConfiguration;

/**
 * Example class to configure Vault beans using AbstractVaultConfiguration
 *
 */
@Configuration
public class VaultConfig extends AbstractVaultConfiguration {
	
	@Value("${vault.host}")
	private String vaultHost;
	
	@Value("${vault.port}")
	private int vaultPort;
	
	@Value("${vault.token}")
	private String vaultToken;

    @Override
    public ClientAuthentication clientAuthentication() {
        return new TokenAuthentication(vaultToken);
    }

    @Override
    public VaultEndpoint vaultEndpoint() {
        return VaultEndpoint.create(vaultHost, vaultPort);
    }

}