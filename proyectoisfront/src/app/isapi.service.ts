import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
@Injectable({
  providedIn: 'root'
})
export class IsapiService {

  constructor(private httpClient: HttpClient) { }
  public getAnimales(){
    return this.httpClient.get('http://testapi:8080/animales');
  }
}
