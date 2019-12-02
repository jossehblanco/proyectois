import { Component, OnInit } from '@angular/core';
import { ApiService } from 'app/shared/services/apiservice.service';
 
@Component({
    selector: 'app-landing',
    templateUrl: './landing.component.html',
    styleUrls: ['./landing.component.scss']
})

export class LandingComponent implements OnInit {
  focus: any;
  focus1: any;

  constructor(private apiService : ApiService) { }

  ngOnInit() {
    console.log("Se inicializo landing");
    console.log(this.apiService.auth_token);
  }

}
