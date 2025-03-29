import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'home',
  standalone: true,
  imports: [RouterLink, CommonModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {

  showLogout: boolean = false;

  constructor(private readonly route: ActivatedRoute, private readonly authService: AuthService) {

    this.route.queryParamMap.subscribe(params => {
      const login = params.get('login');
      if (login) {
        this.authService.login();
      }
    });

  }

  ngOnInit(): void {

    if (this.authService.isLoggedIn) {
      this.showLogout = true;
    }
    
  }

  logout() {
    this.authService.logout();
  }

}
