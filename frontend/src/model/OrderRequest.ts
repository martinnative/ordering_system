import {OrderItem} from "./OrderItem";

export interface OrderRequest {
  orderItemsIds: number[] | undefined,
  customerName:String,
  customerSurname:String,
  customerEmailAddress:String,
  customerPhone:String
}
