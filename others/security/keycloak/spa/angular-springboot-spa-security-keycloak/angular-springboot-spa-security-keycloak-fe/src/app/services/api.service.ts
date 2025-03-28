import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, throwError } from 'rxjs';
import { environment } from '../../environments/environment';
import { OAuthService } from 'angular-oauth2-oidc';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  URL_PUBLIC = environment.API_BE_PUBLIC_URL;
  URL_SECURED = environment.API_BE_SECURED_URL;

  constructor(private http: HttpClient, private oauthService: OAuthService) {}

  getMessagePublic() {

    return this.http.get(this.URL_PUBLIC, { responseType: 'text' })
          .pipe(
            catchError((error) => {
              return throwError(() => error);
            })
          );

  }

  getMessageSecured() {

    // TODO: make it authomatic
    const headers = new HttpHeaders({
      'Content-Type': 'text/plain; charset=utf-8',
      'Authorization': 'Bearer ' + this.oauthService.getAccessToken()
    });

    return this.http.get(this.URL_SECURED, { headers, responseType: 'text' })
          .pipe(
            catchError((error) => {
              return throwError(() => error);
            })
          );

  }

}