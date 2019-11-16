import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { LandingComponent } from './landing/landing.component';
import { ProfileComponent } from './profile/profile.component';
import { SignupComponent } from './signup/signup.component';
import { TiendaComponent } from './tienda/tienda.component';
import { SponsorsComponent } from './sponsors/sponsors.component';
import { LoginComponent } from './login/login.component';
import { ApiService } from 'app/shared/services/apiservice.service';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        NgbModule,
        HttpClientModule
    ],
    declarations: [
        LandingComponent,
        SignupComponent,
        ProfileComponent,
        TiendaComponent,
        SponsorsComponent,
        LoginComponent
    ],
    providers :[
        ApiService
    ]
})
export class ExamplesModule { }
