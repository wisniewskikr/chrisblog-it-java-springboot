import { ApplicationConfig, importProvidersFrom } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideHttpClient, withFetch, withInterceptorsFromDi } from '@angular/common/http';
import { OAuthModule, provideOAuthClient } from 'angular-oauth2-oidc';

export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes), 
    provideHttpClient(withFetch()),
    provideOAuthClient(),
    provideHttpClient(withInterceptorsFromDi()),
    importProvidersFrom(OAuthModule.forRoot({
      resourceServer: {
        allowedUrls: ['http://localhost:9090/secured'],
        sendAccessToken: true
      }
    }))
  ]
};
