import { Component, OnInit } from '@angular/core';
import { Product } from "../../../model/Product";
import { ProductsService } from "../../products.service";
import { ActivatedRoute } from "@angular/router";
import {filter, map, mergeMap, tap} from "rxjs";
import {ImageService} from "../../image.service";
import {ShoppingCartService} from "../../shopping-cart.service";
import {NgbActiveModal, NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {CustomizeModalComponent} from "../customize-modal/customize-modal.component";
import {Ingredient} from "../../../model/Ingredient";
import {AlertService} from "../../alert.service";
import {FloatingCartComponent} from "../floating-cart/floating-cart.component";

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
  ingredients1:Ingredient[] = [];
  ingredients: String[] = [];



    options = {
    autoClose: true,
    keepAfterRouteChange: false
  };

  constructor(
    private route: ActivatedRoute,
    private productsService: ProductsService,
    private imageService: ImageService,
    private shoppingCartService: ShoppingCartService,
    private modalService: NgbModal,
    private alertService: AlertService,
  ) { }

  ngOnInit(): void {
    this.productsService.findProductById(1);
    this.route.paramMap.pipe(
      filter(params => params.has("id")),
      map(param => +param.get("id")!),
      mergeMap(p => this.productsService.findProductById(p))
    )
      .subscribe(data => this.product = data);
    this.productsService.findAllProducts(true).subscribe(products => {
      this.products = products;
    });
  }
  sanitizeImage(product:Product):Product {
    return this.imageService.transformData(product);
  }
  addToCart(product: Product, quantity?:number, ingredients?: Ingredient[]) {
    if (ingredients){
      var added: boolean = this.shoppingCartService.addToCart(product,quantity || 1, ingredients);
    }
    else {
       added = this.shoppingCartService.addToCart(product,quantity || 1, this.ingredients1);
    }
    if (added) {
      this.alertService.success("Успешно додадено во кошничка!", this.options);
    } else {
      this.alertService.error("Вашата кошничка е преполна!", this.options);
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

  transformDataIngredient(data: Ingredient):Ingredient {
    return this.imageService.transformIngredient(data);
  }

  protected readonly undefined = undefined;

  toggleSelection(ingredientName: String): void {
    if (this.ingredients.includes(ingredientName)) {
      this.ingredients = this.ingredients.filter(name => name !== ingredientName);
    } else {
      this.ingredients.push(ingredientName);
    }
  }
}
