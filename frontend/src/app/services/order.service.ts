import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {OrderModel} from "../models/order.model";
import {Observable} from "rxjs";
import {RouteModel} from "../models/route.model";
import {DeliveryModel} from "../models/dto/delivery.model";

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

  getOrdersByRoute(route: OrderModel): Observable<DeliveryModel[]> {
    return this.http.post<DeliveryModel[]>("/api/order/route", route);
  }

  setOrdersStatus(order: OrderModel): Observable<boolean> {
    return this.http.post<boolean>("/api/order/status", order);
  }
}
