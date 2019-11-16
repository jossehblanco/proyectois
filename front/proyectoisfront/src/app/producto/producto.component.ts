import { Component, OnInit, Input } from '@angular/core';
import { IsapiService } from '../shared/isapi.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Producto } from '../shared/models/producto';

@Component({
  selector: 'app-producto',
  templateUrl: './producto.component.html',
  styleUrls: ['./producto.component.css']
})
export class ProductoComponent implements OnInit {
  @Input() public idAnimal : number
  

  producto : Producto
  id : any


  constructor(private apiService : IsapiService, private actRoute : ActivatedRoute, private router : Router) { 
    //seteamos id como el parametro que se recibe /animales/detalleAninal;id={id}
    this.id = this.actRoute.snapshot.paramMap.get('id');
    this.producto = new Producto(0,"",0,0,0,"")
  }

  ngOnInit() {
    this.apiService.getProductoById(this.id).subscribe((producto : Producto) => {
      this.producto = producto
    })
  }

}
