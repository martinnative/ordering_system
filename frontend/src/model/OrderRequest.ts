import {OrderItem} from "./OrderItem";
import {OrderItemRequest} from "./OrderItemRequest";

export interface OrderRequest {
  orderItemRequests: OrderItemRequest[],
  customerName:String,
  customerSurname:String,
  customerEmailAddress:String,
  customerPhone:String,
  deliveryAddress: String,
  storePickup: boolean,
}
