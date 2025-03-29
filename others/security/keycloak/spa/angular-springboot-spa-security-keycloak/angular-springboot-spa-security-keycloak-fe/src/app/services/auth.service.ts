import { Injectable } from '@angular/core';
import { OAuthService } from 'angular-oauth2-oidc';
import { authConfig } from '../auth.config';

@Injectable({
  providedIn: 'root',
})
export class AuthService {

  constructor(private readonly oauthService: OAuthService) {
    this.configure();
  }

  private configure() {
    this.oauthService.configure(authConfig);
    this.oauthService.loadDiscoveryDocumentAndTryLogin();
  }

  login() {
    this.oauthService.initLoginFlow();
  }

  logout() {
    this.oauthService.logOut();
  }

  get accessToken(): string {
    this.oauthService.getIdentityClaims()
    return this.oauthService.getAccessToken();
  }

  get isLoggedIn(): boolean {
    return this.oauthService.hasValidAccessToken();
  }

  get userName() : string {
    const claims = this.oauthService.getIdentityClaims();
    return claims?.['name'];
  }

}
