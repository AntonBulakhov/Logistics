import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {newRouteModel} from "../models/dto/newRoute.model";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class RouteService {

  constructor(private http: HttpClient) { }

  createRoute(route: newRouteModel): Observable<Boolean>{
    return this.http.post<Boolean>("/api/route", route);
  }


}
