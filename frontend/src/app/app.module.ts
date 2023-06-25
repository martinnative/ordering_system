import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { InfographicsComponent } from './infographics/infographics.component';
import { FooterComponent } from './footer/footer.component';
import { InstagramComponent } from './instagram/instagram.component';
import { HowWeDoItComponent } from './how-we-do-it/how-we-do-it.component';
import { MakeYourOwnPizzaComponent } from './make-your-own-pizza/make-your-own-pizza.component';
import { BannerComponent } from './banner/banner.component';
import { AboutComponent } from './about/about.component';
import { MenuComponent } from './menu/menu.component';
import { ContactComponent } from './contact/contact.component';
import { HeaderComponent } from './header/header.component';
import { MobileNavigationComponent } from './mobile-navigation/mobile-navigation.component';
import { CartComponent } from './cart/cart.component';
import { FloatingCartComponent } from './floating-cart/floating-cart.component';
import { SearchFormComponent } from './search-form/search-form.component';
import {CommonModule, NgOptimizedImage} from "@angular/common";
import { CategoriesMenuHomepageComponent } from './categories-menu-homepage/categories-menu-homepage.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { CustomizeModalComponent } from './customize-modal/customize-modal.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { PreloaderComponent } from './preloader/preloader.component';
import { HeaderTransparentComponent } from './header-transparent/header-transparent.component';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap'
import {FormsModule } from '@angular/forms'
import { RouterModule } from '@angular/router';
import { LoadingInterceptor } from './loading.interceptor';
import { NgScrollbarModule} from "ngx-scrollbar";
import { LoginComponent } from './login/login.component';
import { ProductSingleComponent } from './product-single/product-single.component';
import { NotFoundComponent } from './not-found/not-found.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    InfographicsComponent,
    FooterComponent,
    InstagramComponent,
    HowWeDoItComponent,
    MakeYourOwnPizzaComponent,
    BannerComponent,
    AboutComponent,
    MenuComponent,
    ContactComponent,
    HeaderComponent,
    MobileNavigationComponent,
    CartComponent,
    FloatingCartComponent,
    SearchFormComponent,
    CustomizeModalComponent,
    CheckoutComponent,
    PreloaderComponent,
    HeaderTransparentComponent,
    CategoriesMenuHomepageComponent,
    LoginComponent,
    ProductSingleComponent,
    NotFoundComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgOptimizedImage,
    HttpClientModule,
    MatButtonModule,
    MatDialogModule,
    BrowserAnimationsModule,
    FormsModule,
    RouterModule,
    CommonModule,
    NgbModule,
    NgScrollbarModule,
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS, useClass: LoadingInterceptor, multi:true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
