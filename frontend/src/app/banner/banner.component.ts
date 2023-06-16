import { Component } from '@angular/core';

@Component({
  selector: 'app-banner',
  templateUrl: './banner.component.html',
  styleUrls: ['./banner.component.css']
})
export class BannerComponent {
  prevSlide(): void {
    $('.banner-slider-3').slick('slickPrev');
  }

  nextSlide(): void {
    $('.banner-slider-3').slick('slickNext');
  }
}
