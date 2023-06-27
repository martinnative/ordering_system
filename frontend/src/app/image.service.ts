import { Injectable } from '@angular/core';
import {Product} from "../model/Product";
import {DomSanitizer} from "@angular/platform-browser";

@Injectable({
  providedIn: 'root'
})
export class ImageService {
  transformData(data: Product):Product {
    let url = `data:image/png;base64,${data.image}`;
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
  constructor(private sanitizer:DomSanitizer) { }
}
