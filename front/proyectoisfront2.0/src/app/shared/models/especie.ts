import { Injectable } from '@angular/core'
import { Adapter } from 'app/core/adapter'

//Esta clase contiene un modelo de Animal para ser mostrado con peticiones HTTP

export class Especie{

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

export class UbicacionAdapter implements Adapter<Especie>{
    adapt(item: any): Especie {
        console.log(item)
        return new Especie(item.id, item.nombre)
    }

    
}