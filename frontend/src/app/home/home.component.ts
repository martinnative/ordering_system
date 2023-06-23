import { AfterViewInit, Component, OnInit } from '@angular/core';
import 'slick-carousel';
import * as isotope from 'isotope-layout';
import * as imagesLoaded from 'imagesloaded';
import { SlickCarouselComponent } from 'ngx-slick-carousel';
import { SlimScroll} from 'angular-io-slimscroll'
import 'jquery-slimscroll/jquery.slimscroll';
import PerfectScrollbar from 'perfect-scrollbar';

declare var $: any;

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit,AfterViewInit {

  ngAfterViewInit(): void {
    $('.banner-slider-3').slick({
      dots: true,
      arrows: false,
      infinite: true,
      speed: 300,
      slidesToShow: 3,
      centerMode: true,
      adaptiveHeight: true
    });
  }

  ngOnInit(): void {
    (function($) {
      'use strict';

      /*-------------------------------------------------------------------------------
      Aside Menu
      -------------------------------------------------------------------------------*/
      $(".aside-trigger").on('click', function() {
        $(".main-aside").toggleClass('open');
      });
      $(".main-aside .menu-item-has-children > a").on('click', function(e) {
        var submenu = $(this).next(".submenu");
        e.preventDefault();
        submenu.slideToggle(200);
      })

      /*-------------------------------------------------------------------------------
      Search Trigger
      -------------------------------------------------------------------------------*/
      $(".search-trigger").on('click', function(e) {
        $(".search-form-wrapper").toggleClass('open');
      });

      /*-------------------------------------------------------------------------------
      Checkout Notices
      -------------------------------------------------------------------------------*/
      $(".ct-notice a").on('click', function(e){
        e.preventDefault();

        $(this).closest('.ct-notice').next().slideToggle();
      });

      /*-------------------------------------------------------------------------------
      Sticky Header
      -------------------------------------------------------------------------------*/
      function doSticky() {
        var header = $(".can-sticky");

        if (window.pageYOffset > 50) {
          header.addClass("sticky");
        } else {
          header.removeClass("sticky");
        }
      }
      doSticky();
      //TODO: REVIEW FOLLOWING LINES
      /*-------------------------------------------------------------------------------
      Aside Scroll
      -------------------------------------------------------------------------------*/
      function initAsideScrollbar() {
        const mainAside = $('.main-aside');
        const navbarBrand = $(".main-aside .navbar-brand");
        const asideScroll = $('.aside-scroll')[0]; // Get the DOM element

        const scrollHeight = mainAside.innerHeight()! - navbarBrand.innerHeight()!; // Calculate the height of the scroll container
        const calculatedHeight = isNaN(scrollHeight) ? "auto" : scrollHeight;

        const ps = new PerfectScrollbar(asideScroll, {
          wheelPropagation: true,
          wheelSpeed: 5,
          swipeEasing: true,
          suppressScrollX: true,
        });

        // Set the height of the PerfectScrollbar container
        $(asideScroll).height(calculatedHeight);

        // Optional: Destroy the PerfectScrollbar instance when it's no longer needed
        // ps.destroy();
      }

      initAsideScrollbar();
      /*-------------------------------------------------------------------------------
      Cart Scroll
      -------------------------------------------------------------------------------*/




      /*-------------------------------------------------------------------------------
      Tooltips
      -------------------------------------------------------------------------------*/
      // var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'))
      // tooltipTriggerList.map(function (tooltipTriggerEl) {
      //   return new bootstrap.Tooltip(tooltipTriggerEl)
      // });

      /*-------------------------------------------------------------------------------
      Magnific Popup
      -------------------------------------------------------------------------------*/
      // $('.popup-youtube').magnificPopup({
      //   type: 'iframe'
      // });
      // $('.popup-vimeo').magnificPopup({
      //   type: 'iframe'
      // });
      // $('.popup-video').magnificPopup({
      //   type: 'iframe'
      // });
      // $('.gallery-thumb').magnificPopup({
      //   type: 'image',
      //   gallery: {
      //     enabled: true
      //   },
      // });
    // TODO: FIX
      /*-------------------------------------------------------------------------------
      Banner Slider (Home 1)
      -------------------------------------------------------------------------------*/
      $(".banner-slider").slick({
        slidesToShow: 1,
        slidesToScroll: 1,
        arrows: false,
        dots: false,
        asNavFor: '.banner-slider-nav-inner',
        responsive: [{
          breakpoint: 768,
          settings: {
            arrows: false,
          }
        }]
      });

      /*-------------------------------------------------------------------------------
      Banner Slider Nav (Home 1)
      -------------------------------------------------------------------------------*/
      $(".banner-slider-nav-inner").slick({
        slidesToShow: 3,
        slidesToScroll: 1,
        arrows: true,
        dots: false,
        prevArrow: $('.banner-slider-nav .slider-prev'),
        nextArrow: $('.banner-slider-nav .slider-next'),
        asNavFor: '.banner-slider',
        focusOnSelect: true,
        responsive: [{
            breakpoint: 991,
            settings: {
              slidesToShow: 2,
            }
          },
          {
            breakpoint: 575,
            settings: {
              slidesToShow: 1,
              autoplay: true
            }
          }
        ]
      });

      /*-------------------------------------------------------------------------------
      Gallery Slider (Home 3)
      -------------------------------------------------------------------------------*/
      $(".gallery-slider").slick({
        slidesToShow: 3,
        slidesToScroll: 1,
        arrows: false,
        autoplay: true,
        autoplaySpeed: 2000,
        dots: false,
        focusOnSelect: true,
        responsive: [{
            breakpoint: 991,
            settings: {
              slidesToShow: 2,
            }
          },
          {
            breakpoint: 575,
            settings: {
              slidesToShow: 1,
            }
          }
        ]
      });


      /*-------------------------------------------------------------------------------
      Banner Slider (Home 2)
      -------------------------------------------------------------------------------*/
      $(".banner-slider-2").slick({
        slidesToShow: 1,
        slidesToScroll: 1,
        arrows: false,
        dots: true,
        responsive: [{
          breakpoint: 768,
          settings: {
            dots: false,
          }
        }]
      });

      /*-------------------------------------------------------------------------------
      Category Slider (Home 2)
      -------------------------------------------------------------------------------*/
      $(".category-slider").slick({
        slidesToShow: 1,
        slidesToScroll: 1,
        arrows: true,
        dots: false,
        prevArrow: $('.category-section .slider-prev'),
        nextArrow: $('.category-section .slider-next'),
        responsive: [{
          breakpoint: 768,
          settings: {
            dots: false,
            autoplay: true
          }
        }]
      });

      /*-------------------------------------------------------------------------------
      Banner Slider (Home 3)
      -------------------------------------------------------------------------------*/
      $(".banner-slider-3").slick({
        slidesToShow: 3,
        slidesToScroll: 1,
        arrows: true,
        dots: false,
        centerMode: true,
        prevArrow: $('.banner-3 .slider-prev'),
        nextArrow: $('.banner-3 .slider-next'),
        centerPadding: '80px',
        focusOnSelect: true,
        responsive: [{
            breakpoint: 1400,
            settings: {
              slidesToShow: 2
            }
          },
          {
            breakpoint: 991,
            settings: {
              variableWidth: false,
              centerPadding: '0px',
              centerMode: false,
              arrows: false,
              autoplay: true,
              slidesToShow: 1
            }
          }
        ]
      });
      $('.banner-slider-3').on('afterChange', function(event, slick, currentSlide, nextSlide) {
        $(".banner-3 .current-slide span").text(currentSlide + 1);
      });

      /*-------------------------------------------------------------------------------
      Related Posts slider
      -------------------------------------------------------------------------------*/
      $(".related").slick({
        slidesToShow: 2,
        slidesToScroll: 1,
        arrows: false,
        dots: true,
        responsive: [{
          breakpoint: 575,
          settings: {
            slidesToShow: 1
          }
        }]
      });

      /*-------------------------------------------------------------------------------
      Testimonials Slider (Home 1)
      -------------------------------------------------------------------------------*/
      $(".ct-testimonials-slider").slick({
        slidesToShow: 3,
        slidesToScroll: 1,
        dots: false,
        arrows: true,
        prevArrow: $('.testimonials .slider-prev'),
        nextArrow: $('.testimonials .slider-next'),
        responsive: [
          {
            breakpoint: 991,
            settings: {
              slidesToShow: 2,
            }
          },
          {
            breakpoint: 575,
            settings: {
              slidesToShow: 1,
            }
          }
        ]
      });

      /*-------------------------------------------------------------------------------
      Products Slider (Home 1)
      -------------------------------------------------------------------------------*/
      $(".product-slider").slick({
        slidesToShow: 3,
        slidesToScroll: 1,
        arrows: true,
        prevArrow: $('.products-section .slider-prev'),
        nextArrow: $('.products-section .slider-next'),
        dots: false,
        responsive: [
          {
            breakpoint: 991,
            settings: {
              slidesToShow: 2
            }
          },
          {
            breakpoint: 768,
            settings: {
              slidesToShow: 1
            }
          }
        ]
      });

      /*-------------------------------------------------------------------------------
      Menu Category Slider
      -------------------------------------------------------------------------------*/
      $(".menu-category-slider").slick({
        slidesToShow: 8,
        slidesToScroll: 3,
        arrows: false,
        dots: false,
        responsive: [
          {
            breakpoint: 1200,
            settings: {
              slidesToShow: 6
            }
          },
          {
            breakpoint: 991,
            settings: {
              slidesToShow: 4,
            }
          },
          {
            breakpoint: 575,
            settings: {
              slidesToShow: 3,
            }
          },
          {
            breakpoint: 400,
            settings: {
              slidesToShow: 2,
            }
          },
        ]
      });


      /*-------------------------------------------------------------------------------
      Add / Subtract Quantity
      -------------------------------------------------------------------------------*/
      // $(".qty span").on('click', function(){
      //   var qty = $(this).closest('.qty').find('input');
      //   var qtyVal = parseInt(qty.val()!);
      //   if($(this).hasClass('qty-add')){
      //     qty.val(qtyVal + 1);
      //   }else{
      //     return qtyVal > 1 ? qty.val(qtyVal - 1) : 0;
      //   }
      // })

      //On scroll events
      $(window).on('scroll', function() {

        doSticky();

      });

      //On resize events
      //TODO:REVIEW
      $(window).on('resize', function() {

        initAsideScrollbar();

      });

    })(jQuery);
  }

}
