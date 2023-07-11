import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './Hompage/home/home.component';
import { InfographicsComponent } from './Hompage/infographics/infographics.component';
import { FooterComponent } from './Navigation/footer/footer.component';
import { InstagramComponent } from './Hompage/instagram/instagram.component';
import { HowWeDoItComponent } from './Hompage/how-we-do-it/how-we-do-it.component';
import { BannerComponent } from './Hompage/banner/banner.component';
import { AboutComponent } from './Static/about/about.component';
import { MenuComponent } from './Shop/menu/menu.component';
import { ContactComponent } from './Static/contact/contact.component';
import { HeaderComponent } from './Navigation/header/header.component';
import { MobileNavigationComponent } from './Navigation/mobile-navigation/mobile-navigation.component';
import { CartComponent } from './Shop/cart/cart.component';
import { FloatingCartComponent } from './Shop/floating-cart/floating-cart.component';
import { SearchFormComponent } from './Navigation/search-form/search-form.component';
import {CommonModule, NgIf, NgOptimizedImage} from "@angular/common";
import { CategoriesMenuHomepageComponent } from './Hompage/categories-menu-homepage/categories-menu-homepage.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { CustomizeModalComponent } from './Shop/customize-modal/customize-modal.component';
import { CheckoutComponent } from './Shop/checkout/checkout.component';
import { PreloaderComponent } from './Navigation/preloader/preloader.component';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap'
import {FormsModule, ReactiveFormsModule} from '@angular/forms'
import { RouterModule } from '@angular/router';
import { LoadingInterceptor } from './loading.interceptor';
import { NgScrollbarModule} from "ngx-scrollbar";
import { LoginComponent } from './Admin/login/login.component';
import { ProductSingleComponent } from './Shop/product-single/product-single.component';
import { NotFoundComponent } from './Static/not-found/not-found.component';
import { CreateProductComponent } from './Admin/create-product/create-product.component';
import { CreateIngredientComponent } from './Admin/create-ingredient/create-ingredient.component';
import { CreateCategoryComponent } from './Admin/create-category/create-category.component';
import { CreateUserComponent } from './Admin/create-user/create-user.component';
import {ButtonModule} from "primeng/button";
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CarouselModule } from 'primeng/carousel';
import { AdminPanelComponent } from './Admin/admin-panel/admin-panel.component';
import { AdminOrdersComponent } from './Admin/admin-orders/admin-orders.component';
import { AdminToggleProductsComponent } from './Admin/admin-toggle-products/admin-toggle-products.component';
import {httpInterceptorProviders} from "./_helpers/http.interceptor";
import { LazyLoadImageModule } from 'ng-lazyload-image';
import {AlertModule} from "./alert.module";



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    InfographicsComponent,
    FooterComponent,
    InstagramComponent,
    HowWeDoItComponent,
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
    CategoriesMenuHomepageComponent,
    LoginComponent,
    ProductSingleComponent,
    NotFoundComponent,
    CreateProductComponent,
    CreateIngredientComponent,
    CreateCategoryComponent,
    CreateUserComponent,
    AdminPanelComponent,
    AdminOrdersComponent,
    AdminToggleProductsComponent,
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
    ReactiveFormsModule,
    CarouselModule,
    ButtonModule,
    LazyLoadImageModule,
    AlertModule
  ],
  providers: [
    httpInterceptorProviders,
    LoadingInterceptor,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
