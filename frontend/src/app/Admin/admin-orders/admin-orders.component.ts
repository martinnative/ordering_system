import {Component, OnInit} from '@angular/core';
import {Order} from "../../../model/Order";
import {OrdersService} from "../../orders.service";
import {Product} from "../../../model/Product";
import {ImageService} from "../../image.service";
import {LoadingService} from "../../loading.service";
import Swal from 'sweetalert2';
import {OrderItem} from "../../../model/OrderItem";
import {Router} from "@angular/router";
import {StorageService} from "../../_services/storage.service";
import {AuthService} from "../../_services/auth.service";
import {Ingredient} from "../../../model/Ingredient";
import {WebSocketService} from "../../web-socket.service";

@Component({
  selector: 'app-admin-orders',
  templateUrl: './admin-orders.component.html',
  styleUrls: ['./admin-orders.component.css']
})
export class AdminOrdersComponent implements OnInit{
  orders: Order[] = []
  filteredOrders: Order[] = [];

  constructor(private ordersService:OrdersService,
              private imageService:ImageService,
              private loaderService:LoadingService,
              private router: Router,
              private storageService:StorageService,
              private authService:AuthService,
              public webSocketService:WebSocketService) {
  }
  ngOnInit(): void {
    window.addEventListener('beforeunload', this.onPageRefresh);
    this.ordersService.findAllOrders().subscribe(data => {
      this.orders = data
      this.filteredOrders = data;
    });
    this.webSocketService.subscribeToOrders().subscribe(order => {
      // Add the newly received order to the filteredOrders list
      this.filteredOrders.push(order);
      // You might want to apply any filtering or sorting logic here if needed
      // For example, you can do: this.filteredOrders = this.filteredOrders.filter(...) or something similar
    });
  }
  onPageRefresh(event: Event): void {
    this.ordersService.findAllOrders().subscribe(data => {
      this.orders = data
      this.filteredOrders = data;
    });
  }

  ngOnDestroy(): void {
    // Don't forget to remove the event listener when the component is destroyed
    window.removeEventListener('beforeunload', this.onPageRefresh);
  }
  transformData(data: Product):Product {
    return this.imageService.transformData(data);
  }
  transformDataIngredient(data: Ingredient):Ingredient {
    return this.imageService.transformIngredient(data);
  }
  orderStatusChanged(order:Order) {
    if(order.finished) {
      Swal.fire({
        title: 'Дали сте сигурни дека сакате да ја завршите нарачката?',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: '✓',
        cancelButtonText: 'X',
        heightAuto:false,
      }).then((result) => {
        if (result.value) {
          this.loaderService.setLoading(true);
          this.ordersService.changeOrderStatus(order).subscribe(data => {
            this.orders=data;
            this.filteredOrders = data;
            this.loaderService.setLoading(false);
            Swal.fire('Успешно!', 'Нарачката е сега завршена', 'success');
          });
        } else if (result.dismiss === Swal.DismissReason.cancel) {
          order.finished = !order.finished;
          Swal.fire('Откажано!', 'Нема промени во нарачката', 'error');
        }
        else {
          Swal.fire('Откажано!', 'Дојде до грешка!', 'error');
        }
      });
    }
    else {
      Swal.fire({
        title: 'Дали сте сигурни дека сакате да ја вратите во процесирање?',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: '✓',
        cancelButtonText: 'X',
        heightAuto:false,
      }).then((result) => {
        if (result.value) {
          this.loaderService.setLoading(true);
          this.ordersService.changeOrderStatus(order).subscribe(data => {
            this.orders=data;
            this.filteredOrders = data;
            this.loaderService.setLoading(false);
            Swal.fire('Успешно!', 'Нарачката е сега во процесирање', 'success');
          });
        } else if (result.dismiss === Swal.DismissReason.cancel) {
          order.finished = !order.finished;
          Swal.fire('Откажано!', 'Нема промени во нарачката', 'error');
        }
        else {
          Swal.fire('Откажано!', 'Дојде до грешка!', 'error');
        }
      });
    }


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
  isLogggedIn(){
    return this.storageService.isLoggedIn();
  }
  hasRole(role:string){
    return localStorage.getItem('role') == role;
  }

}
