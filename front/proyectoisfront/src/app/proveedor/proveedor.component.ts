import { Component, OnInit, Input } from '@angular/core';
import { IsapiService } from '../shared/isapi.service'
import { ActivatedRoute, Router } from '@angular/router';
import { Proveedor } from '../shared/models/proveedor';


@Component({
  selector: 'app-proveedor',
  templateUrl: './proveedor.component.html',
  styleUrls: ['./proveedor.component.css']
})
export class ProveedorComponent implements OnInit {
  @Input() public idProveedor : number

  proveedor : Proveedor
  id : any
  constructor(private apiService : IsapiService, private actRoute : ActivatedRoute, private router : Router) { 
    this.id = this.actRoute.snapshot.paramMap.get('id');

    this.proveedor = new Proveedor(0, "","", 0)

  }

  ngOnInit() {
    this.apiService.getProveedorById(this.id).subscribe((proveedor: Proveedor) => {
      this.proveedor = proveedor
      console.log(this.proveedor.descripcion)
    })
  }

}