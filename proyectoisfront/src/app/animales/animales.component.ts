import { Component, OnInit } from '@angular/core';
import { IsapiService } from '../shared/isapi.service'
import { Animal } from '../shared/models/animal';
@Component({
  selector: 'app-animales',
  templateUrl: './animales.component.html',
  styleUrls: ['./animales.component.css']
})
export class AnimalesComponent implements OnInit {
  
  //se inyecta la dependencia de IsapiService
  constructor(private apiService: IsapiService) {
    this.animales = [];

   }


  //Se declara una lista de animales tipo any
   animales : Animal[] 

   
   //al iniciarse el componente se mandará a llamar findAllAnimales
  ngOnInit() {
   
    this.apiService.listAnimales().subscribe((animales: Animal[]) => {
      console.log(animales)
      this.animales = animales
    })
  }

}
