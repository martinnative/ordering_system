import {AfterViewInit, Component, OnInit} from '@angular/core';
import {CategoriesService} from '../../categories.service';
import {Category} from '../../../model/Category';
import {Product} from 'src/model/Product';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap'
import {CustomizeModalComponent} from '../../Shop/customize-modal/customize-modal.component';
import {ProductsService} from '../../products.service';
import {ShoppingCartService} from "../../shopping-cart.service";
import {Router} from "@angular/router";
import {ImageService} from "../../image.service";
import {Image} from "../../../model/Image";
import {LoadingService} from "../../loading.service";
import {AlertService} from "../../alert.service";

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

  ngOnInit(): void {
    this.loadingService.setLoading(true);
    this.categoryService.findAllCategories().subscribe(data => {
      this.categories = data;
      this.categories.push({id:this.categories.length,name:"Сите категории",description:"Сите категории",image:""});
      this.categories = this.categories.reverse();
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
      this.filteredProducts = this.products.filter(prod => prod.category.id == category.id && prod.available).reverse();
    }
  }
  openModal(product: Product) {
    const modalRef = this.modalService.open(CustomizeModalComponent);
    modalRef.componentInstance.product = product;
    modalRef.result.then((result) => {
      if (result) {
        console.log(result)
      }
    });
  }
  resetFilter() {
    this.filteredProducts = this.products.filter(prod => prod.available && prod.category.name == 'Пица').reverse();
    this.selectedCategory = undefined;
  }

  addToCart(product: Product) {
    let added:boolean = this.shoppingCartService.addToCart(product,"");
    if(added) {
      this.alertService.success("Успешно додадено во кошничка!",this.options);
    }
    else {
      this.alertService.error("Вашата кошничка е преполна!",this.options)
    }
  }
}
