package com.example.service;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponseSupport;

import com.example.secrets.CredentialsSecret;

@Service
public class CredentialsService {
	
	@Value("${vault.target}")
	private String vaultTarget;
	
	private VaultTemplate vaultTemplate;

	@Autowired	
    public CredentialsService(VaultTemplate vaultTemplate) {
		this.vaultTemplate = vaultTemplate;
	}

	public void saveCredentials(CredentialsSecret credentials) throws URISyntaxException {
        vaultTemplate.write(vaultTarget, credentials);    }


    public CredentialsSecret findCredentials() throws URISyntaxException {

        VaultResponseSupport<CredentialsSecret> response = vaultTemplate.read(vaultTarget, CredentialsSecret.class);
        return response.getData();
    }
	
}
