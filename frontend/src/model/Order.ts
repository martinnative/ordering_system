import {OrderItem} from "./OrderItem";

export interface Order {
  id?:Number,
  items: OrderItem[],
  customerName:String,
  customerSurname:String,
  customerEmailAddress:String,
  customerPhone:String,
  finished?:boolean,
  createdOn:Date,
}
