import {Product} from "./Product";
import {Ingredient} from "./Ingredient";

export interface OrderItem {
  id: number
  product:Product
  quantity:number
  notIngredients:String[]
}
