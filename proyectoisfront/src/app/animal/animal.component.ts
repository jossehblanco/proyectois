import { Component, OnInit, Input } from '@angular/core';
import { IsapiService } from '../shared/isapi.service'
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-animal',
  templateUrl: './animal.component.html',
  styleUrls: ['./animal.component.css']
})
export class AnimalComponent implements OnInit {
  @Input() public idAnimal : number
  
  //Se declara la variable animal que contendrá el animal retornado y 
  //id que contendrá el valor que se pasará mediante la ruta
  animal
  id;

  //Se inyecta la dependencia de IsapiService, y ActivatedRoute para obtener los parametros de la URL
  constructor(private apiService : IsapiService, private actRoute : ActivatedRoute, private router : Router) { 
    //seteamos id como el parametro que se recibe /animales/detalleAninal;id={id}
    this.id = this.actRoute.snapshot.paramMap.get('id');
    //creamos una variable que se llama animal y obtenemos el detalle del animal por medio del metodo
    var animal = this.findAnimalById()
    //igualamos la variable this.animal con animal (esto nos asegura que no va a estar undefined)
    this.animal = animal
  }

  ngOnInit() {
    
  }

  findAnimalById(){
    return this.apiService.getAnimal(this.id).subscribe((data) => {
      console.log(data);
      this.animal = data;
    })
  }
}
