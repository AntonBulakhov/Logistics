import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {OrderModel} from "../models/order.model";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http: HttpClient) {
  }

  saveNewOrder(order: OrderModel): Observable<boolean> {
    return this.http.post<boolean>("/api/order/save", order);
  }

  getNewOrPaidOrders(): Observable<OrderModel[]> {
    return this.http.get<OrderModel[]>("/api/order/paid");
  }

  getOrdersByUserId(id: string): Observable<OrderModel[]> {
    return this.http.get<OrderModel[]>("/api/order/user/" + id);
  }
}
