import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { SlickCarouselModule } from 'ngx-slick-carousel';
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
import {NgOptimizedImage} from "@angular/common";
import { CategoriesMenuHomepageComponent } from './categories-menu-homepage/categories-menu-homepage.component';
import { HttpClientModule } from '@angular/common/http';

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
    CategoriesMenuHomepageComponent,
    AboutComponent,
    MenuComponent,
    ContactComponent,
    HeaderComponent,
    MobileNavigationComponent,
    CartComponent,
    FloatingCartComponent,
    SearchFormComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SlickCarouselModule,
    NgOptimizedImage,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
