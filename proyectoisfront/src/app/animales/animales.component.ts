import { Component, OnInit } from '@angular/core';
import { IsapiService } from '../shared/isapi.service'
@Component({
  selector: 'app-animales',
  templateUrl: './animales.component.html',
  styleUrls: ['./animales.component.css']
})
export class AnimalesComponent implements OnInit {
  
  //se inyecta la dependencia de IsapiService
  constructor(private apiService: IsapiService) { }


  //Se declara una lista de animales tipo any
   listAnimales  : any= [];

   
   //al iniciarse el componente se mandará a llamar findAllAnimales
  ngOnInit() {
    this.findAllAnimales() 
  }


  //Declarando funcion para obtener lista de Animales y se suscribe al observer
  findAllAnimales(){
    return this.apiService.getAnimales().subscribe((data: {}) => {
      console.log(data);
      this.listAnimales = data;
    })
  }

}
