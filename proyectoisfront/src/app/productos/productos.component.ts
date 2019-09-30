import { Component, OnInit } from '@angular/core';
import { IsapiService } from '../shared/isapi.service';

@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.css']
})
export class ProductosComponent implements OnInit {


  //se inyecta la dependencia de IsapiService
  constructor(private apiService: IsapiService) { }


  //Se declara una lista de animales tipo any
   listProductos  : any = [];

   
   //al iniciarse el componente se mandará a llamar findAllAnimales
  ngOnInit() {
    this.findAllProductos() 
  }


  //Declarando funcion para obtener lista de Animales y se suscribe al observer
  findAllProductos(){
    return this.apiService.getProductos().subscribe((data: {}) => {
      console.log(data);
      this.listProductos = data;
    })
  }

  
}
