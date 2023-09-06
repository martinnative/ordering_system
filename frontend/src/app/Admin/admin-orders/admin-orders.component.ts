import {Component, OnInit} from '@angular/core';
import {Order} from "../../../model/Order";
import {OrdersService} from "../../orders.service";
import {Product} from "../../../model/Product";
import {ImageService} from "../../image.service";
import {LoadingService} from "../../loading.service";
import Swal from 'sweetalert2';
import {Ingredient} from "../../../model/Ingredient";
import {IMqttMessage, IMqttServiceOptions, MqttService} from "ngx-mqtt";
import {Subscription} from "rxjs";
const certificate = `-----BEGIN CERTIFICATE-----
MIIFJDCCBAygAwIBAgISBOfox8CbMIVdK2Q5Lb0w1t4yMA0GCSqGSIb3DQEBCwUA
MDIxCzAJBgNVBAYTAlVTMRYwFAYDVQQKEw1MZXQncyBFbmNyeXB0MQswCQYDVQQD
EwJSMzAeFw0yMzA3MjcwNTI0MTJaFw0yMzEwMjUwNTI0MTFaMB8xHTAbBgNVBAMT
FGNvbnNvbGUuaGl2ZW1xLmNsb3VkMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIB
CgKCAQEA1zAuyj2nz2w2stp2q0qmb+bZ/ytNLXeVXBmznTxhtP4+XyhU+j7WapH1
u9Dpk++Aygnq/Z5/8gsO+IrdZ1ND3iUC1zRPJw1cPWTJPpsBLvoeG72eWmC3rSEf
bKBqqR9hbUB70LPmsUO0H8nlnlAUN43Ol3pT/BOhPb92Oy0zKj9EpKw/2trzZMYu
ci6UUt8Z/z+TiKAocsP84PfXt9N1JHy76L44v3L4kSc33fM1rIwHtBzJ5x/K1hrj
Uvd1MxBWJERwpG7RPWRbcIo2rDE4DGEmYJuU9C9beAO4gcVY0bw//i63A1BZImwH
mULM/z4Vbk+/CMXFPhKvV1sNfpzgxQIDAQABo4ICRTCCAkEwDgYDVR0PAQH/BAQD
AgWgMB0GA1UdJQQWMBQGCCsGAQUFBwMBBggrBgEFBQcDAjAMBgNVHRMBAf8EAjAA
MB0GA1UdDgQWBBSipG82qkK3/rCKWplRHy90ZLfRkzAfBgNVHSMEGDAWgBQULrMX
t1hWy65QCUDmH6+dixTCxjBVBggrBgEFBQcBAQRJMEcwIQYIKwYBBQUHMAGGFWh0
dHA6Ly9yMy5vLmxlbmNyLm9yZzAiBggrBgEFBQcwAoYWaHR0cDovL3IzLmkubGVu
Y3Iub3JnLzBOBgNVHREERzBFghRjb25zb2xlLmhpdmVtcS5jbG91ZIItZnJvbnRl
bmQuY29uc29sZS5wb3J0YWwuZXVjMS5hd3MuaGl2ZW1xLmNsb3VkMBMGA1UdIAQM
MAowCAYGZ4EMAQIBMIIBBAYKKwYBBAHWeQIEAgSB9QSB8gDwAHYAejKMVNi3LbYg
6jjgUh7phBZwMhOFTTvSK8E6V6NS61IAAAGJlgTsLwAABAMARzBFAiEAsZoBAtKw
fY/yvfjD4OUsmpOMKc4X28DQXHs4Au2bgSECICcILgxOMvrf4VxCqYwB4y0lh98E
JjE0SwOIGwRWZUPxAHYAtz77JN+cTbp18jnFulj0bF38Qs96nzXEnh0JgSXttJkA
AAGJlgTsLgAABAMARzBFAiEAoCCmEW56BUwbArQuGXt/MNm8g7G0r/JoSigmpggA
gTkCIDHHYj6MQJPPugn8SIDrhDgxWaBtAX2Q400z33r9SCKeMA0GCSqGSIb3DQEB
CwUAA4IBAQAtVpF+9Dj6cO/4qc4nJuHIFQX4Rt22Sv8TUVb18AIq8hkfnGjjVN00
KBxVNNgDML/ZiM9bv4AZCEk4kegyXUnZ0i5ifu9+sP69B3qOh5KqdYoWVaV+MOe0
fxrE5GzZJG6QWHc6AggXpTTt4kv2DSMwlT8kP3E+UhP8id0BbNq9XlBjjFiFNFJ/
yTNbbXjHJ3BexAplYnYoWqviW1HLjQ6DZqyMr6LV3K8LhBo0ysNQWdtad+ikUr/s
JDFA44fdNS9WWiF7PoWWnGOrsU0EqXCduAFyBRRNHPNXf7/CEyzMAKqZvbMRVIZC
fmO+S2YZTESF7oXc/eNi6DLIPwsRwmDA
-----END CERTIFICATE-----
`
const subscriberOptions: IMqttServiceOptions = {
  protocol: 'wss',
  hostname: '0e2b872d30104e009127c52455bcd6be.s2.eu.hivemq.cloud',
  port: 8884,
  username: 'dragan',
  password: 'Dragan12345Dd',
  rejectUnauthorized: true,
  clientId: 'SubscriberClient', // Change this to a unique client ID
  path: '/mqtt',
  cert: certificate, // If required
};
@Component({
  selector: 'app-admin-orders',
  templateUrl: './admin-orders.component.html',
  styleUrls: ['./admin-orders.component.css']
})

