import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {TransportModel} from "../models/transport.model";
import {TransporttypeModel} from "../models/transporttype.model";

@Injectable({
  providedIn: 'root'
})
export class TransportService {

  constructor(private http: HttpClient) {
  }

  getAllTransport(): Observable<TransportModel[]> {
    return this.http.get<TransportModel[]>("/api/transport/all");
  }

  getTransportsByType(id: string): Observable<TransportModel[]> {
    return this.http.get<TransportModel[]>("/api/transport/all/type/" + id);
  }

  getAllTypes(): Observable<TransporttypeModel[]> {
    return this.http.get<TransporttypeModel[]>("/api/transport/types");
  }

  createTransport(transport: TransportModel): Observable<boolean> {
    return this.http.post<boolean>("/api/transport", transport);
  }
}
