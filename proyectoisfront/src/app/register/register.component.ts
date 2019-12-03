import { Component, OnInit } from '@angular/core';
import {IsapiService} from '../shared/isapi.service'
import { Router } from '@angular/router';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']

})
export class RegisterComponent implements OnInit {

  constructor(private apiService : IsapiService, private router : Router) { }

  ngOnInit() {
  }

  onClickSubmit(data) {
  	this.apiService.newuser(data.username, data.pwd).subscribe((response) => {
      console.log(response);
      this.router.navigate(['login']);
  		alert("¡Se creo un nuevo usuario!"); 
  	})
      
   }

}