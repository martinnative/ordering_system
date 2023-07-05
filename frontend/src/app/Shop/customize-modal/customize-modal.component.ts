import { Component, Input } from '@angular/core';
import { Product } from 'src/model/Product';
import { OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import {ShoppingCartService} from "../../shopping-cart.service";
import {ImageService} from "../../image.service";
import {Ingredient} from "../../../model/Ingredient";

@Component({
  selector: 'app-customize-modal',
  templateUrl: './customize-modal.component.html',
  styleUrls: ['./customize-modal.component.css']
})
export class CustomizeModalComponent {
  @Input() public product:Product|undefined;
  quantity:number = 1;

  constructor(public activeModal: NgbActiveModal, private shoppingCartService:ShoppingCartService,private imageService:ImageService) {};
  closeModal() {
    this.activeModal.close();
  }
  addQuantity() {
    this.quantity++;
  }
  subQuantity() {
    if(this.quantity>0) {
      this.quantity--;
    }
  }
  transformData(data: Product):Product {
    return this.imageService.transformData(data);
  }
  save() {
    if(this.quantity < 0 || isNaN(this.quantity)) {
      this.quantity = 1;
    }
    else{
      this.activeModal.close({"product":this.product,"quantity":this.quantity});
    }
  }
  //TODO: FIX INGREDIENTS TO ACTUALLY RETURN A THING WHEN SELECTED AND RETREIVE THEM IN BACKEND

}
