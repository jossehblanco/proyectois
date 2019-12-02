import { Injectable } from '@angular/core';
import {HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { ApiService } from './apiservice.service';


@Injectable()
export class Intercept implements HttpInterceptor {  
    constructor(private apiService : ApiService) { }   
    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        console.log("Se interceptó :v")
    request = request.clone({
      setHeaders: {
        Authorization: this.apiService.auth_token }
      }
    );    
    
    return next.handle(request);
  }
}