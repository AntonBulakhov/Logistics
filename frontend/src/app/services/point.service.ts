import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {PointModel} from "../models/point.model";
import {Observable} from "rxjs";

@Injectable()
export class PointService {

  constructor(private http: HttpClient) {
  }

  createPoint(point: PointModel): Observable<PointModel> {
    return this.http.post<PointModel>("/api/point", point);
  }

  getPointByName(pointName: string): Observable<PointModel> {
    return this.http.get<PointModel>("/api/point/name/" + pointName);
  }

  getAllPoints(): Observable<PointModel[]>{
    return this.http.get<PointModel[]>("/api/point/all")
  }


}
