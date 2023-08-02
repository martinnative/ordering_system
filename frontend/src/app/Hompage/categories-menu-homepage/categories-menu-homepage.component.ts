import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {CategoriesService} from '../../categories.service';
import {Category} from '../../../model/Category';
import {Product} from 'src/model/Product';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap'
import {CustomizeModalComponent} from '../../Shop/customize-modal/customize-modal.component';
import {ProductsService} from '../../products.service';
import {ShoppingCartService} from "../../shopping-cart.service";
import {Router} from "@angular/router";
import {ImageService} from "../../image.service";
import {LoadingService} from "../../loading.service";
import {AlertService} from "../../alert.service";
import {SlickCarouselComponent} from "ngx-slick-carousel";
import {Ingredient} from "../../../model/Ingredient";

@Component({
  selector: 'app-categories-menu-homepage',
  templateUrl: './categories-menu-homepage.component.html',
  styleUrls: ['./categories-menu-homepage.component.css']
})
export class CategoriesMenuHomepageComponent implements OnInit, AfterViewInit {
  categories: Category[] = [];
  products: Product[] = [];
  filteredProducts: Product[] = [];
  selectedCategory: Category | undefined = undefined;
  options = {
    autoClose: true,
    keepAfterRouteChange: false,
  };


  constructor(private categoryService: CategoriesService,
              private modalService: NgbModal,
              private productsService: ProductsService,
              private shoppingCartService: ShoppingCartService,
              private router:Router,
              private imageService:ImageService,
              private loadingService:LoadingService,
              private alertService:AlertService
  ) {
  }

  ngAfterViewInit(): void {

  }
  sli() {
  (function($) {
    'use strict';
      $(".menu-category-slider").slick({
        slidesToShow: 6,
        slidesToScroll: 6,
        arrows: false,
        dots: false,
        infinite:false,
        responsive: [
          {
            breakpoint: 1200,
            settings: {
              slidesToShow: 6
            }
          },
          {
            breakpoint: 991,
            settings: {
              slidesToShow: 4,
            }
          },
          {
            breakpoint: 575,
            settings: {
              slidesToShow: 3,
            }
          },
          {
            breakpoint: 400,
            settings: {
              slidesToShow: 2,
            }
          },
        ]
      });
  })(jQuery);
  }
  ngOnInit(): void {
    this.loadingService.setLoading(true);
    this.categoryService.findAllCategories().subscribe(data => {
      this.categories = data;
      this.categories.push({id:this.categories.length,name:"Сите категории",description:"Сите категории",image:""});
      this.categories = this.categories.reverse();
      setTimeout(this.sli,2);
    });
    this.productsService.findAllProducts(true).subscribe(data => {
      this.products = data.reverse();
      this.filteredProducts = data.reverse().filter(a => a.available);
      this.loadingService.setLoading(false);
    });
  }
  transformData(data: Product):Product {
    return this.imageService.transformData(data);
  }

  transformDataCategory(data: Category):Category {
    return this.imageService.transformDataCategory(data);
  }

  setSelectedCategory(category: Category) {
    if(category.name == "Сите категории") {
      this.resetFilter();
    }
    else {
      this.selectedCategory = category;
      this.filteredProducts = this.products.filter(prod => prod.category.id == category.id && prod.available);
    }
  }
  openModal(product: Product) {
    const modalRef = this.modalService.open(CustomizeModalComponent);
    modalRef.componentInstance.product = product;
    modalRef.result.then((result) => {
      if (result) {
        this.addToCart(result.product,result.quantity, result.ingredients)
      }
    });
  }
  resetFilter() {
    this.filteredProducts = this.products.filter(prod => prod.available && prod.category.name == 'Пица').reverse();
    this.selectedCategory = undefined;
  }

  addToCart(product: Product, quantity?:number, ingredients?: Ingredient[]) {
    const added: boolean = this.shoppingCartService.addToCart(product,quantity || 1, ingredients || []);
    if (added) {
      this.alertService.success("Успешно додадено во кошничка!", this.options);
    } else {
      this.alertService.error("Вашата кошничка е преполна!", this.options);
    }
  }
}
