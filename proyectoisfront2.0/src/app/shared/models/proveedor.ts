import { Injectable } from '@angular/core'
import { Adapter } from 'app/core/adapter'


export class Proveedor{
    constructor(
    id : number,
    nombre : string,
    descripcion : string,
    idEmail : number){ 
        this.id = id
        this.nombre = nombre
        this.descripcion = descripcion 
        this.idEmail = idEmail
    }
    
    id: number
    nombre :string
    descripcion : string
    idEmail : number
}


@Injectable({

    providedIn : 'root'
})

export class ProveedorAdapter implements Adapter<Proveedor>{
    adapt(item: any){
        return new Proveedor(item.idProveedor, item.nombreProveedor, item.descProveedor, item.idEmail)
    }
    
}