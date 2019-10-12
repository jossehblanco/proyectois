import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AnimalesComponent } from './animales/animales.component';
import { HttpClientModule }  from '@angular/common/http';
import {IsapiService} from './shared/isapi.service';
import { AnimalComponent } from './animal/animal.component';
import { ProveedoresComponent } from './proveedores/proveedores.component';
import { ProveedorComponent } from './proveedor/proveedor.component'
import { ProductosComponent } from './productos/productos.component';
import { ProductoComponent } from './producto/producto.component'


@NgModule({
  declarations: [
    AppComponent,
    AnimalesComponent,
    AnimalComponent,
    ProveedoresComponent,
    ProveedorComponent,
    ProductosComponent,
    ProductoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [IsapiService],
  bootstrap: [AppComponent]
})
export class AppModule { }
