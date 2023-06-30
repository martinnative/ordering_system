import {Component, OnInit} from '@angular/core';
import {DomSanitizer} from "@angular/platform-browser";

@Component({
  selector: 'app-admin-panel',
  templateUrl: './admin-panel.component.html',
  styleUrls: ['./admin-panel.component.css']
})
export class AdminPanelComponent implements OnInit{
  iFrameUrl:any ="";
  constructor(private domSanitizer:DomSanitizer) {
  }
  ngOnInit(): void {
    this.iFrameUrl = this.domSanitizer.bypassSecurityTrustResourceUrl('/admin/orders');
  }
  showOrders(): void {
    this.iFrameUrl = this.domSanitizer.bypassSecurityTrustResourceUrl('/admin/orders');
  }
}
