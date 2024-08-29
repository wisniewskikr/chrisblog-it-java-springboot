import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError, throwError, Observable } from 'rxjs';
import { HelloWorldDto } from '../dtos/HelloWorldDto';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  URL = 'http://localhost:8081/message/1';

  constructor(private http: HttpClient) {}

  getMessage(): Observable<HelloWorldDto> {
    return this.http.get<any>(this.URL)
          .pipe(
            map(data => new HelloWorldDto(data.id, data.text, data.idBe, data.portBe)),
            catchError((error) => {
              return throwError(() => error);
            })
          );
  }

}