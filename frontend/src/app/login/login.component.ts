import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  scrollToTop(el:HTMLElement) {
    el.scrollIntoView({behavior:"smooth"});
  }
}
