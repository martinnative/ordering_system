import {Component, OnInit} from '@angular/core';
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";
import {ShoppingCartService} from "../shopping-cart.service";
import {OrderItem} from "../../model/OrderItem";

@Component({
  selector: 'app-floating-cart',
  templateUrl: './floating-cart.component.html',
  styleUrls: ['./floating-cart.component.css'],
})
export class FloatingCartComponent implements OnInit{
  cartItems: OrderItem[] = [];
  constructor(public activeModal: NgbActiveModal, private shoppingCartService:ShoppingCartService) {};
  closeModal() {
    this.activeModal.close();
  }
  ngOnInit(): void {
    console.log("Cart init");
    this.cartItems = this.shoppingCartService.getCartItems();
  }
  calculateTotal(): number {
    return this.shoppingCartService.calculateTotal();
  }
}
