import { Injectable } from '@angular/core'
import { Adapter } from 'src/app/core/adapter'

//Esta clase contiene un modelo de Animal para ser mostrado con peticiones HTTP

export class Sponsor{

    constructor(nombre_sponsor: string, nombre_animal: string, monto : number){
        this.nombre_sponsor = nombre_sponsor;
        this.nombre_animal = nombre_animal;
        this.monto = monto;
    }

    nombre_sponsor : string
    nombre_animal : string
    monto : number
}

@Injectable({
    providedIn: 'root'
})

export class SponsorAdapter implements Adapter<Sponsor>{
    adapt(item: any): Sponsor {
        console.log(item)
        return new Sponsor(item.sponsor, item.nombre, item.monto);
    }

    
}