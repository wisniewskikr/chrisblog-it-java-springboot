import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../services/api.service';
import { RouterLink } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-public',
  standalone: true,
  imports: [RouterLink, CommonModule],
  templateUrl: './public.component.html',
  styleUrl: './public.component.css'
})
export class PublicComponent implements OnInit {

  showLogout: boolean = false;
  message: any;

  constructor(private readonly service: ApiService, private readonly authService: AuthService) {}

  ngOnInit(): void {

    if (this.authService.isLoggedIn) {
      this.showLogout = true;
    }

    let response = this.service.getMessagePublic();
    response.subscribe((data)=>{      
      this.message = data
    });

  }

  logout() {
    this.authService.logout();
  }

}
