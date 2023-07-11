import {Ingredient} from "./Ingredient";

export interface CartItem {
  id?: number,
  productId:Number,
  price: number,
  quantity:number,
  notIngredients:String[]
}
