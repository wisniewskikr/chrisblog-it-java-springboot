import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  URL = 'http://localhost:8080/';

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