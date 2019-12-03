import { Injectable } from '@angular/core';
import {HttpInterceptor, HttpRequest, HttpHandler, HttpEvent} from '@angular/common/http'
import {Observable} from 'rxjs'

import { IsapiService } from './isapi.service';

@Injectable()
export class Intercept implements HttpInterceptor {  
    constructor(private apiService : IsapiService) { }   
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

