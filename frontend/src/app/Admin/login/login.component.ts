import { Component } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {StorageService} from "../../_services/storage.service";
import {AuthService} from "../../_services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  loginForm = new FormGroup({
    username: new FormControl<string>("", Validators.required),
    password: new FormControl<string>("", Validators.required),
  });
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];
  constructor(private authService: AuthService,
              private storageService: StorageService,
              private router:Router
              ) { }
  ngOnInit(): void {
    if (this.storageService.isLoggedIn()) {
      this.isLoggedIn = true;
      this.roles = this.storageService.getUser().roles;
    }
  }
  onSubmit(): void {
    const username = this.loginForm.get('username')!.value!;
    const password = this.loginForm.get('password')!.value!;

    this.authService.login(username, password).subscribe({
      next: data => {
        this.authService.loadProfile(data);
        this.router.navigateByUrl("/admin")
        // this.storageService.saveUser(data);
        // this.isLoginFailed = false;
        // this.isLoggedIn = true;
        // this.roles = this.storageService.getUser().roles;
        // this.reloadPage();
      },
      error: err => {
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
      }
    });
  }

  reloadPage(): void {
    window.location.reload();
  }

  scrollToTop(el:HTMLElement) {
    el.scrollIntoView({behavior:"smooth"});
  }
}
