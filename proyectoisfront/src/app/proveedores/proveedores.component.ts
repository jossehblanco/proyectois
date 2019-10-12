import { Component, OnInit } from '@angular/core';
import { IsapiService } from '../shared/isapi.service';
import { Proveedor } from '../shared/models/proveedor';

@Component({
  selector: 'app-proveedores',
  templateUrl: './proveedores.component.html',
  styleUrls: ['./proveedores.component.css']
})
export class ProveedoresComponent implements OnInit {

  constructor(private apiService: IsapiService) { 
    this.proveedores = []

  }

  proveedores : Proveedor[]

  

  ngOnInit() {
    this.apiService.listProveedores().subscribe((proveedores: Proveedor[]) => {
      this.proveedores = proveedores
    })
  }

}
