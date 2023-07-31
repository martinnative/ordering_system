import {Injectable, OnInit} from '@angular/core';
import { io } from 'socket.io-client';
import {Order} from "../model/Order";
import {Observable, Subject} from "rxjs";
import {AdminOrdersComponent} from "./Admin/admin-orders/admin-orders.component";
declare var SockJS:any;
declare var Stomp:any;
@Injectable({
  providedIn: 'root'
})
export class WebSocketService implements OnInit {

  ngOnInit(): void {
  }
  constructor() {
    this.initializeWebSocketConnection();
  }
  public stompClient:any;
  private orderSubject = new Subject<Order>();

  initializeWebSocketConnection() {
    const serverUrl = 'http://localhost:8080/ws';
    const ws = new SockJS(serverUrl);
    this.stompClient = Stomp.over(ws);
    const that = this;
    this.stompClient.connect({}, function(frame:any) {
      that.stompClient.subscribe('/app/orders', (message:any) => {
        if (message.body) {
          console.log(message.body);
          const order = JSON.parse(message.body) as Order;
          // Emit the order through the subject to notify subscribers
          that.orderSubject.next(order);
        }
      });
    });
  }
  subscribeToOrders(): Observable<Order> {
    return this.orderSubject.asObservable();
  }
}
