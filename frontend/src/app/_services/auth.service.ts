import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {StorageService} from "./storage.service";
import jwtDecode from "jwt-decode";
import {Router} from "@angular/router";


const AUTH_API = 'http://localhost:8080/auth/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded' })
};
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  isAuthenticated:Boolean = false;
  roles: any;
  username: any;
  accessToken: any;
  constructor(private http: HttpClient,private storageService:StorageService) {}

  // public isAuthenticated(): boolean {
  //   const token = this.storageService.getToken();
  //   return !!token; // Change this logic based on your token validation requirements
  // }
  //
  // public hasRole(role: string): boolean {
  //   const token = localStorage.getItem('token');
  //   if (token) {
  //     // Parse the token and extract the roles
  //     const decodedToken = JSON.parse(atob(token.split('.')[1]));
  //     const userRoles = decodedToken.roles;
  //     return userRoles && userRoles.includes(role);
  //   }
  //   return false;
  // }

  login(username: string, password: string): Observable<any> {
    let params = new HttpParams().set("username",username).set("password",password);
    return this.http.post(
      AUTH_API + 'login',
      params,
      httpOptions
    );
  }

  register(username: string, email: string, password: string): Observable<any> {
    return this.http.post(
      AUTH_API + 'signup',
      {
        username,
        email,
        password,
      },
      httpOptions
    );
  }

  logout(): Observable<any> {
    return this.http.post(AUTH_API + 'signout', { }, httpOptions);
  }

  loadProfile(data: any) {
    this.isAuthenticated = true;
    this.accessToken = data['access-token'];
    let decodedJwt:any = jwtDecode(this.accessToken);
    this.username = decodedJwt.sub;
    console.log(this.accessToken);
    this.roles = decodedJwt.scope;
    console.log("Set!");
  }
}
