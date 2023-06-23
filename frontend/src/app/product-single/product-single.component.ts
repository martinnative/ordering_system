import { Component, OnInit } from '@angular/core';
import { Product } from "../../model/Product";
import { ProductsService } from "../products.service";
import { ActivatedRoute } from "@angular/router";
import {filter, map, mergeMap, tap} from "rxjs";

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
    this.productsService.findProductById(1);
    this.route.paramMap.pipe(
      filter(params => params.has("id")),
      map(param => +param.get("id")!),
      mergeMap(p => this.productsService.findProductById(p)),
      tap(data => console.log(data))
    )
      .subscribe(data => this.product = data);
  }
}
