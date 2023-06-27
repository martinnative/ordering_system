import {AfterViewInit, Component, OnInit} from '@angular/core';
import PerfectScrollbar from "perfect-scrollbar";
import {Product} from "../../model/Product";
import {CategoriesService} from "../categories.service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {ProductsService} from "../products.service";
import {ShoppingCartService} from "../shopping-cart.service";
import {Router} from "@angular/router";
import {Category} from "../../model/Category";
import {CustomizeModalComponent} from "../customize-modal/customize-modal.component";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit, AfterViewInit{
  products: Product[] = [];
  categories: Category[] = [];

  constructor(private categoryService: CategoriesService,
              private productsService: ProductsService,
              private shoppingCartService: ShoppingCartService,
              private modalService: NgbModal,
  ) {
  }
  ngAfterViewInit(): void {
    $('.banner-slider-3').slick({
      dots: true,
      arrows: false,
      infinite: true,
      speed: 300,
      slidesToShow: 3,
      centerMode: true,
      adaptiveHeight: true
    });
  }

  ngOnInit(): void {
    this.productsService.findAllProducts().subscribe(data => {
      this.products = data;
    });
  }

  addToCart(product: Product) {
    this.shoppingCartService.addToCart(product);
  }
  openModal(product: Product) {
    console.log("product");
    const modalRef = this.modalService.open(CustomizeModalComponent);
    modalRef.componentInstance.product = product;
    modalRef.result.then((result) => {
      if (result) {
        console.log(result)
      }
    });
  }

}
