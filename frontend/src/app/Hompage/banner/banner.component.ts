import {Component, OnInit} from '@angular/core';
import {ProductsService} from "../../products.service";
import {Product} from "../../../model/Product";

@Component({
  selector: 'app-banner',
  templateUrl: './banner.component.html',
  styleUrls: ['./banner.component.css']
})
export class BannerComponent implements OnInit{
  products:Product[] = []
  constructor(private productService:ProductsService) {

  }
  ngOnInit(): void {
  }
  prevSlide(): void {
    $('.banner-slider-3').slick('slickPrev');
  }

  nextSlide(): void {
    $('.banner-slider-3').slick('slickNext');
  }
}
