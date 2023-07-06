import { Component } from '@angular/core';
import { Product } from "../../../model/Product";
import { CategoriesService } from "../../categories.service";
import { ProductsService } from "../../products.service";
import { NgbModal } from "@ng-bootstrap/ng-bootstrap";
import { ImageService } from "../../image.service";
import { Category } from "../../../model/Category";
import {LoadingService} from "../../loading.service";
import {StorageService} from "../../_services/storage.service";
import {AuthService} from "../../_services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-admin-toggle-products',
  templateUrl: './admin-toggle-products.component.html',
  styleUrls: ['./admin-toggle-products.component.css']
})
export class AdminToggleProductsComponent {
  products: Product[] = [];
  categories: Category[] = [];
  //selectedCategoryId: string = '';
  filteredProducts: Product[] = [];

  constructor(
    private productsService: ProductsService,
    private modalService: NgbModal,
    private imageService: ImageService,
    private categoryService: CategoriesService,
    private loadingService: LoadingService,
    private storageService:StorageService,
    private authService:AuthService,private router: Router) { }

  ngOnInit(): void {
    this.loadingService.setLoading(true);
    this.categoryService.findAllCategories().subscribe(data => {
      this.categories = data;
    });
    this.productsService.findAllProducts(true).subscribe(data => {
      this.products = data;
      this.filteredProducts = data; // Initialize filteredProducts with all products
      this.loadingService.setLoading(false);
    });
  }

  transformData(data: Product): Product {
    return this.imageService.transformData(data);
  }
  // transformDataCategory(data: Category): Category {
  //   return this.imageService.transformDataCategory(data);
  // }

  productAvailabilityChanged(product: Product) {
    this.loadingService.setLoading(true);
    this.productsService.changeProductAvailability(product).subscribe(data => {
      this.products = data;
      this.loadingService.setLoading(false);
    });
  }

  // categoryChanged(categoryId: string) {
  //   this.selectedCategoryId = categoryId;
  //   this.filterProducts();
  // }
  //
  // filterProducts() {
  //   if (this.selectedCategoryId) {
  //     this.filteredProducts = this.products
  //       .filter(product => product.category.id.toString() === this.selectedCategoryId);
  //   } else {
  //     this.filteredProducts = this.products;
  //   }
  // }

  showAllCategories() {
    this.filteredProducts = this.products;
  }

  showPizzaCategories() {
    this.filteredProducts = this.products.filter(a => a.category.name=="Пица");

  }

  showLadniCategories() {
    this.filteredProducts = this.products.filter(a => a.category.name=="Ладни пијалоци");
  }

  showPivoCategories() {
    this.filteredProducts = this.products.filter(a => a.category.name=="Пиво");
  }

  showZhestokoCategories() {
    this.filteredProducts = this.products.filter(a => a.category.name=="Жестоко");
  }
  redirectToUrl(): void {
    this.router.navigateByUrl('/auth'); // Replace '/your-url' with the desired URL
  }
  isLogggedIn(){
    return this.storageService.isLoggedIn();
  }
  hasRole(role:string){
    return localStorage.getItem('role') == role;
  }
}
