import { Injectable } from '@angular/core';
import {Product} from "../model/Product";
import {DomSanitizer} from "@angular/platform-browser";
import {HttpClient} from "@angular/common/http";
import {Image} from "../model/Image";

@Injectable({
  providedIn: 'root'
})
export class ImageService {
  constructor(private sanitizer:DomSanitizer,private http:HttpClient) { }

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
  saveImage(formData:FormData) {
    return this.http.post<Image>("/api/images/save",formData);
  }
}
