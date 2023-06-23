import { Component, OnInit } from '@angular/core';
import { Product } from "../../model/Product";
import { ProductsService } from "../products.service";
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: 'app-product-single',
  templateUrl: './product-single.component.html',
  styleUrls: ['./product-single.component.css']
})
export class ProductSingleComponent implements OnInit {

  product: Product | undefined = undefined;
  _id: String = "";

  constructor(
    private route: ActivatedRoute,
    private productsService: ProductsService
  ) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this._id = params['id'];
      this.productsService.findProductById(this._id).subscribe(product => {
        this.product = product;
      });
    });
  }
}
