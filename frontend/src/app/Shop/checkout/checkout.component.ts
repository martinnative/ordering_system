import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ShoppingCartService } from "../../shopping-cart.service";
import { OrderItem } from "../../../model/OrderItem";
import { OrdersService } from "../../orders.service";
import {Router} from "@angular/router";
import Swal from "sweetalert2";

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {
  orderForm!: FormGroup;
  orderItems: OrderItem[] = [];
  isFormSubmitted = false;
  constructor(
    private formBuilder: FormBuilder,
    private shoppingCartService: ShoppingCartService,
    private ordersService: OrdersService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.shoppingCartService.getOrderItems().subscribe(data => this.orderItems = data);
    this.orderForm = this.formBuilder.group({
      fname: ['', Validators.required],
      lname: ['', Validators.required],
      phone: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]]
    });
  }

  getTotalFromCart(): Number {
    return this.shoppingCartService.calculateTotal();
  }

  scrollToTop(el: HTMLElement) {
    el.scrollIntoView({ behavior: "smooth" });
  }

  createOrder() {
    if(this.orderItems.length == 0) {
      Swal.fire('Грешка!', 'Немате производи во кошничката', 'error');
    }
    else {
      this.isFormSubmitted = true;
      if (this.orderForm.valid) {
        const { fname, lname, email, phone } = this.orderForm.value;

        this.ordersService.createOrder(this.orderItems, fname, lname, email, phone).subscribe({
          next: (response) => {
            // Handle the successful creation of the order
            this.shoppingCartService.clearCart()
            // Optionally, you can perform additional actions such as showing a success message or redirecting to a confirmation page
            this.router.navigate(['/order-success'], { queryParams: { orderId: response.id } });
          },
          error: (error) => {
            // Handle the error if the order creation fails
            console.error('Error creating order:', error);
            // Optionally, you can display an error message to the user
          },
          complete: () => {
            // Handle any completion logic if needed
          }
        });
      } else {
        // Form is not valid, handle accordingly
      }
    }
  }
}
