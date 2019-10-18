import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {TransportModel} from "../models/transport.model";

@Injectable({
  providedIn: 'root'
})
export class TransportService {

  constructor(private http: HttpClient) {
  }

  getAllTransport(): Observable<TransportModel[]> {
    return this.http.get<TransportModel[]>("/api/transport/all")
  }
}
