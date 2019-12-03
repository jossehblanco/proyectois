import { Injectable } from '@angular/core'
import {Adapter} from 'src/app/core/adapter'
export class Producto{

    constructor(id :number, nombre : string, precio: number, calificacion : number, idproveedor :number, 
        descripcion: string, url_imagen : string){
            this.id = id
            this.nombre = nombre
            this.precio = precio
            this.calificacion = calificacion
            this.idproveedor = idproveedor
            this.descripcion = descripcion
            this.url_imagen = url_imagen
    }


    id : number
    nombre : string
    precio : number
    calificacion : number
    idproveedor : number
    descripcion : string
    url_imagen : string
}

@Injectable({
    providedIn : 'root'
})

export class ProductoAdapter implements Adapter<Producto>{

    adapt(item : any){
       console.log(item);
        return new Producto(item.id, item.nombreProducto, item.precio, item.calificacion, item.idProveedor, item.descripcionProducto,
            item.url_imagen)
            
    }

}