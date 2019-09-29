import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AnimalesComponent} from './animales/animales.component'
import { AnimalComponent } from './animal/animal.component';

const routes: Routes = [
  {path:'animales', component: AnimalesComponent},
  {path:'animales/detalleanimal', component: AnimalComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
