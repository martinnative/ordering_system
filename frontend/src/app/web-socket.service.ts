import {Injectable, OnInit} from '@angular/core';
import {Order} from "../model/Order";
import {Observable, Subject} from "rxjs";
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
    const serverUrl = 'https://ulaf-ste.com/ws';
    const ws = new SockJS(serverUrl);
    this.stompClient = Stomp.over(ws);
    const that = this;
    this.stompClient.connect({}, function() {
      that.stompClient.subscribe('/orders', (message:any) => {
        if (message.body) {
          const order = JSON.parse(message.body) as Order;
          that.orderSubject.next(order);
        }
      });
    });
  }
  subscribeToOrders(): Observable<Order> {
    return this.orderSubject.asObservable();
  }
}
