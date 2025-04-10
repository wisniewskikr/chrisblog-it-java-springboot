import {AuthConfig} from 'angular-oauth2-oidc';

export const authConfig: AuthConfig = {
  issuer: 'http://keycloak:8080/realms/helloworld-realm',
  redirectUri: 'http://localhost:4200/',
  clientId: 'helloworld-client',
  responseType: 'code',
  strictDiscoveryDocumentValidation: false,
  scope: 'openid profile email offline_access',
  requireHttps: false
}