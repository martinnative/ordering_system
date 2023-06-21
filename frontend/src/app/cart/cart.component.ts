import { Component } from '@angular/core';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent {
  quantity:number = 1;

  subQuantity() {
    if(this.quantity>0) {
      this.quantity--;
    }
  }
  save() {
    if(this.quantity < 0 || isNaN(this.quantity)) {
      this.quantity = 1;
    }
  }

}
