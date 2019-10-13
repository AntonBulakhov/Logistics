import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {PointModel} from "../models/point.model";

@Injectable({
  providedIn: 'root'
})
export class PointService {

  constructor(private http: HttpClient) { }

  createPoint(point: PointModel) {
    this.http.post("/api/point", point);
  }
}
