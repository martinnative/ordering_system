import {HttpClient, HttpParams} from '@angular/common/http';
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
  changeProductAvailability(product:Product): Observable<Product[]> {
    let params = new HttpParams().set('id',product.id.toString());
    return this.http.put<Product[]>('/api/products/availability',null,{params:params});
  }
}
