import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError, throwError } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  URL = environment.API_BE_URL;

  constructor(private http: HttpClient) {}

  getMessage() {
    return this.http.get(this.URL, {responseType: 'text'})
          .pipe(
            catchError((error) => {
              return throwError(() => error);
            })
          );
  }

}