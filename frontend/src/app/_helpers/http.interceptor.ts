import { Injectable } from '@angular/core';
import { HttpEvent, HttpInterceptor, HttpHandler, HttpRequest, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Observable } from 'rxjs';
import {AuthService} from "../_services/auth.service";

@Injectable()
export class HttpRequestInterceptor implements HttpInterceptor {
  constructor(private authService:AuthService) {}
  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {

    console.log(this.authService.isAuthenticated,this.authService.roles)
    if(!request.url.includes("/auth/login") && this.authService.accessToken != undefined) {
      let newRequest = request.clone({
        headers:request.headers.set('Authorization','Bearer '+this.authService.accessToken)
      })
      console.log("modified ",newRequest);
      return next.handle(newRequest);
    }
    return next.handle(request);
  }
}
