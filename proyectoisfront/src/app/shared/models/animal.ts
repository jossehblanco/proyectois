import { Injectable } from '@angular/core'
import { Adapter } from 'src/app/core/adapter'

//Esta clase contiene un modelo de Animal para ser mostrado con peticiones HTTP

export class Animal{

    constructor(id :number, nombre: string, edad : number, 
        peso: number, tiposangre: string, descripcion: string, 
        idespecie: number, idubicacion : number){
            this.id = id
            this.nombre = nombre
            this.edad = edad
            this.peso = peso
            this.tiposangre = tiposangre
            this.descripcion = descripcion
            this.idespecie = idespecie
            this.idubicacion = idubicacion
    }
    id : number
    nombre : string
    edad : number
    peso : number
    tiposangre : string
    descripcion : string
    idespecie : number
    idubicacion : number
}

@Injectable({
    providedIn: 'root'
})

export class AnimalAdapter implements Adapter<Animal>{
    adapt(item: any): Animal {
        console.log(item)
        return new Animal(item.id, item.nombre, 
            item.edad,
            item.peso,
            item.tipoSangre,
            item.descripcion,
            item.idespecie,
            item.idubicacion)
    }

    
}