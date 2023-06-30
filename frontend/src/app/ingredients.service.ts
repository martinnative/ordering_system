import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Ingredient} from "../model/Ingredient";
import {Observable} from "rxjs";
import {Category} from "../model/Category";

@Injectable({
  providedIn: 'root'
})
export class IngredientsService {

  constructor(private http:HttpClient) { }

  findAllIngredients():Observable<Ingredient[]> {
    return this.http.get<Category[]>(`/api/ingredients`);
  }
  saveIngredient(ingr:any):Observable<Ingredient> {
    return this.http.post<Ingredient>("/api/ingredients",ingr);
  }
}
