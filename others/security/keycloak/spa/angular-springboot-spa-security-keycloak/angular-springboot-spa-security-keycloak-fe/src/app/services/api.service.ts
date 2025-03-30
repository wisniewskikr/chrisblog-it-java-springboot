import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError, throwError } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  URL_PUBLIC = environment.API_BE_PUBLIC_URL;
  URL_SECURED = environment.API_BE_SECURED_URL;

  constructor(private readonly http: HttpClient) {}

  getMessagePublic() {

    return this.http.get(this.URL_PUBLIC, { responseType: 'text' })
          .pipe(
            catchError((error) => {
              return throwError(() => error);
            })
          );

  }

  getMessageSecured() {

    return this.http.get(this.URL_SECURED, { responseType: 'text' })
          .pipe(
            catchError((error) => {
              return throwError(() => error);
            })
          );

  }

}