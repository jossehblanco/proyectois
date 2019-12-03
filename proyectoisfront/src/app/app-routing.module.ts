import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AnimalesComponent} from './animales/animales.component'
import { AnimalComponent } from './animal/animal.component';
import { ProveedorComponent } from './proveedor/proveedor.component';
import { ProveedoresComponent } from './proveedores/proveedores.component';
import { ProductoComponent } from './producto/producto.component';
import { ProductosComponent } from './productos/productos.component';
import { AppComponent } from './app.component';
import {HomeComponent } from './home/home.component'
import {LoginComponent} from './login/login.component'
import {RegisterComponent} from './register/register.component'
import {LandingComponent} from './landing/landing.component'

const routes: Routes = [
  {path : '',  children : [
    {path: '', component: HomeComponent},
    ]
    },
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'home', component: LandingComponent},
  {path:'productos',
    component : ProductosComponent, 
      children:[
        {path: ':id', component : ProductoComponent}
      ]},
      {path:'animales',
    component : AnimalesComponent, 
      children:[
        {path: ':id', component : AnimalComponent}
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
