import { Component, OnInit } from '@angular/core';
import { IsapiService } from '../shared/isapi.service'
import { Animal } from '../shared/models/animal';
import { DomSanitizer } from '@angular/platform-browser';
@Component({
  selector: 'app-animales',
  templateUrl: './animales.component.html',
  styleUrls: ['./animales.component.css']
})
export class AnimalesComponent implements OnInit {
  
  //se inyecta la dependencia de IsapiService
  constructor(private apiService: IsapiService, private sanitize : DomSanitizer) {
    this.animales = [];
    
   }


  //Se declara una lista de animales tipo any
   animales : Animal[] 

   
   //al iniciarse el componente se mandará a llamar findAllAnimales
  ngOnInit() {
   
    this.apiService.listAnimales().subscribe((animales: Animal[]) => {
      console.log(animales)
      this.animales = animales
      for(let animal of animales){
        this.sanitize.bypassSecurityTrustStyle('background-image: url(' + animal.url_imagen +');');
        console.log("sanitized");
      }
    })
  }

}
