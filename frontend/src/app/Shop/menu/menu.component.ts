import {AfterViewInit, Component, OnInit} from '@angular/core';
import PerfectScrollbar from "perfect-scrollbar";
import {Product} from "../../../model/Product";
import {CategoriesService} from "../../categories.service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {ProductsService} from "../../products.service";
import {ShoppingCartService} from "../../shopping-cart.service";
import {Router} from "@angular/router";
import {Category} from "../../../model/Category";
import {CustomizeModalComponent} from "../customize-modal/customize-modal.component";
import {DomSanitizer} from "@angular/platform-browser";
import {ImageService} from "../../image.service";
import {LoadingService} from "../../loading.service";
import {AlertService} from "../../alert.service";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit{
  products: Product[] = [];
  categories: Category[] = [];
  quantity:number = 1;

  options = {
    autoClose: true,
    keepAfterRouteChange: false
  };

  constructor(private categoryService: CategoriesService,
              private productsService: ProductsService,
              private shoppingCartService: ShoppingCartService,
              private modalService: NgbModal,
              private imageService: ImageService,
              private loadingService: LoadingService,
              private alertService: AlertService
  ) {
  }
  scrollToTop(el:HTMLElement) {
    el.scrollIntoView({behavior:"smooth"});
  }

  ngOnInit(): void {
    this.loadingService.setLoading(true);
    this.productsService.findAllProducts(true).subscribe(data => {
      this.products = data.reverse();
      this.loadingService.setLoading(false);
    });
  }

  addToCart(product: Product) {
    let added:boolean = this.shoppingCartService.addToCart(product,this.quantity,[]);
    if(added) {
      this.alertService.success("Успешно додадено во кошничка!",this.options);
    }
    else {
      this.alertService.error("Вашата кошничка е преполна!",this.options)
    }
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
  transformData(data: Product):Product {
    return this.imageService.transformData(data);
  }

  transformDataCategory(data: Category):Category {
    return this.imageService.transformDataCategory(data);
  }

}