export class AdminOrdersComponent implements OnInit{
  orders: Order[] = []
  filteredOrders: Order[] = [];
  subscription: Subscription | undefined;

  constructor(private ordersService:OrdersService,
              private imageService:ImageService,
              private loaderService:LoadingService,
              private _mqttService: MqttService) {
  }
  ngOnInit(): void {
    window.addEventListener('beforeunload', this.onPageRefresh);
    this.ordersService.findAllOrders().subscribe(data => {
      this.orders = data
      this.filteredOrders = data;
    });
    this._mqttService.connect(subscriberOptions);
    this.subscription = this._mqttService.observe('orders').subscribe(
      (msg: IMqttMessage) => {
        this.parseJsonAndUpdate(msg.payload.toString());
      },
      (error: any) => {
      },
      () => {
      }
    );
  }
  onPageRefresh(event: Event): void {
    this.ordersService.findAllOrders().subscribe(data => {
      this.orders = data
      this.filteredOrders = data;
    });
  }

  ngOnDestroy(): void {
    window.removeEventListener('beforeunload', this.onPageRefresh);
  }
  transformData(data: Product):Product {
    return this.imageService.transformData(data);
  }
  transformDataIngredient(data: Ingredient):Ingredient {
    return this.imageService.transformIngredient(data);
  }
  orderStatusChanged(order:Order) {
    if(order.finished) {
      Swal.fire({
        title: 'Дали сте сигурни дека сакате да ја завршите нарачката?',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: '✓',
        cancelButtonText: 'X',
        heightAuto:false,
      }).then((result) => {
        if (result.value) {
          this.loaderService.setLoading(true);
          this.ordersService.changeOrderStatus(order).subscribe(data => {
            this.orders=data;
            this.filteredOrders = data;
            this.loaderService.setLoading(false);
            Swal.fire('Успешно!', 'Нарачката е сега завршена', 'success');
          });
        } else if (result.dismiss === Swal.DismissReason.cancel) {
          order.finished = !order.finished;
          Swal.fire('Откажано!', 'Нема промени во нарачката', 'error');
        }
        else {
          Swal.fire('Откажано!', 'Дојде до грешка!', 'error');
        }
      });
    }
    else {
      Swal.fire({
        title: 'Дали сте сигурни дека сакате да ја вратите во процесирање?',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: '✓',
        cancelButtonText: 'X',
        heightAuto:false,
      }).then((result) => {
        if (result.value) {
          this.loaderService.setLoading(true);
          this.ordersService.changeOrderStatus(order).subscribe(data => {
            this.orders=data;
            this.filteredOrders = data;
            this.loaderService.setLoading(false);
            Swal.fire('Успешно!', 'Нарачката е сега во процесирање', 'success');
          });
        } else if (result.dismiss === Swal.DismissReason.cancel) {
          order.finished = !order.finished;
          Swal.fire('Откажано!', 'Нема промени во нарачката', 'error');
        }
        else {
          Swal.fire('Откажано!', 'Дојде до грешка!', 'error');
        }
      });
    }


  }
  resetFilter() {
    this.filteredOrders = this.orders;
  }
  showProcessing() {
    this.filteredOrders = this.orders.filter(a => !a.finished)
  }
  showFinished() {
    this.filteredOrders = this.orders.filter(a => a.finished)
  }
  parseJsonAndUpdate(message: string) {
    let object = JSON.parse(message);
    let refreshOrders:boolean = JSON.parse(object["refreshOrders"]);
    if(refreshOrders) {
      this.ordersService.findAllOrders().subscribe(data => {
        this.orders = data
        this.filteredOrders = data;
      });
    }
  }
}
