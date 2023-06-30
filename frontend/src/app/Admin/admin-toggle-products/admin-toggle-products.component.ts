import { Component } from '@angular/core';
import { Product } from "../../../model/Product";
import { CategoriesService } from "../../categories.service";
import { ProductsService } from "../../products.service";
import { NgbModal } from "@ng-bootstrap/ng-bootstrap";
import { ImageService } from "../../image.service";
import { Category } from "../../../model/Category";

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
    private categoryService: CategoriesService
  ) { }

  ngOnInit(): void {
    this.productsService.findAllProducts(true).subscribe(data => {
      this.products = data;
      this.filteredProducts = data; // Initialize filteredProducts with all products
    });

    this.categoryService.findAllCategories().subscribe(data => {
      this.categories = data;
    });
  }

  transformData(data: Product): Product {
    return this.imageService.transformData(data);
  }

  productAvailabilityChanged(product: Product) {
    product.available = !product.available;
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
