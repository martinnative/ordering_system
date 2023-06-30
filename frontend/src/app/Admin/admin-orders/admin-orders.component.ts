import {Component, OnInit} from '@angular/core';
import {Order} from "../../../model/Order";
import {OrdersService} from "../../orders.service";
import {Product} from "../../../model/Product";
import {ImageService} from "../../image.service";
import {LoadingService} from "../../loading.service";

@Component({
  selector: 'app-admin-orders',
  templateUrl: './admin-orders.component.html',
  styleUrls: ['./admin-orders.component.css']
})
export class AdminOrdersComponent implements OnInit{
  orders: Order[] = []
  filteredOrders: Order[] = [];

  constructor(private ordersService:OrdersService,private imageService:ImageService,private loaderService:LoadingService) {
  }
  ngOnInit(): void {
    this.ordersService.findAllOrders().subscribe(data => {
      this.orders = data
      this.filteredOrders = data;
    });
  }
  transformData(data: Product):Product {
    return this.imageService.transformData(data);
  }
  orderStatusChanged(order:Order) {
    this.loaderService.setLoading(true);
    this.ordersService.changeOrderStatus(order).subscribe(data => {
      this.orders=data;
      this.filteredOrders = data;
      this.loaderService.setLoading(false);
    });
  }
  resetFilter() {
    this.filteredOrders = this.orders;
  }
  showProcessing() {
    this.filteredOrders = this.orders.filter(a => !a.finished)
  }
  showFinished() {
    this.filteredOrders = this.orders.filter(a => a.finished)
  }

}
