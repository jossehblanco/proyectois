import { Component, OnInit } from '@angular/core';
import {IsapiService} from '../shared/isapi.service'
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']

})
export class RegisterComponent implements OnInit {

  constructor(private apiService : IsapiService) { }

  ngOnInit() {
  }

  onClickSubmit(data) {
  	this.apiService.newuser(data.username, data.pwd).subscribe((response) => {
  		console.log(response);
  		alert("¡Se creo un nuevo usuario!"); 

  	})
      
   }

}
