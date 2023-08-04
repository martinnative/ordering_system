import { Injectable } from '@angular/core';
import { HttpEvent, HttpInterceptor, HttpHandler, HttpRequest, HTTP_INTERCEPTORS } from '@angular/common/http';
import {Observable, switchMap, take} from 'rxjs';
import {AuthService} from "../_services/auth.service";

@Injectable()
export class HttpRequestInterceptor implements HttpInterceptor {
  constructor(private authService:AuthService) {}
  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    if(!request.url.includes("/auth/login") && sessionStorage.getItem("access-token") != undefined) {
      let newRequest = request.clone({
        headers:request.headers.set('Authorization','Bearer '+sessionStorage.getItem("access-token"))
      })
      return next.handle(newRequest);
    }
    return next.handle(request);
  }

}
