import { Component, OnInit } from '@angular/core';
import { ApiService } from './../../services/api.service';
import { Router, RouterLink } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-secured',
  standalone: true,
  imports: [RouterLink, CommonModule],
  templateUrl: './secured.component.html',
  styleUrl: './secured.component.css'
})
export class SecuredComponent implements OnInit {

      message: any;
      isLoggedIn: boolean = false;
      userName: string = '';
    
      constructor(private readonly service: ApiService, private readonly authService: AuthService, private readonly router: Router) {}
    
      ngOnInit(): void {

        this.isLoggedIn = true;
        this.userName = this.authService.userName;

        let response = this.service.getMessageSecured();
        response.subscribe((data)=>{      
          this.message = data
        });
        
      }
    
      logout() {
        this.authService.logout();
      }

}
