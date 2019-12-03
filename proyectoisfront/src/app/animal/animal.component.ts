import { Component, OnInit, Input } from '@angular/core';
import { IsapiService } from '../shared/isapi.service'
import { ActivatedRoute, Router, ParamMap } from '@angular/router';
import { Animal } from '../shared/models/animal';
import { Sponsor } from '../shared/models/sponsor';
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
  id : number;

  sponsors : Sponsor[];

  //Se inyecta la dependencia de IsapiService, y ActivatedRoute para obtener los parametros de la URL
  constructor(private apiService : IsapiService, private actRoute : ActivatedRoute, private router : Router) { 
    //seteamos id como el parametro que se recibe /animales/detalleAninal;id={id}
  
    this.animal = new Animal(0,"",0,0,"","",0,0,"")

  }

  ngOnInit() {

    this.actRoute.params.subscribe(params =>{
      let id = +params['id'];
    }
    );
    this.actRoute.paramMap.subscribe ((params : ParamMap)=> {
        this.apiService.getAnimalById(parseInt(params.get('id'))).subscribe((animal : Animal) =>{
          console.log(animal);
          this.animal = animal
        }
        )

        this.apiService.getSponsorsForAnimal(parseInt(params.get('id'))).subscribe((sponsors: Sponsor[]) => {
          console.log("Sponsors: ", sponsors);
          this.sponsors = sponsors;
        })
      });
      

    
    }


}
