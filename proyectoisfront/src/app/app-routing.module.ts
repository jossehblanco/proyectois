import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AnimalesComponent} from './animales/animales.component'
import { AnimalComponent } from './animal/animal.component';
import { ProveedorComponent } from './proveedor/proveedor.component';
import { ProveedoresComponent } from './proveedores/proveedores.component';

const routes: Routes = [
  {path:'animales', component: AnimalesComponent},
  {path:'animales/detalleanimal', component: AnimalComponent},
  {path:'proveedores', component: ProveedorComponent},
  {path:'proveedor/detalleproveedor', component: ProveedoresComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
