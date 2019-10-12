import { Component, OnInit } from '@angular/core';
import { IsapiService } from '../shared/isapi.service';
import { Producto } from '../shared/models/producto';

@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.css']
})
export class ProductosComponent implements OnInit {


  //se inyecta la dependencia de IsapiService
  constructor(private apiService: IsapiService) { 
    this.productos = []
  }



   productos : Producto[]

   
   
  ngOnInit() {
    this.apiService.listProductos().subscribe((productos: Producto[]) => {
      this.productos = productos
    })
  }



  
}
