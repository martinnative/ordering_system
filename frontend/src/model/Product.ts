import {Category} from "./Category";
import {Ingredient} from "./Ingredient";


export interface Product {
  id: Number,
  name: String,
  price: number,
  description: String,
  ingredients: Ingredient[],
  customizable: boolean,
  category: Category,
  available: boolean,
  image: any;
}
