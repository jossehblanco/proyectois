import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AnimalesComponent} from './animales/animales.component'
import { AnimalComponent } from './animal/animal.component';
import { ProveedorComponent } from './proveedor/proveedor.component';
import { ProveedoresComponent } from './proveedores/proveedores.component';
import { ProductoComponent } from './producto/producto.component';
import { ProductosComponent } from './productos/productos.component';
import { AppComponent } from './app.component';

const routes: Routes = [
  {path : '',children : [
    {path:'animales',
    component : AnimalesComponent, 
      children:[
        {path: ':id', component : AnimalComponent}
      ]
    },
    {path:'productos',
    component : ProductosComponent, 
      children:[
        {path: ':id', component : ProductoComponent}
      ]
    }
  ]

  },

  //{path: 'productos', component: ProductosComponent},
  //{path:'animales/detalleanimal', component: AnimalComponent},
  //{path:'productos/detalleproducto', component: ProductoComponent},
  //{path:'proveedores', component: ProveedoresComponent},
  //{path:'proveedores/detalleproveedor', component: ProveedorComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
