import {Component, OnInit} from '@angular/core';
import {ShoppingCartService} from "../../shopping-cart.service";
import {Product} from "../../../model/Product";
import {CustomizeModalComponent} from "../../Shop/customize-modal/customize-modal.component";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {FloatingCartComponent} from "../../Shop/floating-cart/floating-cart.component";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit{
  cartOpen:boolean = false;
  constructor(private shoppingCartService:ShoppingCartService) {
  }
  showCartItems() {
  }
  openCart() {
    this.cartOpen = true;
  }
  closeCart() {
    this.cartOpen = false;
  }
  getNumOfCartItems() {
    return this.shoppingCartService.getNumberOfCartItems();
  }

  ngOnInit(): void {
    (function($) {
      'use strict';
      $(".aside-trigger").on('click', function() {
        $(".main-aside").toggleClass('open');
      });
      $(".main-aside .menu-item-has-children > a").on('click', function(e) {
        var submenu = $(this).next(".submenu");
        e.preventDefault();
        submenu.slideToggle(200);
      })
    })(jQuery);
  }
}
