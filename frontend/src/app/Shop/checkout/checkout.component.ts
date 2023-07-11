import {Component, OnInit} from '@angular/core';
import {ShoppingCartService} from "../../shopping-cart.service";
import {OrderItem} from "../../../model/OrderItem";
import {OrdersService} from "../../orders.service";

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit{
  orderItems:OrderItem[] = [];
  firstname: String = "";
  lastname: String = "";
  phone: String = "";
  email: String = "";
  constructor(private shoppingCartService:ShoppingCartService, private ordersService:OrdersService) {
  }

  ngOnInit(): void {
    this.shoppingCartService.getOrderItems().subscribe(data => this.orderItems = data);
  }
  getTotalFromCart():Number {
    return this.shoppingCartService.calculateTotal();
  }
  scrollToTop(el:HTMLElement) {
    el.scrollIntoView({behavior:"smooth"});
  }
  createOrder() {
    console.log(this.orderItems, this.firstname, this.lastname, this.email, this.phone)
    this.ordersService.createOrder(this.orderItems, this.firstname, this.lastname, this.email, this.phone).subscribe(
      (response) => {
        // Handle the successful creation of the order
        console.log('Order created:', response);
        // Optionally, you can perform additional actions such as showing a success message or redirecting to a confirmation page
      },
      (error) => {
        // Handle the error if the order creation fails
        console.error('Error creating order:', error);
        // Optionally, you can display an error message to the user
      }
    );
  }


}
