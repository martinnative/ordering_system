import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {StorageService} from "./storage.service";


const AUTH_API = 'http://localhost:8080/api/auth/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http: HttpClient,private storageService:StorageService) {}

  public isAuthenticated(): boolean {
    const token = this.storageService.getToken();
    return !!token; // Change this logic based on your token validation requirements
  }

  public hasRole(role: string): boolean {
    const token = localStorage.getItem('token');
    if (token) {
      // Parse the token and extract the roles
      const decodedToken = JSON.parse(atob(token.split('.')[1]));
      const userRoles = decodedToken.roles;
      return userRoles && userRoles.includes(role);
    }
    return false;
  }

  login(username: string, password: string): Observable<any> {
    return this.http.post(
      AUTH_API + 'login',
      {
        username,
        password,
      },
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
}
