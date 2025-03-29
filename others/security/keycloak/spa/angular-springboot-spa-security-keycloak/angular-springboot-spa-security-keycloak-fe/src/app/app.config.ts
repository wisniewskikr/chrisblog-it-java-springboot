import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideHttpClient, withFetch } from '@angular/common/http';
import { provideOAuthClient } from 'angular-oauth2-oidc';

export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes), 
    provideHttpClient(withFetch()),
    provideOAuthClient()
    // importProvidersFrom(OAuthModule.forRoot({
    //   resourceServer: {
    //     allowedUrls: ['http://localhost:9090'],
    //     sendAccessToken: true
    //   }
    // }))
  ]
};
