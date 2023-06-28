import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import {AboutComponent} from "./about/about.component";
import {ContactComponent} from "./contact/contact.component";
import {MenuComponent} from "./menu/menu.component";
import {CartComponent} from "./cart/cart.component";
import {CheckoutComponent} from "./checkout/checkout.component";
import {LoginComponent} from "./login/login.component";
import {ProductSingleComponent} from "./product-single/product-single.component";
import {NotFoundComponent} from "./not-found/not-found.component";
import {CreateIngredientComponent} from "./create-ingredient/create-ingredient.component";
import {CreateProductComponent} from "./create-product/create-product.component";
import {CreateCategoryComponent} from "./create-category/create-category.component";

const routes: Routes = [
  { path: '', component:HomeComponent },
  { path: 'about', component: AboutComponent},
  { path: 'contact', component: ContactComponent},
  { path: 'menu', component: MenuComponent},
  { path: 'cart', component: CartComponent},
  { path: 'checkout', component: CheckoutComponent},
  { path: 'auth', component: LoginComponent},
  { path: 'product/:id', component: ProductSingleComponent},
  { path: 'create-ingredient', component: CreateIngredientComponent},
  { path: 'create-product', component: CreateProductComponent},
  { path: 'create-category', component: CreateCategoryComponent},
  { path: 'not-found', component: NotFoundComponent},
  { path: '**', redirectTo: '/not-found' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
