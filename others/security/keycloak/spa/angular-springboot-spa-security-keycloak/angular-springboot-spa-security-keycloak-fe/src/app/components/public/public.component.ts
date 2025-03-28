import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../services/api.service';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-public',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './public.component.html',
  styleUrl: './public.component.css'
})
export class PublicComponent implements OnInit {

  message: any;

  constructor(private service: ApiService) {}

  ngOnInit(): void {
    let response = this.service.getMessagePublic();
    response.subscribe((data)=>{      
      this.message = data
    });
  }

}
