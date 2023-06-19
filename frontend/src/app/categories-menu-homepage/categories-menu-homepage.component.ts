import { AfterViewInit, Component, OnInit } from '@angular/core';
import { CategoriesService } from '../categories.service';
import { Category } from '../../model/Category';
import { Product } from 'src/model/Product';
import { NgbModal} from '@ng-bootstrap/ng-bootstrap'
import { CustomizeModalComponent } from '../customize-modal/customize-modal.component';
import { ProductsService } from '../products.service';
@Component({
  selector: 'app-categories-menu-homepage',
  templateUrl: './categories-menu-homepage.component.html',
  styleUrls: ['./categories-menu-homepage.component.css']
})
export class CategoriesMenuHomepageComponent implements OnInit,AfterViewInit{
  categories:Category[] = [];
  products: Product[] = [];
  filteredProducts: Product[] = [];
  selectedCategory:Category|undefined = undefined;
  
  constructor(private categoryService:CategoriesService,
    private modalService:NgbModal,
    private productsService:ProductsService
    ) {}
  ngAfterViewInit(): void {
  }
  
  ngOnInit(): void {
    this.categoryService.findAllCategories().subscribe(data => this.categories = data);
    this.productsService.findAllProducts().subscribe(data => {
      this.products = data;
      this.filteredProducts = data;
    });
  }
  setSelectedCategory(category:Category) {
    this.selectedCategory = category;
    this.filteredProducts = this.products.filter(prod => prod.category.id == category.id);
  }
  openModal(product:Product) {
    const modalRef = this.modalService.open(CustomizeModalComponent);
    modalRef.componentInstance.product = product;
    modalRef.result.then((result) => {
      if(result) {
        console.log(result)
      }
    });
  }
  resetFilter() {
    this.filteredProducts = this.products;
  }
}
