import { Component, OnInit, Input } from '@angular/core';
import { IsapiService } from '../shared/isapi.service'
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-proveedor',
  templateUrl: './proveedor.component.html',
  styleUrls: ['./proveedor.component.css']
})
export class ProveedorComponent implements OnInit {
  @Input() public idProveedor : number

  proveedor
  id;
  constructor(private apiService : IsapiService, private actRoute : ActivatedRoute, private router : Router) { 
    this.id = this.actRoute.snapshot.paramMap.get('id');
    var proveedor = this.findProveedorById();
    //igualamos la variable this.animal con animal (esto nos asegura que no va a estar undefined)
    this.proveedor = proveedor
  }

  ngOnInit() {

  }

  findProveedorById(){
    return this.apiService.getProveedor(this.id).subscribe((data) => {
      console.log(data);
      this.proveedor = data;
    })
  }
}