import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Category } from './model/Category';
@Injectable({
  providedIn: 'root'
})
export class CategoriesService {

  constructor(private http:HttpClient) { }
  findAllCategories():Observable<Category[]> {
    return this.http.get<Category[]>(`/api/categories`);
  }
}
