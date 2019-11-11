import { Injectable } from '@angular/core'
import { Adapter } from 'app/core/adapter'
import { Sponsor, SponsorAdapter } from './sponsor'
import { map } from 'rxjs/operators'

//Esta clase contiene un modelo de Animal para ser mostrado con peticiones HTTP

export class Animal{

    constructor(id :number, nombre: string, edad : number, 
        peso: number, tiposangre: string, descripcion: string, 
        idespecie: number, idubicacion : number, url_imagen:string, sponsors : Sponsor[]){
            this.id = id
            this.nombre = nombre
            this.edad = edad
            this.peso = peso
            this.tiposangre = tiposangre
            this.descripcion = descripcion
            this.idespecie = idespecie
            this.idubicacion = idubicacion
            this.url_imagen = url_imagen
            this.sponsors = sponsors
    }
    id : number
    nombre : string
    edad : number
    peso : number
    tiposangre : string
    descripcion : string
    idespecie : number
    idubicacion : number
    url_imagen : string
    sponsors : Sponsor[]
}

@Injectable({
    providedIn: 'root'
})

export class AnimalAdapter implements Adapter<Animal>{
    constructor(private sponsorAdapter : SponsorAdapter){

    }
    adapt(item: any): Animal {
        console.log(item)
        var nsponsors : Sponsor[]
        for(var sponsor in item.sponsors){
            nsponsors.push(this.sponsorAdapter.adapt(sponsor))

        }
        return new Animal(item.id, item.nombre, 
            item.edad,
            item.peso,
            item.tipoSangre,
            item.descripcion,
            item.idespecie,
            item.idubicacion,
            item.url_imagen, 
            nsponsors)
    }

    
}