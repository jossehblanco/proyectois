import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import {Animal, AnimalAdapter} from './models/animal'
import {Observable, throwError} from 'rxjs'
import {map} from 'rxjs/operators'
import {retry, catchError} from 'rxjs/operators'
import {Proveedor, ProveedorAdapter} from './models/proveedor'
import { Producto, ProductoAdapter } from './models/producto';



@Injectable({
  providedIn: 'root'
})

//EL servicio se encarga de consumer el API y devuelve la data obtenida. LOs metodos se tienen que declarar aqui.

export class IsapiService {
  //URL Base para consumir el servicio REST
    baseurl = 'http://localhost:8080';


    constructor(private httpclient : HttpClient, private animaladapter: AnimalAdapter, private productoAdapter: ProductoAdapter, private proveedorAdapter : ProveedorAdapter){}
    //GET

    //Metodos que devuelven listas de Animales, Productos y Proveedores:


    listAnimales(): Observable<Animal[]>{
      const url = this.baseurl + '/animales'
      return this.httpclient.get(url).pipe(
        map((data: any[]) => data.map((item:any) => this.animaladapter.adapt(item)))
      )
    }

    listProductos() : Observable<Producto[]>{
      const url = this.baseurl + '/productos'
      return this.httpclient.get(url).pipe(
        map((data: any[]) => data.map((item:any) => this.productoAdapter.adapt(item)))
      )
    }

    listProveedores() : Observable<Proveedor[]>{
      const url = this.baseurl + '/proveedor'
      return this.httpclient.get(url).pipe(
        map((data: any[]) => data.map((item:any) => this.proveedorAdapter.adapt(item)))
      )
      
    }


    //Metodos que devuelven objetos singulares de animales, proveedores y productos

    getAnimalById(id : number) : Observable<Animal>{
      const url = this.baseurl + '/animales/' + id 
      return this.httpclient.get(url).pipe(
        map((data: any) => this.animaladapter.adapt(data)))      
    }


    getProductoById(id : number) : Observable<Producto>{
      const url = this.baseurl + '/productos/' + id 
      return this.httpclient.get(url).pipe(
        map((data: any) => this.productoAdapter.adapt(data)))      
    }

    getProveedorById(id : number) : Observable<Proveedor>{
      const url = this.baseurl + '/proveedor/' + id 
      return this.httpclient.get(url).pipe(
        map((data: any) => this.proveedorAdapter.adapt(data)))      
    }
    //Metodos GET
    /*
    getAnimales(): Observable<Animal>{
      return this.httpclient.get<Animal>(this.baseurl+'/animales')
      .pipe(retry(1), catchError(this.errorHandl));
    }

    getProductos(): Observable<Producto>{
      return this.httpclient.get<Producto>(this.baseurl+'/productos')
      .pipe(retry(1), catchError(this.errorHandl));
    }

    getProveedores(): Observable<Proveedores>{
      return this.httpclient.get<Proveedores>(this.baseurl+'/proveedor')
      .pipe(retry(1), catchError(this.errorHandl));
    }


    getProducto(id : number): Observable<Producto>{
      return this.httpclient.get<Producto>(this.baseurl+'/productos/' + id)
      .pipe(retry(1), catchError(this.errorHandl));
    }

    //Obtener animal x id, recibe un id como argumento y consulta baseurl/animales/id
    getAnimal(id : number): Observable<Animal>{
      return this.httpclient.get<Animal>(this.baseurl+'/animales/' + id)
      .pipe(retry(1), catchError(this.errorHandl));
    }

    getProveedor(id : number): Observable<Proveedores>{
      return this.httpclient.get<Proveedores>(this.baseurl+'/proveedor/' + id)
      .pipe(retry(1), catchError(this.errorHandl));
    }
    */

    //manejo de errores
    errorHandl(error){
      let errorMessage = '';
      if(error.error instanceof ErrorEvent){
         //Obtener error del lado del cliente
         errorMessage = error.error.message;
      }else{
        //Obtener error del lado del servidor
        errorMessage =  'Error Code: ${error.status}\nMessage: ${error.message}';    
      }
      console.log(errorMessage)
      return throwError(errorMessage)
    }

}
