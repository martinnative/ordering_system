import { Component } from '@angular/core';
import {ShoppingCartService} from "../shopping-cart.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  constructor(private shoppingCartService:ShoppingCartService) {
  }
  showCartItems() {
    console.log(this.shoppingCartService.getCartItems());
  }
}
