import {Component, OnInit} from '@angular/core';
import {Order} from "../../../model/Order";
import {OrdersService} from "../../orders.service";
import {Product} from "../../../model/Product";
import {ImageService} from "../../image.service";

@Component({
  selector: 'app-admin-orders',
  templateUrl: './admin-orders.component.html',
  styleUrls: ['./admin-orders.component.css']
})
export class AdminOrdersComponent implements OnInit{
  orders: Order[] = []
  constructor(private ordersService:OrdersService,private imageService:ImageService) {
  }
  ngOnInit(): void {
    this.ordersService.findAllOrders().subscribe(data => this.orders = data);
  }
  transformData(data: Product):Product {
    return this.imageService.transformData(data);
  }
  orderStatusChanged(order:Order) {
    order.finished = !order.finished;
  }

}
