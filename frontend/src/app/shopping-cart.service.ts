import {Injectable} from '@angular/core';
import {Product} from "../model/Product";
import {OrderItem} from "../model/OrderItem";
import * as CryptoJS from 'crypto-js';
import {CartItem} from "../model/CartItem";
import {ProductsService} from "./products.service";
import {forkJoin, map, Observable, of} from "rxjs";
import {Ingredient} from "../model/Ingredient";


@Injectable({
  providedIn: 'root'
})
export class ShoppingCartService {
  private cartItems: CartItem[] = [];

  private key = CryptoJS.enc.Utf8.parse("1203");
  private iv = CryptoJS.enc.Utf8.parse("1203");

  constructor(private productService: ProductsService) {
    this.loadCartItems();
  }

  addToCart(product: Product, quantity: number, notIngredients: Ingredient[]): boolean {
    const existingItem = this.cartItems.find(item => item.productId === product.id && item.notIngredients == notIngredients);
    if (existingItem) {
      existingItem.quantity += 1;
    } else {
      if (this.cartItems.length >= 8) {
        return false;
      }
      const newItem: CartItem = {
        productId: product.id,
        quantity: quantity,
        notIngredients: notIngredients,
        price: product.price
      };
      this.cartItems.push(newItem);
    }
    this.saveCartItems();
    return true;
  }

  removeFromCart(orderItem: OrderItem): Observable<OrderItem[]> {
    const index = this.cartItems.findIndex(item => item.productId === orderItem.product.id &&
      JSON.stringify(item.notIngredients) === JSON.stringify(orderItem.notIngredients) && item.quantity === orderItem.quantity);
    if (index !== -1) {
      this.cartItems.splice(index, 1);
      this.saveCartItems();
    }
    if (this.cartItems.length === 0) {
      sessionStorage.setItem('cartItems', "");
      return of([]);
    }
    return this.getOrderItems();
  }

  getNumberOfCartItems() {
    return this.cartItems.length;
  }

  getCartItems(): CartItem[] {
    this.loadCartItems();
    return this.cartItems;
  }

  getOrderItems(): Observable<OrderItem[]> {
    const orderItemObservables = this.getCartItems().map((cartItem) => {
      return this.productService.findProductById(cartItem.productId).pipe(
        map((product) => {
          const orderItem: OrderItem = {
            product: product,
            quantity: cartItem.quantity,
            notIngredients: cartItem.notIngredients
          };
          return orderItem;
        })
      );
    });
    return forkJoin(orderItemObservables);
  }

  private saveCartItems(): void {
    sessionStorage.setItem('cartItems', this.encrypt(JSON.stringify(this.cartItems)) as string)
  }

  private loadCartItems(): void {
    const storedItems = sessionStorage.getItem('cartItems');
    if (storedItems) {
      this.cartItems = JSON.parse(this.decrypt(storedItems));
    }
  }

  calculateTotal(): number {
    return this.getCartItems().map(a => a.price * a.quantity).reduce((a, b) => a + b, 0);
  }

  encrypt(message: string): String {
    const encrypted = CryptoJS.AES.encrypt(message, this.key, {
      keySize: 8 / 2,
      iv: this.iv,
      mode: CryptoJS.mode.CBC,
      padding: CryptoJS.pad.Pkcs7
    });
    return encrypted.toString();
  }

  decrypt(message: string) {
    const decrypted = CryptoJS.AES.decrypt(message, this.key, {
      keySize: 8 / 2,
      iv: this.iv,
      mode: CryptoJS.mode.CBC,
      padding: CryptoJS.pad.Pkcs7
    });
    return decrypted.toString(CryptoJS.enc.Utf8);
  }

  clearCart() {
    this.cartItems = []
    sessionStorage.setItem('cartItems','');
  }
}

