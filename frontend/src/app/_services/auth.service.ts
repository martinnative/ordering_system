import {Injectable, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import jwtDecode from "jwt-decode";
import {UserRequest} from "../../model/UserRequest";



const AUTH_API = 'https://ulaf-ste.com/api/auth/';
const AUTH_API1 = 'http://localhost:8080/auth/';

@Injectable({
  providedIn: 'root'
})
export class AuthService implements OnInit{
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  isAuthenticated:Boolean = false;
  roles: any;
  username: any;
  accessToken: any;
  constructor(private http: HttpClient) {}

  login(username: string, password: string): Observable<any> {
    let userRequest : UserRequest = {
      username : username,
      password : password
    }
    return this.http.post(
      AUTH_API + 'login',
      userRequest,
      this.httpOptions
    );
  }

  logout(): Observable<any> {
    sessionStorage.removeItem("access-token")
    this.isAuthenticated = false;
    return this.http.post(AUTH_API1 + 'signout', { });
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
