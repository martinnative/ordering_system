import { Injectable } from '@angular/core';
import {Product} from "../model/Product";
import {DomSanitizer} from "@angular/platform-browser";
import {HttpClient} from "@angular/common/http";
import {Image} from "../model/Image";
import {Category} from "../model/Category";
import {Ingredient} from "../model/Ingredient";
import {Order} from "../model/Order";
import {OrderItem} from "../model/OrderItem";

@Injectable({
  providedIn: 'root'
})
export class ImageService {
  constructor(private sanitizer:DomSanitizer,private http:HttpClient) { }

  transformData(data: Product):Product {
    let url = `data:image/png;base64,${data.image.bytes}`;
    let image = this.sanitizer.bypassSecurityTrustUrl(url);
    return {
      id:data.id,
      name:data.name,
      ingredients:data.ingredients,
      price:data.price,
      description:data.description,
      customizable:data.customizable,
      image:image,
      category:data.category,
      available:data.available
    } as Product
  }

  transformDataCategory(data: Category):Category {
    let url = `data:image/png;base64,${data.image.bytes}`;
    let image = this.sanitizer.bypassSecurityTrustUrl(url);
    return {
      id:data.id,
      name:data.name,
      description:data.description,
      image:image,
    } as Category
  }
  transformIngredient(data: Ingredient):Ingredient {
    let url = `data:image/png;base64,${data.image.bytes}`;
    let image = this.sanitizer.bypassSecurityTrustUrl(url);
    return {
      id:data.id,
      name:data.name,
      image:image,
    } as Ingredient
  }
  transformDataOrderItem(data: OrderItem): OrderItem {
    let url = `data:image/png;base64,${data.productImage.bytes}`;
    let image = this.sanitizer.bypassSecurityTrustUrl(url);
    return {
      productId: data.productId,
      productName: data.productName,
      price:data.price,
      description:data.description,
      productImage: image,
      notIngredients:data.notIngredients,
      quantity:data.quantity,
      categoryName: data.categoryName,
      pizzaNumber: data.pizzaNumber
    } as OrderItem
  }

  saveImage(formData:FormData) {
    return this.http.post<Image>("/api/images/save",formData);
  }
}
