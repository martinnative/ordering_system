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
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SlickCarouselModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
