import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ApiService } from '../../services/api/api.service';
import { UuidService } from '../../services/uuid/uuid.service';
import { HelloWorldDto } from '../../dtos/hello-world.dto';


@Component({
  selector: 'hello-world',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './hello-world.component.html',
  styleUrl: './hello-world.component.css'
})
export class HelloWorldComponent implements OnInit{

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
