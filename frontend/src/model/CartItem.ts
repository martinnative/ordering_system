import {Ingredient} from "./Ingredient";

export interface CartItem {
  productId:Number,
  price: number,
  quantity:number,
  notIngredients:String[]
}
