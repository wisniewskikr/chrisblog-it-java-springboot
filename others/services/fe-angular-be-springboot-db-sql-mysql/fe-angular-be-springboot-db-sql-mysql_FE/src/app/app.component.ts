import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ApiService } from './services/api.service';
import { HelloWorldDto } from './dtos/HelloWorldDto';
import { v4 as uuidv4 } from 'uuid';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{

  message: string = "";
  idBe: string = "";
  portBe: string = "";
  idFe: string = "";
  portFe: string = "";

  constructor(private service: ApiService) {}

  ngOnInit(): void {
    this.idFe = uuidv4();
    this.portFe = window.location.port;

    let response = this.service.getMessage();
    response.subscribe((helloWorldDto: HelloWorldDto)=>{      
      this.message = helloWorldDto.text;
      this.idBe = helloWorldDto.idBe;
      this.portBe = helloWorldDto.portBe;
    });
  }
  
}
