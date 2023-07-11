import {OrderItem} from "./OrderItem";

export interface OrderRequest {
  orderItems: OrderItem[],
  customerName:String,
  customerSurname:String,
  customerEmailAddress:String,
  customerPhone:String
}
