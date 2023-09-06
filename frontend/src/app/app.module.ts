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
import {CommonModule, NgOptimizedImage} from "@angular/common";
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
import { LazyLoadImageModule } from 'ng-lazyload-image';
import {AlertModule} from "./alert.module";
import {OrderSucessComponent} from "./Shop/order-sucess/order-sucess.component";
import {HttpRequestInterceptor} from "./_helpers/http.interceptor";
import {IMqttServiceOptions, MqttModule} from "ngx-mqtt";

// const socketConfig: SocketIoConfig = { url: 'http://localhost:8080/ws', options: {} };

const certificate = `-----BEGIN CERTIFICATE-----
MIIFJDCCBAygAwIBAgISBOfox8CbMIVdK2Q5Lb0w1t4yMA0GCSqGSIb3DQEBCwUA
MDIxCzAJBgNVBAYTAlVTMRYwFAYDVQQKEw1MZXQncyBFbmNyeXB0MQswCQYDVQQD
EwJSMzAeFw0yMzA3MjcwNTI0MTJaFw0yMzEwMjUwNTI0MTFaMB8xHTAbBgNVBAMT
FGNvbnNvbGUuaGl2ZW1xLmNsb3VkMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIB
CgKCAQEA1zAuyj2nz2w2stp2q0qmb+bZ/ytNLXeVXBmznTxhtP4+XyhU+j7WapH1
u9Dpk++Aygnq/Z5/8gsO+IrdZ1ND3iUC1zRPJw1cPWTJPpsBLvoeG72eWmC3rSEf
bKBqqR9hbUB70LPmsUO0H8nlnlAUN43Ol3pT/BOhPb92Oy0zKj9EpKw/2trzZMYu
ci6UUt8Z/z+TiKAocsP84PfXt9N1JHy76L44v3L4kSc33fM1rIwHtBzJ5x/K1hrj
Uvd1MxBWJERwpG7RPWRbcIo2rDE4DGEmYJuU9C9beAO4gcVY0bw//i63A1BZImwH
mULM/z4Vbk+/CMXFPhKvV1sNfpzgxQIDAQABo4ICRTCCAkEwDgYDVR0PAQH/BAQD
AgWgMB0GA1UdJQQWMBQGCCsGAQUFBwMBBggrBgEFBQcDAjAMBgNVHRMBAf8EAjAA
MB0GA1UdDgQWBBSipG82qkK3/rCKWplRHy90ZLfRkzAfBgNVHSMEGDAWgBQULrMX
t1hWy65QCUDmH6+dixTCxjBVBggrBgEFBQcBAQRJMEcwIQYIKwYBBQUHMAGGFWh0
dHA6Ly9yMy5vLmxlbmNyLm9yZzAiBggrBgEFBQcwAoYWaHR0cDovL3IzLmkubGVu
Y3Iub3JnLzBOBgNVHREERzBFghRjb25zb2xlLmhpdmVtcS5jbG91ZIItZnJvbnRl
bmQuY29uc29sZS5wb3J0YWwuZXVjMS5hd3MuaGl2ZW1xLmNsb3VkMBMGA1UdIAQM
MAowCAYGZ4EMAQIBMIIBBAYKKwYBBAHWeQIEAgSB9QSB8gDwAHYAejKMVNi3LbYg
6jjgUh7phBZwMhOFTTvSK8E6V6NS61IAAAGJlgTsLwAABAMARzBFAiEAsZoBAtKw
fY/yvfjD4OUsmpOMKc4X28DQXHs4Au2bgSECICcILgxOMvrf4VxCqYwB4y0lh98E
JjE0SwOIGwRWZUPxAHYAtz77JN+cTbp18jnFulj0bF38Qs96nzXEnh0JgSXttJkA
AAGJlgTsLgAABAMARzBFAiEAoCCmEW56BUwbArQuGXt/MNm8g7G0r/JoSigmpggA
gTkCIDHHYj6MQJPPugn8SIDrhDgxWaBtAX2Q400z33r9SCKeMA0GCSqGSIb3DQEB
CwUAA4IBAQAtVpF+9Dj6cO/4qc4nJuHIFQX4Rt22Sv8TUVb18AIq8hkfnGjjVN00
KBxVNNgDML/ZiM9bv4AZCEk4kegyXUnZ0i5ifu9+sP69B3qOh5KqdYoWVaV+MOe0
fxrE5GzZJG6QWHc6AggXpTTt4kv2DSMwlT8kP3E+UhP8id0BbNq9XlBjjFiFNFJ/
yTNbbXjHJ3BexAplYnYoWqviW1HLjQ6DZqyMr6LV3K8LhBo0ysNQWdtad+ikUr/s
JDFA44fdNS9WWiF7PoWWnGOrsU0EqXCduAFyBRRNHPNXf7/CEyzMAKqZvbMRVIZC
fmO+S2YZTESF7oXc/eNi6DLIPwsRwmDA
-----END CERTIFICATE-----
`
const MQTT_SERVICE_OPTIONS: IMqttServiceOptions = {
  protocol: 'wss',
  hostname: '0e2b872d30104e009127c52455bcd6be.s2.eu.hivemq.cloud',
  port: 8884,
  username: 'dragan',
  password: 'Dragan12345Dd',
  rejectUnauthorized: true,
  clientId:'Tester1',
  path:'/mqtt',
  cert:certificate
}

@NgModule({
  declarations: [
    OrderSucessComponent,
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
    AlertModule,
    MqttModule.forRoot(MQTT_SERVICE_OPTIONS),
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: HttpRequestInterceptor, multi: true },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
