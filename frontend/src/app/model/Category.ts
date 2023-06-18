import { Product } from "./Product";

export interface Category{
    Id:Number,
    name:String,
    description:String,
    products:Product[];
}