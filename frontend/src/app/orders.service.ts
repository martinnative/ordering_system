import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Order } from '../model/Order';
import {OrderItem} from "../model/OrderItem";

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
  createOrder(orderItems: OrderItem[], customerName: string, customerSurname: string, customerEmailAddress: string, customerPhone: string): Observable<Order> {
    const orderRequest = {
      orderItems,
      customerName,
      customerSurname,
      customerEmailAddress,
      customerPhone
    };
    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };

    return this.http.post<Order>('/api/orders/create', orderRequest, httpOptions);
  }




}
