import { Component, OnInit } from '@angular/core';
import { ApiService } from 'app/shared/services/apiservice.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {



  constructor(private apiService : ApiService) { 
    
  }

  ngOnInit() {
  }

  
  formSubmit(data){
    console.log("Se produjo un intento de inicio de sesión")
    console.log("Usuario ", data.user)
    console.log("Password ", data.pass)
    if(this.apiService.login(data.user, data.pass) == true){
      console.log("se inicio sesion!");
    }else{
      console.log("nombre de usuario o contraseña incorrectos");
    }

    console.log("EL token es ", this.apiService.auth_token);
  }
}
