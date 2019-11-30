import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {newRouteModel} from "../models/dto/newRoute.model";
import {Observable} from "rxjs";
import {NewOrderModel} from "../models/dto/newOrder.model";
import {AlternativeRouteModel} from "../models/dto/alternativeRoute.model";

@Injectable({
  providedIn: 'root'
})
export class RouteService {

  constructor(private http: HttpClient) { }

  createRoute(route: newRouteModel): Observable<Boolean>{
    return this.http.post<Boolean>("/api/route", route);
  }

  getAlternativeRoutes(newOrder: NewOrderModel): Observable<AlternativeRouteModel[]>{
    return this.http.post<AlternativeRouteModel[]>("/api/order/alternative", newOrder);
  }
}
