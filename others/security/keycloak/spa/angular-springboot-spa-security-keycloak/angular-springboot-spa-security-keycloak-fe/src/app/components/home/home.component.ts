import { Component } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { AuthService } from '../../services/auth.service';
@Component({
  selector: 'home',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

  constructor(private readonly route: ActivatedRoute, private readonly authService: AuthService) {

    this.route.queryParamMap.subscribe(params => {
      const login = params.get('login');
      if (login) {
        this.authService.login();
      }
    });

  }

}
