import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import {Animal} from './models/animal'
import {Observable, throwError} from 'rxjs'
import {retry, catchError} from 'rxjs/operators'
import {Proveedores} from './models/proveedores'
import { Producto } from './models/producto';



@Injectable({
  providedIn: 'root'
})

//EL servicio se encarga de consumer el API y devuelve la data obtenida. LOs metodos se tienen que declarar aqui.

export class IsapiService {
  //URL Base para consumir el servicio REST
    baseurl = 'http://localhost:8080';


    constructor(private httpclient : HttpClient){}
  

    //Metodos GET
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
