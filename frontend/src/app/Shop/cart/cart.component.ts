import {Component, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {ShoppingCartService} from "../../shopping-cart.service";
import {ImageService} from "../../image.service";
import {Product} from "../../../model/Product";
import {OrderItem} from "../../../model/OrderItem";

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit, OnChanges {
  cartItems: OrderItem[] = [];
  constructor(private shoppingCartService:ShoppingCartService,private imageService:ImageService
  ) {};

  transformData(data: Product):Product {
    return this.imageService.transformData(data);
  }
  ngOnInit(): void {
    this.cartItems = this.shoppingCartService.getCartItems();
  }
  calculateTotal(): number {
    return this.shoppingCartService.calculateTotal();
  }
  ngOnChanges(changes: SimpleChanges): void {
    this.cartItems = this.shoppingCartService.getCartItems();
  }

  removeFromCart(orderItem: OrderItem){
    this.cartItems = this.shoppingCartService.removeFromCart(orderItem);
  }
  quantity:number = 1;

  subQuantity() {
    if(this.quantity>0) {
      this.quantity--;
    }
  }
  save() {
    if(this.quantity < 0 || isNaN(this.quantity)) {
      this.quantity = 1;
    }
  }
  scrollToTop(el:HTMLElement) {
    el.scrollIntoView({behavior:"smooth"});
  }

}
