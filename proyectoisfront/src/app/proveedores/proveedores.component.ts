import { Component, OnInit } from '@angular/core';
import { IsapiService } from '../shared/isapi.service';

@Component({
  selector: 'app-proveedores',
  templateUrl: './proveedores.component.html',
  styleUrls: ['./proveedores.component.css']
})
export class ProveedoresComponent implements OnInit {

  constructor(private apiService: IsapiService) { }

  listProveedores : any=[];

  ngOnInit() {
    this.findAllProveedores();
  }

  findAllProveedores(){
    return this.apiService.getProveedores().subscribe((data: {}) => {
      console.log(data);
      this.listProveedores = data;
    })
  }

}
