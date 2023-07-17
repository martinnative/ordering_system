import {Ingredient} from "./Ingredient";

export interface OrderItemRequest {
  productId: Number,
  quantity: number,
  notIngredients: Ingredient[]
}
