import {OrderItem} from "./OrderItem";

export interface Order {
  id?:Number,
  items: OrderItem[],
  customerName:String,
  customerSurname:String,
  customerEmailAddress:String,
  customerPhone:String,
  deliveryAddress: String,
  storePickup: boolean,
  finished?:boolean,
  createdOn:Date,
}
