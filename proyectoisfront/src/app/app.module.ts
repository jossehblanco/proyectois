import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatSidenavModule, MatListModule, MatIconModule, MatButtonModule, MatAutocompleteModule, MatButtonToggleModule, MatCardModule, MatCheckboxModule, MatChipsModule, MatDatepickerModule, MatDialogModule, MatDividerModule, MatExpansionModule, MatGridListModule, MatInputModule, MatMenuModule, MatNativeDateModule, MatPaginatorModule, MatProgressBarModule, MatProgressSpinnerModule, MatRadioModule, MatRippleModule, MatSelectModule, MatSliderModule, MatSlideToggleModule, MatSnackBarModule, MatSortModule, MatStepperModule, MatTableModule, MatTabsModule, MatTooltipModule, MAT_DIALOG_DEFAULT_OPTIONS} from '@angular/material'import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AnimalesComponent } from './animales/animales.component';
import { HttpClientModule }  from '@angular/common/http';
import {IsapiService} from './shared/isapi.service';
import { AnimalComponent } from './animal/animal.component';
<<<<<<< HEAD
import { MenudemoComponent } from './menudemo/menudemo.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'
import {FlexLayoutModule} from "@angular/flex-layout";
=======
import { ProveedoresComponent } from './proveedores/proveedores.component';
import { ProveedorComponent } from './proveedor/proveedor.component'
import { ProductosComponent } from './productos/productos.component';
import { ProductoComponent } from './producto/producto.component'

>>>>>>> sprint2

@NgModule({
  declarations: [
    AppComponent,
    AnimalesComponent,
    AnimalComponent,
<<<<<<< HEAD
    MenudemoComponent
=======
    ProveedoresComponent,
    ProveedorComponent,
    ProductosComponent,
    ProductoComponent
>>>>>>> sprint2
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    MatSidenavModule,
    MatToolbarModule,
    MatListModule,
    MatButtonModule,
    MatIconModule,
    MatAutocompleteModule,
    MatButtonToggleModule,
    MatCardModule,
    MatCheckboxModule,
    MatChipsModule,
    MatDatepickerModule,
    MatDialogModule,
    MatDividerModule,
    MatExpansionModule,
    MatGridListModule,
    MatInputModule,
    MatMenuModule,
    MatNativeDateModule,
    MatPaginatorModule,
    MatProgressBarModule,
    MatProgressSpinnerModule,
    MatRadioModule,
    MatRippleModule,
    MatSelectModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatSnackBarModule,
    MatSortModule,
    MatStepperModule,
    MatTableModule,
    MatTabsModule,
    MatTooltipModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatMenuModule,
    MatButtonModule,
    MatIconModule,
    MatCardModule,
    BrowserAnimationsModule,
    FlexLayoutModule,
  ],
  providers: [IsapiService],
  bootstrap: [AppComponent]
})
export class AppModule { }
