import { Component } from '@angular/core';
import {ShoppingCartService} from "../shopping-cart.service";
import {Product} from "../../model/Product";
import {CustomizeModalComponent} from "../customize-modal/customize-modal.component";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {FloatingCartComponent} from "../floating-cart/floating-cart.component";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  cartOpen:boolean = false;
  constructor(private shoppingCartService:ShoppingCartService) {
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
