import {OrderItem} from "./OrderItem";

export interface Order {
  id:number,
  items: OrderItem[],
  customerName:string,
  customerSurname:string,
  customerEmailAddress:string,
  customerPhone:string,
  finished:boolean,
}
