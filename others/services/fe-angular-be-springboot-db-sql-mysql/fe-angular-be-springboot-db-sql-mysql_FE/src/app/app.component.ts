import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ApiService } from './services/api.service';
import { HelloWorldDto } from './dtos/HelloWorldDto';
import { UuidService } from './services/uuid.service';

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

  constructor(private apiService: ApiService, private uuidSevice: UuidService) {}

  ngOnInit(): void {
    this.idFe = this.uuidSevice.getUUID();
    this.portFe = window.location.port;

    let response = this.apiService.getMessage();
    response.subscribe((helloWorldDto: HelloWorldDto)=>{      
      this.message = helloWorldDto.text;
      this.idBe = helloWorldDto.idBe;
      this.portBe = helloWorldDto.portBe;
    });
  }
  
}
