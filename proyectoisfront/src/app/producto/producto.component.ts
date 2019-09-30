import { Component, OnInit, Input } from '@angular/core';
import { IsapiService } from '../shared/isapi.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-producto',
  templateUrl: './producto.component.html',
  styleUrls: ['./producto.component.css']
})
export class ProductoComponent implements OnInit {
  @Input() public idAnimal : number
  

  producto
  id


  constructor(private apiService : IsapiService, private actRoute : ActivatedRoute, private router : Router) { 
    //seteamos id como el parametro que se recibe /animales/detalleAninal;id={id}
    this.id = this.actRoute.snapshot.paramMap.get('id');
    //creamos una variable que se llama animal y obtenemos el detalle del animal por medio del metodo
    var producto = this.findProductoById()
    //igualamos la variable this.animal con animal (esto nos asegura que no va a estar undefined)
    this.producto = producto
  }

  ngOnInit() {
    
  }

  findProductoById(){
    return this.apiService.getProducto(this.id).subscribe((data) => {
      console.log(data);
      this.producto = data;
    })
  }

}
