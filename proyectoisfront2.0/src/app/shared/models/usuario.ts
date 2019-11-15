import { Injectable } from '@angular/core'
import { Adapter } from 'app/core/adapter'
import { Sponsor } from './sponsor'

//Esta clase contiene un modelo de Animal para ser mostrado con peticiones HTTP

export class Usuario{

    constructor(id :number, username: string, password : string, email : string, active : boolean){
            this.id = id
            this.username = username
            this.password = password
            this.email = email
            this.active = active
    }
    id : number
    username : string
    password : string  
    email : string
    active : boolean
    sponsors : Sponsor[]
}

@Injectable({
    providedIn: 'root'
})

export class UbicacionAdapter implements Adapter<Usuario>{
    adapt(item: any): Usuario {
        console.log(item)
        return new Usuario(item.id, item.username, item.password, item.email, item.active)
    }

    
}