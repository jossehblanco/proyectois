import { Component, OnInit } from '@angular/core';
import {IsapiService} from '../shared/isapi.service'
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private apiService: IsapiService, private router : Router) { }

  ngOnInit() {
  }


  onClickSubmit(data) {

  	this.apiService.login(data.username, data.pwd).subscribe((response) => {
  		this.apiService.auth_token = response;
      console.log(response);
      this.router.navigate(['home']);
  	})
  	/*this.apiService.newuser(data.username, data.pwd).subscribe((response) => {
  		console.log(response);
  		alert("¡Se creo un nuevo usuario!"); 
  	})*/
      
   }

}
