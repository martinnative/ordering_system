import {AfterContentInit, Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {ShoppingCartService} from "../shopping-cart.service";
import {OrderItem} from "../../model/OrderItem";
import { Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-floating-cart',
  templateUrl: './floating-cart.component.html',
  styleUrls: ['./floating-cart.component.css'],
})
export class FloatingCartComponent implements OnInit, OnChanges{
  cartItems: OrderItem[] = [];
  @Input() cartOpen:boolean = false;
  @Output() cartCloseEvent = new EventEmitter<string>();

  constructor(private shoppingCartService:ShoppingCartService) {};
  closeModal() {
    this.cartOpen = false;
    this.cartCloseEvent.emit();
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
    this.shoppingCartService.removeFromCart(orderItem)
    this.cartItems = this.shoppingCartService.getCartItems()
  }
}
