import { Component, OnInit } from '@angular/core';
import {OrderTypeModel} from "../../../models/ordertype.model";
import {OrderService} from "../../../services/order.service";

@Component({
  selector: 'app-coeff',
  templateUrl: './coeff.component.html',
  styleUrls: ['./coeff.component.css']
})
export class CoeffComponent implements OnInit {

  private coeffs: OrderTypeModel[] = [];

  constructor(private orderService: OrderService) { }

  ngOnInit() {
    this.orderService.getAllTypes().subscribe(value => {
      this.coeffs = value as OrderTypeModel[];
    });
  }

  onChange(co: OrderTypeModel) {
    this.orderService.saveOrderType(co).subscribe(value => {
      this.ngOnInit();
    });
  }

}
