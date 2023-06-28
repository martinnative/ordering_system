import {AfterViewInit, Component, OnInit} from '@angular/core';
import {CategoriesService} from '../categories.service';
import {Category} from '../../model/Category';
import {Product} from 'src/model/Product';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap'
import {CustomizeModalComponent} from '../customize-modal/customize-modal.component';
import {ProductsService} from '../products.service';
import {ShoppingCartService} from "../shopping-cart.service";
import {Router} from "@angular/router";
import {ImageService} from "../image.service";

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

  constructor(private categoryService: CategoriesService,
              private modalService: NgbModal,
              private productsService: ProductsService,
              private shoppingCartService: ShoppingCartService,
              private router:Router,
              private imageService:ImageService
  ) {
  }

  ngAfterViewInit(): void {
  }

  ngOnInit(): void {
    this.categoryService.findAllCategories().subscribe(data => {
      this.categories = data;
      this.categories.push({id:this.categories.length,name:"Сите категории",description:"Сите категории"});
      this.categories = this.categories.reverse();
    });
    this.productsService.findAllProducts().subscribe(data => {
      this.products = data;
      this.filteredProducts = data.sort((a,b) => Number(b.available) - Number(a.available));
    });
  }
  transformData(data: Product):Product {
    return this.imageService.transformData(data);
  }
  setSelectedCategory(category: Category) {
    if(category.name == "Сите категории") {
      this.resetFilter();
    }
    else {
      this.selectedCategory = category;
      this.filteredProducts = this.products.filter(prod => prod.category.id == category.id).sort((a,b) => Number(b.available) - Number(a.available));
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
    this.filteredProducts = this.products;
    this.selectedCategory = undefined;
  }

  addToCart(product: Product) {
    this.shoppingCartService.addToCart(product);
  }
}
