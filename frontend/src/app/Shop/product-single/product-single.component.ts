import { Component, OnInit } from '@angular/core';
import { Product } from "../../../model/Product";
import { ProductsService } from "../../products.service";
import { ActivatedRoute } from "@angular/router";
import {filter, map, mergeMap, tap} from "rxjs";
import {ImageService} from "../../image.service";
import {ShoppingCartService} from "../../shopping-cart.service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {CustomizeModalComponent} from "../customize-modal/customize-modal.component";
import {Ingredient} from "../../../model/Ingredient";
import {AlertService} from "../../alert.service";

@Component({
  selector: 'app-product-single',
  templateUrl: './product-single.component.html',
  styleUrls: ['./product-single.component.css']
})
export class ProductSingleComponent implements OnInit {

  product: Product | undefined = undefined;
  products: Product[] = [];
  _id: String = "";
  quantity:number = 1;

  options = {
    autoClose: true,
    keepAfterRouteChange: false
  };

  constructor(
    private route: ActivatedRoute,
    private productsService: ProductsService,
    private imageService: ImageService,
    private shoppingCartService: ShoppingCartService,
    private productService:ProductsService,
    private modalService: NgbModal,
    private alertService: AlertService

  ) { }

  ngOnInit(): void {
    this.productsService.findProductById(1);
    this.route.paramMap.pipe(
      filter(params => params.has("id")),
      map(param => +param.get("id")!),
      mergeMap(p => this.productsService.findProductById(p)),
      tap(data => console.log(data))
    )
      .subscribe(data => this.product = data);
    this.productsService.findAllProducts(true).subscribe(products => {
      this.products = products;
    });
  }
  sanitizeImage(product:Product):Product {
    return this.imageService.transformData(product);
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
  transformDataIngredient(data: Ingredient):Ingredient {
    return this.imageService.transformIngredient(data);
  }
}
