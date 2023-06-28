import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Ingredient} from "../model/Ingredient";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class IngredientsService {

  constructor(private http:HttpClient) { }

  saveIngredient(ingr:any):Observable<Ingredient> {
    return this.http.post<Ingredient>("/api/ingredients",ingr);
  }
}
