import {Component, EventEmitter, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent{
  @Output() scrollEmitter = new EventEmitter<string>();
  scrollToTop() {
    this.scrollEmitter.emit();
  }
}
