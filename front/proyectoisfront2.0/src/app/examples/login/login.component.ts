import { Component, OnInit } from '@angular/core';
import { ApiService } from 'app/shared/services/apiservice.service';
import {Router} from '@angular/router'
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {



  constructor(private apiService : ApiService, private router : Router) { 
    
  }

  ngOnInit() {
  }

  
  formSubmit(data){
    console.log("Se produjo un intento de inicio de sesión")
    console.log("Usuario ", data.user)
    console.log("Password ", data.pass)


    this.apiService.login(data.user, data.pass).subscribe(data => {
      this.apiService.auth_token = data;
      this.apiService.listAnimales().subscribe(data => {console.log(data)});
      this.router.navigate(['/landing'])
    })

    console.log("Inicio de sesión", this.apiService.auth_token);

  }
}
