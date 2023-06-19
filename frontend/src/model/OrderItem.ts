import { Product } from "./Product";

export interface OrderItem {
    id:Number,
    product:Product,
    quantity:number
}