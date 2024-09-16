import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError, throwError, Observable } from 'rxjs';
import { HelloWorldDto } from '../../dtos/hello-world.dto';
import { map } from 'rxjs/operators';
import { environment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private baseUrl = environment.apiUrl;

  constructor(private http: HttpClient) {}

  getMessage(): Observable<HelloWorldDto> {
    return this.http.get<any>(`${this.baseUrl}/message/1`)
          .pipe(
            map(data => new HelloWorldDto(data.id, data.text, data.portBe)),
            catchError((error) => {
              return throwError(() => error);
            })
          );
  }

}