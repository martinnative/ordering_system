import {AfterContentInit, Component, OnInit} from '@angular/core';
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";
import {ShoppingCartService} from "../shopping-cart.service";
import {OrderItem} from "../../model/OrderItem";

@Component({
  selector: 'app-floating-cart',
  templateUrl: './floating-cart.component.html',
  styleUrls: ['./floating-cart.component.css'],
})
export class FloatingCartComponent implements OnInit, AfterContentInit{
  cartItems: OrderItem[] = [];
  loaded:boolean = false;
  constructor(public activeModal: NgbActiveModal, private shoppingCartService:ShoppingCartService) {};
  closeModal() {
    this.activeModal.close();
  }
  ngOnInit(): void {
    this.cartItems = this.shoppingCartService.getCartItems();
  }
  calculateTotal(): number {
    return this.shoppingCartService.calculateTotal();
  }

  ngAfterContentInit(): void {
    this.loaded = true;
  }
}
