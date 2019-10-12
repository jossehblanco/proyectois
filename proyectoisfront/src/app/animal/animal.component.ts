import { Component, OnInit, Input } from '@angular/core';
import { IsapiService } from '../shared/isapi.service'
import { ActivatedRoute, Router } from '@angular/router';
import { Animal } from '../shared/models/animal';

@Component({
  selector: 'app-animal',
  templateUrl: './animal.component.html',
  styleUrls: ['./animal.component.css']
})
export class AnimalComponent implements OnInit {
  @Input() public idAnimal : number
  
  //Se declara la variable animal que contendrá el animal retornado y 
  //id que contendrá el valor que se pasará mediante la ruta
  animal : Animal
  id;

  //Se inyecta la dependencia de IsapiService, y ActivatedRoute para obtener los parametros de la URL
  constructor(private apiService : IsapiService, private actRoute : ActivatedRoute, private router : Router) { 
    //seteamos id como el parametro que se recibe /animales/detalleAninal;id={id}
    this.id = this.actRoute.snapshot.paramMap.get('id');
    console.log(this.id)
    this.animal = new Animal(0,"",0,0,"","",0,0)

  }

  ngOnInit() {
    this.apiService.getAnimalById(this.id).subscribe((animal : Animal) =>{
      console.log(animal);
      this.animal = animal
    })
  }


}
