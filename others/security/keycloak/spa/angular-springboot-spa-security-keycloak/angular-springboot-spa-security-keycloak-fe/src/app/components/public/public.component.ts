import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-public',
  standalone: true,
  imports: [],
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
