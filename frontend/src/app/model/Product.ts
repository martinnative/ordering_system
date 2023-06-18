import { Ingredient } from "./Ingredient";

export interface Product{
    id:Number,
    name:String,
    price:Number,
    ingredients:Ingredient[]
}