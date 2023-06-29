import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Product} from 'src/model/Product';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor(private http: HttpClient) {
  }

  findAllProducts(thumbnail:Boolean): Observable<Product[]> {
    return this.http.get<Product[]>(`/api/products?thumbnail=${thumbnail}`);
  }
  findProductById(productId: Number): Observable<Product> {
    return this.http.get<Product>(`/api/products/${productId}`);
  }
  getBannerProducts(): Observable<Product[]> {
    return this.http.get<Product[]>('/api/products/banner');
  }
}
