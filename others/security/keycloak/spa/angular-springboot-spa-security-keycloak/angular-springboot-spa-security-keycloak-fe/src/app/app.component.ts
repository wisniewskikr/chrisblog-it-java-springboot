import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ApiService } from './services/api.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{

  message: any;

  constructor(private service: ApiService) {}

  ngOnInit(): void {
    let response = this.service.getMessage();
    response.subscribe((data)=>{      
      this.message = data
    });
  }
  
}
