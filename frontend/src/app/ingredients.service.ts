import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Ingredient} from "../model/Ingredient";

@Injectable({
  providedIn: 'root'
})
export class IngredientsService {

  constructor(private http:HttpClient) { }

  saveIngredient(ingr:any) {
    return this.http.post<Ingredient>("/api/ingredients",ingr);
  }
}
