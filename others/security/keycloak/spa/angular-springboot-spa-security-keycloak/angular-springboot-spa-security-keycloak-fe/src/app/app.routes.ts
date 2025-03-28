import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { PublicComponent } from './components/public/public.component';
import { SecuredComponent } from './components/secured/secured.component';

export const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'public', component: PublicComponent },
    { path: 'secured', component: SecuredComponent }
];
