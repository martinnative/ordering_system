import {Component, OnInit} from '@angular/core';
import {ShoppingCartService} from "../shopping-cart.service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {FloatingCartComponent} from "../floating-cart/floating-cart.component";

@Component({
  selector: 'app-header-transparent',
  templateUrl: './header-transparent.component.html',
  styleUrls: ['./header-transparent.component.css']
})
export class HeaderTransparentComponent implements OnInit {
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
