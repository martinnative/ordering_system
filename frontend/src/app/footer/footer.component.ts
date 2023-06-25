import {Component, EventEmitter, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit{
  @Output() scrollEmitter = new EventEmitter<string>();
  scrollToTop() {
    this.scrollEmitter.emit();
  }
  ngOnInit(): void {
    // (function($) {
    //   'use strict';
    //   $('.back-to-top').on('click', function() {
    //     $("html, body").animate({
    //       scrollTop: 0
    //     }, 600);
    //     return false;
    //   })
    // })(jQuery);
  }
}
