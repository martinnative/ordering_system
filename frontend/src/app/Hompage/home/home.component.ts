import {Component, inject, OnInit} from '@angular/core';
import 'slick-carousel';
import 'jquery-slimscroll/jquery.slimscroll';
import PerfectScrollbar from 'perfect-scrollbar';
import {ViewportScroller} from "@angular/common";

declare var $: any;

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  private readonly viewport = inject(ViewportScroller);

  scrollToTop(el: HTMLElement) {
    el.scrollIntoView({behavior: "smooth"});
  }

  ngOnInit(): void {
  }
}
