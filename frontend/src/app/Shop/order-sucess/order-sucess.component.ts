import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {MqttService} from "ngx-mqtt";

@Component({
  selector: 'app-order-sucess',
  templateUrl: './order-sucess.component.html',
  styleUrls: ['./order-sucess.component.css']
})
export class OrderSucessComponent implements OnInit {
  orderId: string = "";

  constructor(private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    // Get the orderId query parameter from the activated route
    this.route.queryParams.subscribe(params => {
      this.orderId = params['orderId'];
    });
  }

}
