import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Order} from "../model/Order";

@Injectable({
  providedIn: 'root'
})
export class OrdersService {
  constructor(private http:HttpClient) {}
  findAllOrders() :Observable<Order[]> {
    return this.http.get<Order[]>('/api/orders');
}
}
