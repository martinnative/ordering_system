import {Ingredient} from "./Ingredient";

export interface OrderItem {
  productId: Number,
  productName: String,
  price:number,
  description:String,
  productImage: any,
  notIngredients: String,
  quantity: number,
  pizzaNumber:number,
  categoryName: String
}
