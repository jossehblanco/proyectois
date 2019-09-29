import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AnimalesComponent} from './animales/animales.component'

const routes: Routes = [
  {path:'animales', component: AnimalesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
