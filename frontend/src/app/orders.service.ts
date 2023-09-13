import {Injectable, OnDestroy, OnInit} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Order } from '../model/Order';
import {OrderItem} from "../model/OrderItem";
import {OrderRequest} from "../model/OrderRequest";
import {OrderItemRequest} from "../model/OrderItemRequest";

@Injectable({
  providedIn: 'root'
})
export class OrdersService implements OnInit{
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
  }

  findAllOrders(): Observable<Order[]> {
    return this.http.get<Order[]>('/api/orders');
  }

  findTodaysOrders(): Observable<Order[]> {
    return this.http.get<Order[]>('/api/orders/today');
  }

  changeOrderStatus(order: Order): Observable<Order[]> {
    return this.http.put<Order[]>(`/api/orders/status/${order.id}`,null, this.httpOptions);
  }
  createOrder(orderItems: OrderItem[], customerName: String, customerSurname: String, customerEmailAddress: String, customerPhone: String, deliveryAddress: String): Observable<Order> {
    const orderItemsRequest:OrderItemRequest[] = orderItems.map(orderItem => ({
        productId: orderItem.product.id,
        quantity: orderItem.quantity,
        notIngredients: orderItem.notIngredients
      }));
    const orderRequest : OrderRequest = {
      orderItemRequests: orderItemsRequest,
      customerName: customerName,
      customerSurname: customerSurname,
      customerEmailAddress: customerEmailAddress,
      customerPhone: customerPhone,
      deliveryAddress: deliveryAddress
    };
    return this.http.post<Order>('/api/orders/create', orderRequest);
  }

}
