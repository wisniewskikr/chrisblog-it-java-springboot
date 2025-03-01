package com.example.users;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

import java.util.Collection;

public class CustomOidcUser extends DefaultOidcUser {

    public CustomOidcUser(Collection<? extends GrantedAuthority> authorities, OidcUser oidcUser) {
        super(authorities, oidcUser.getIdToken(), oidcUser.getUserInfo());
    }
}