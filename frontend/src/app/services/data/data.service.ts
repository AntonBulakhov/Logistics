import {Injectable} from '@angular/core';
import {OrderModel} from "../../models/order.model";
import {Observable} from "rxjs";
import {NewOrderModel} from "../../models/dto/newOrder.model";

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor() {
  }

  saveOrder(order: NewOrderModel) {
    localStorage.setItem('order', JSON.stringify(order));
  }

  getOrder(): NewOrderModel {
    return JSON.parse(localStorage.getItem('order'));
  }
}
