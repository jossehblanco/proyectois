import { Component, OnInit } from '@angular/core';
import { IsapiService } from '../isapi.service'
@Component({
  selector: 'app-animales',
  templateUrl: './animales.component.html',
  styleUrls: ['./animales.component.css']
})
export class AnimalesComponent implements OnInit {
  animales;

  constructor(private apiService: IsapiService) { }

  ngOnInit() {

    this.apiService.getAnimales().subscribe((data)=>{
      console.log(data);
      this.animales = data;
   });
  }

}
