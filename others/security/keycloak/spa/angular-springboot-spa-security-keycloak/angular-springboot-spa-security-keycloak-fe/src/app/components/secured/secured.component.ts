import { Component, OnInit } from '@angular/core';
import { ApiService } from './../../services/api.service';
import { Router, RouterLink } from '@angular/router';
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
    
      constructor(private readonly service: ApiService, private readonly authService: AuthService, private readonly router: Router) {}
    
      ngOnInit(): void {

        if (!this.authService.isLoggedIn) {
          this.router.navigate([''], {
            queryParams: { login: true }
          });
          return;
        }

        let response = this.service.getMessageSecured();
        response.subscribe((data)=>{      
          this.message = data
        });
      }
    
      logout() {
        this.authService.logout();
      }

}
