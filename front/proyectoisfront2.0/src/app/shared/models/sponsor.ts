import { Injectable } from '@angular/core'
import { Adapter } from 'app/core/adapter'
import { Animal } from './animal'
import { Usuario } from './usuario'

//Esta clase contiene un modelo de Animal para ser mostrado con peticiones HTTP

export class Sponsor{

    constructor(id :number, monto : number, usuario : Usuario){
            this.id = id
            this.monto = monto
            this.usuario = usuario
    }
    id : number
    monto : number
    usuario : Usuario

    
}

@Injectable({
    providedIn: 'root'
})

export class SponsorAdapter implements Adapter<Sponsor>{
    adapt(item: any): Sponsor {
        console.log(item)
        var nuevoUsuario = new Usuario(item.id, item.username, item.password, item.email, item.active)
        return new Sponsor(item.id, item.monto, nuevoUsuario)
    }

    
}