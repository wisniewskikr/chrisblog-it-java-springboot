import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ApiService } from '../../services/api/api.service';
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
  portBe: string = "";
  portFe: string = "";

  constructor(private apiService: ApiService) {}

  ngOnInit(): void {

    this.portFe = window.location.port;

    let response = this.apiService.getMessage();
    response.subscribe((helloWorldDto: HelloWorldDto)=>{      
      this.message = helloWorldDto.text;
      this.portBe = helloWorldDto.portBe;
    });

  }
  
}
