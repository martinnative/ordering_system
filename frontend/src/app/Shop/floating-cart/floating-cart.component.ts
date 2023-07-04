import {AfterContentInit, Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {ShoppingCartService} from "../../shopping-cart.service";
import {OrderItem} from "../../../model/OrderItem";
import { Output, EventEmitter } from '@angular/core';
import {ImageService} from "../../image.service";
import {Product} from "../../../model/Product";

@Component({
  selector: 'app-floating-cart',
  templateUrl: './floating-cart.component.html',
  styleUrls: ['./floating-cart.component.css'],
})
export class FloatingCartComponent implements OnInit, OnChanges{
  cartItems: OrderItem[] = [];
  @Input() cartOpen:boolean = false;
  @Output() cartCloseEvent = new EventEmitter<string>();

  constructor(private shoppingCartService:ShoppingCartService,private imageService:ImageService
  ) {};
  closeModal() {
    this.cartOpen = false;
    this.cartCloseEvent.emit();
  }
  transformData(data: OrderItem):OrderItem {
    return this.imageService.transformDataOrderItem(data);
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
}
