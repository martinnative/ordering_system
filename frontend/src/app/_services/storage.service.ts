import { Injectable } from '@angular/core';


const TOKEN_KEY = 'jwt-token';

@Injectable({
  providedIn: 'root'
})
export class StorageService {
  constructor() {}

  clean(): void {
    localStorage.clear();
  }

  public getToken(): string | null {
    return JSON.parse(localStorage.getItem("jwt-token")!).token;
  }

  public saveUser(user: any): void {
    localStorage.removeItem(TOKEN_KEY);
    localStorage.setItem(TOKEN_KEY, JSON.stringify(user));
  }

  public getUser(): any {
    const user = localStorage.getItem(TOKEN_KEY);
    if (user) {
      return JSON.parse(user);
    }
    return {};
  }

  public isLoggedIn(): boolean {
    const user = localStorage.getItem(TOKEN_KEY);
    if (user) {
      return true;
    }
    return false;
  }
}
