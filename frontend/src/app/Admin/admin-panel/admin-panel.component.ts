import {Component, OnInit} from '@angular/core';
import {DomSanitizer} from "@angular/platform-browser";
import {StorageService} from "../../_services/storage.service";
import {AuthService} from "../../_services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-admin-panel',
  templateUrl: './admin-panel.component.html',
  styleUrls: ['./admin-panel.component.css']
})
export class AdminPanelComponent implements OnInit{
  iFrameUrl:any ="";
  constructor(private domSanitizer:DomSanitizer,
              private storageService:StorageService,
              private authService:AuthService,
              private router: Router) {
  }
  ngOnInit(): void {
    this.iFrameUrl = this.domSanitizer.bypassSecurityTrustResourceUrl('/admin/orders');
  }
  showOrders(): void {
    this.iFrameUrl = this.domSanitizer.bypassSecurityTrustResourceUrl('/admin/orders');
  }
  showToggleSettings(): void {
    this.iFrameUrl = this.domSanitizer.bypassSecurityTrustResourceUrl('/admin/toggle');
  }
  redirectToUrl(): void {
    this.router.navigateByUrl('/auth'); // Replace '/your-url' with the desired URL
  }
  isLogggedIn(){
    return this.storageService.isLoggedIn();
  }
  hasRole(role:string){
    return localStorage.getItem('role') == role;
  }
}
