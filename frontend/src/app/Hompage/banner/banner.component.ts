import {Component, OnInit} from '@angular/core';
import {ProductsService} from "../../products.service";
import {Product} from "../../../model/Product";
import {ImageService} from "../../image.service";

@Component({
  selector: 'app-banner',
  templateUrl: './banner.component.html',
  styleUrls: ['./banner.component.css']
})
export class BannerComponent implements OnInit{
  products:Product[] = []
  responsiveOptions:any;

  constructor(private productService:ProductsService,private imageService:ImageService) {

  }
  ngOnInit(): void {
    this.productService.getBannerProducts().subscribe(data => this.products = data);
    this.responsiveOptions = [
      {
        breakpoint: '1400px',
        numVisible: 3,
        numScroll: 3
      },
      {
        breakpoint: '1220px',
        numVisible: 2,
        numScroll: 2
      },
      {
        breakpoint: '1100px',
        numVisible: 1,
        numScroll: 1
      }
    ];
  }
  transformData(data: Product):Product {
    return this.imageService.transformData(data);
  }
  prevSlide(): void {
    $('.banner-slider-3').slick('slickPrev');
  }

  nextSlide(): void {
    $('.banner-slider-3').slick('slickNext');
  }
}
