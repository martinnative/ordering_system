import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Order } from '../model/Order';
import {OrderItem} from "../model/OrderItem";
import {OrderRequest} from "../model/OrderRequest";

@Injectable({
  providedIn: 'root'
})
export class OrdersService {
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) {}

  findAllOrders(): Observable<Order[]> {
    return this.http.get<Order[]>('/api/orders');
  }

  findTodaysOrders(): Observable<Order[]> {
    return this.http.get<Order[]>('/api/orders/today');
  }

  changeOrderStatus(order: Order): Observable<Order[]> {
    return this.http.put<Order[]>(`/api/orders/status`, { id: order.id }, this.httpOptions);
  }
  createOrder(orderItems: OrderItem[], customerName: String, customerSurname: String, customerEmailAddress: String, customerPhone: String): Observable<Order> {
    const orderRequest : OrderRequest = {
      orderItemsIds: orderItems.map(it=> it.id),
      customerName: customerName,
      customerSurname: customerSurname,
      customerEmailAddress: customerEmailAddress,
      customerPhone: customerPhone
    };
    return this.http.post<Order>('/api/orders/create', orderRequest);
  }




}
