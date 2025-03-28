import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ApiService } from './../../services/api.service';
import { OAuthService } from 'angular-oauth2-oidc';
import {authConfig} from "./../../auth.config";

@Component({
  selector: 'home',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {

  message: any;
  
    constructor(private service: ApiService, private oauthService: OAuthService) {
      this.configure();
    }
  
    ngOnInit(): void {
      let response = this.service.getMessage();
      response.subscribe((data)=>{      
        this.message = data
      });
    }
  
    private configure() {
      this.oauthService.configure(authConfig);
      this.oauthService.loadDiscoveryDocumentAndTryLogin();
    }
  
    login() {
      this.oauthService.initCodeFlow();
    }
  
    logout() {
      this.oauthService.logOut();
    }

}
