import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class RoutehassegmentService {

  constructor(private http: HttpClient) { }
}
