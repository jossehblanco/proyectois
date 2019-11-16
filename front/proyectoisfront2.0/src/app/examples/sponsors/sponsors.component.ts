import { Component, OnInit } from '@angular/core';
import { Animal } from 'app/shared/models/animal';
import { ApiService } from 'app/shared/services/apiservice.service';


@Component({
  selector: 'app-sponsors',
  templateUrl: './sponsors.component.html',
  styleUrls: ['./sponsors.component.scss']
})
export class SponsorsComponent implements OnInit {
  animales : Animal[]
  constructor(private apiService : ApiService) { 
    this.animales = []
  }

  ngOnInit() {
    this.apiService.listAnimales().subscribe((animales : Animal[]) => {
      console.log(animales)
      this.animales = animales
    })
  }

}
