import {Injectable, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import jwtDecode from "jwt-decode";



const AUTH_API = 'https://ulaf-ste.com/auth/';
const AUTH_API1 = 'http://localhost:8080/auth/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded' })
};
@Injectable({
  providedIn: 'root'
})
export class AuthService implements OnInit{
  isAuthenticated:Boolean = false;
  roles: any;
  username: any;
  accessToken: any;
  constructor(private http: HttpClient) {}

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
    sessionStorage.removeItem("access-token")
    this.isAuthenticated = false;
    return this.http.post(AUTH_API1 + 'signout', { }, httpOptions);
  }

  loadProfile(data: any) {
    this.isAuthenticated = true;
    this.accessToken = data['access-token'];
    sessionStorage.setItem("access-token",this.accessToken)
    let decodedJwt:any = jwtDecode(this.accessToken);
    this.username = decodedJwt.sub;
    this.roles = decodedJwt.scope;
  }

  ngOnInit(): void {
  }
}
