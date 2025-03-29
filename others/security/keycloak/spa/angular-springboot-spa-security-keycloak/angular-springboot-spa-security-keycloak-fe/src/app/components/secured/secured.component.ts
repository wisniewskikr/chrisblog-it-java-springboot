import { Component, OnInit } from '@angular/core';
import { ApiService } from './../../services/api.service';
import { RouterLink } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-secured',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './secured.component.html',
  styleUrl: './secured.component.css'
})
export class SecuredComponent implements OnInit {

      message: any;
    
      constructor(private readonly service: ApiService, private readonly authService: AuthService) {}
    
      ngOnInit(): void {
        let response = this.service.getMessageSecured();
        response.subscribe((data)=>{      
          this.message = data
        });
      }
    
      login() {
        this.authService.login();
      }
    
      logout() {
        this.authService.logout();
      }

}
