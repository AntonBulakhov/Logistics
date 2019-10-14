import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {RouteModel} from "../models/route.model";

@Injectable({
  providedIn: 'root'
})
export class RouteService {

  constructor(private http: HttpClient) { }

  createRoute(route: RouteModel){
    this.http.post<RouteModel>("/api/route", route)
  }


}
