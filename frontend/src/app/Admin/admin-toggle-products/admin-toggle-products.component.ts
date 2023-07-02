import { Component } from '@angular/core';
import { Product } from "../../../model/Product";
import { CategoriesService } from "../../categories.service";
import { ProductsService } from "../../products.service";
import { NgbModal } from "@ng-bootstrap/ng-bootstrap";
import { ImageService } from "../../image.service";
import { Category } from "../../../model/Category";
import {LoadingService} from "../../loading.service";

@Component({
  selector: 'app-admin-toggle-products',
  templateUrl: './admin-toggle-products.component.html',
  styleUrls: ['./admin-toggle-products.component.css']
})
export class AdminToggleProductsComponent {
  products: Product[] = [];
  categories: Category[] = [];
  selectedCategoryId: string = '';
  filteredProducts: Product[] = [];

  constructor(
    private productsService: ProductsService,
    private modalService: NgbModal,
    private imageService: ImageService,
    private categoryService: CategoriesService,
    private loadingService: LoadingService
  ) { }

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

  productAvailabilityChanged(product: Product) {
    this.loadingService.setLoading(true);
    this.productsService.changeProductAvailability(product).subscribe(data => {
      this.products = data;
      this.loadingService.setLoading(false);
    });
  }

  categoryChanged(categoryId: string) {
    this.selectedCategoryId = categoryId;
    this.filterProducts();
  }

  filterProducts() {
    if (this.selectedCategoryId) {
      this.filteredProducts = this.products
        .filter(product => product.category.id.toString() === this.selectedCategoryId);
    } else {
      this.filteredProducts = this.products;
    }
  }
}
