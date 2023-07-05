import {Component, OnInit} from '@angular/core';
import {ShoppingCartService} from "../../shopping-cart.service";
import {OrderItem} from "../../../model/OrderItem";

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit{
  orderItems:OrderItem[] = [];
  constructor(private shoppingCartSerice:ShoppingCartService) {
  }

  ngOnInit(): void {
    this.shoppingCartSerice.getOrderItems().subscribe(data => this.orderItems = data);
  }
  getTotalFromCart():Number {
    return this.shoppingCartSerice.calculateTotal();
  }
  scrollToTop(el:HTMLElement) {
    el.scrollIntoView({behavior:"smooth"});
  }

}
