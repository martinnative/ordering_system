import { Component } from '@angular/core';
import {ShoppingCartService} from "../shopping-cart.service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {FloatingCartComponent} from "../floating-cart/floating-cart.component";

@Component({
  selector: 'app-header-transparent',
  templateUrl: './header-transparent.component.html',
  styleUrls: ['./header-transparent.component.css']
})
export class HeaderTransparentComponent {
  cartOpen:boolean = false;
  constructor(private shoppingCartService:ShoppingCartService,
              private modalService:NgbModal) {
  }
  showCartItems() {
    console.log(this.shoppingCartService.getCartItems());
  }
  openCart() {
    this.cartOpen = true;
  }
  closeCart() {
    this.cartOpen = false;
  }
}
