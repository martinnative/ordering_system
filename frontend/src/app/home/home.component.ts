import {AfterViewInit, Component, inject, OnInit} from '@angular/core';
import 'slick-carousel';
import * as isotope from 'isotope-layout';
import * as imagesLoaded from 'imagesloaded';
import { SlimScroll} from 'angular-io-slimscroll'
import 'jquery-slimscroll/jquery.slimscroll';
import PerfectScrollbar from 'perfect-scrollbar';
import {ViewportScroller} from "@angular/common";
import {animate} from "@angular/animations";

declare var $: any;

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  private readonly viewport = inject(ViewportScroller);



  ngOnInit(): void {
    (function($) {
      'use strict';
      //BACK TO TOP

      $('.back-to-top').on('click', function() {
        $("html, body").animate({
          scrollTop: 0
        }, 600);
        return false;
      })
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
      Magnific Popup
      -------------------------------------------------------------------------------*/
      // $('.popup-youtube').magnificPop`up`({
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
    })(jQuery);
  }

  protected readonly scroll = scroll;
}
