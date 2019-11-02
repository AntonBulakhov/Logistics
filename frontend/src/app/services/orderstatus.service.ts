import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {OrderstatusModel} from "../models/orderstatus.model";

@Injectable({
  providedIn: 'root'
})
export class OrderstatusService {

  constructor(private http: HttpClient) {
  }

  getAllStatuses(): Observable<OrderstatusModel[]> {
    return this.http.get<OrderstatusModel[]>("/api/status/all");
  }
}
