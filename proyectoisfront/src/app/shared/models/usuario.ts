import { Injectable } from '@angular/core'
import { Adapter } from 'src/app/core/adapter'

//Esta clase contiene un modelo de Animal para ser mostrado con peticiones HTTP

export class Usuario{

    constructor(id: number, username: string, pwd : string){
        this.id = id;
        this.username = username;
        this.pwd = pwd;
    }

    username : string
    pwd : string
    id : number
}

@Injectable({
    providedIn: 'root'
})

export class UsuarioAdapter implements Adapter<Usuario>{
    adapt(item: any): Usuario {

        return new Usuario(item.id, item.username, item.pwd);
    }
    
    
}