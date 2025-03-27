import {AuthConfig} from 'angular-oauth2-oidc';

export const authConfig: AuthConfig = {
  issuer: 'http://localhost:8080/realms/helloworld-realm',
  redirectUri: window.location.origin,
  clientId: 'helloworld-client',
  responseType: 'code',
  strictDiscoveryDocumentValidation: false,
  scope: 'openid profile email offline_access',
}