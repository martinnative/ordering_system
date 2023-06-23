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
  constructor(private shoppingCartService:ShoppingCartService,
              private modalService:NgbModal) {
  }
  showCartItems() {
    console.log(this.shoppingCartService.getCartItems());
  }
  openModal() {
    const modalRef = this.modalService.open(FloatingCartComponent);
  }
}
