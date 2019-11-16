import { Injectable } from '@angular/core'
import { Adapter } from 'app/core/adapter'

//Esta clase contiene un modelo de Animal para ser mostrado con peticiones HTTP

export class Ubicacion{

    constructor(id :number, nombre: string){
            this.id = id
            this.nombre = nombre
    }
    id : number
    nombre : string
}

@Injectable({
    providedIn: 'root'
})

export class UbicacionAdapter implements Adapter<Ubicacion>{
    adapt(item: any): Ubicacion {
        console.log(item)
        return new Ubicacion(item.id, item.nombre)
    }

    
}