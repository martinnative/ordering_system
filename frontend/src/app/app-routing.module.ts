import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './Hompage/home/home.component';
import {AboutComponent} from "./Static/about/about.component";
import {ContactComponent} from "./Static/contact/contact.component";
import {MenuComponent} from "./Shop/menu/menu.component";
import {CartComponent} from "./Shop/cart/cart.component";
import {CheckoutComponent} from "./Shop/checkout/checkout.component";
import {LoginComponent} from "./Admin/login/login.component";
import {ProductSingleComponent} from "./Shop/product-single/product-single.component";
import {NotFoundComponent} from "./Static/not-found/not-found.component";
import {CreateIngredientComponent} from "./Admin/create-ingredient/create-ingredient.component";
import {CreateProductComponent} from "./Admin/create-product/create-product.component";
import {CreateCategoryComponent} from "./Admin/create-category/create-category.component";
import {AdminPanelComponent} from "./Admin/admin-panel/admin-panel.component";

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
  { path: 'admin', component: AdminPanelComponent},
  { path: 'not-found', component: NotFoundComponent},
  { path: '**', redirectTo: '/not-found' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
