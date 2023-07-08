import {Product} from "./Product";
import {Ingredient} from "./Ingredient";

export interface OrderItem {
  product:Product
  quantity:number
  notIngredients:String[]
}
