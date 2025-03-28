import { Component, OnInit } from '@angular/core';
import { ApiService } from './../../services/api.service';
import { OAuthService } from 'angular-oauth2-oidc';
import {authConfig} from "./../../auth.config";

@Component({
  selector: 'app-secured',
  standalone: true,
  imports: [],
  templateUrl: './secured.component.html',
  styleUrl: './secured.component.css'
})
export class SecuredComponent implements OnInit {

  message: any;
    
      constructor(private service: ApiService, private oauthService: OAuthService) {
        this.configure();
      }
    
      ngOnInit(): void {
        let response = this.service.getMessageSecured();
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
