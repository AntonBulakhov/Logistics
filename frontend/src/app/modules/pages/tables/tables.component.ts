import {Component, OnInit} from '@angular/core';
import {OrderModel} from "../../../models/order.model";
import {OrderService} from "../../../services/order.service";
import {OrderstatusModel} from "../../../models/orderstatus.model";
import {OrderstatusService} from "../../../services/orderstatus.service";

@Component({
  selector: 'app-tables',
  templateUrl: './tables.component.html',
  styleUrls: ['./tables.component.css']
})
export class TablesComponent implements OnInit {

  public orders: OrderModel[];

  public statuses: OrderstatusModel[];

  constructor(private orderService: OrderService,
              private statusService: OrderstatusService) {
  }

  ngOnInit() {
    this.orderService.getNewOrPaidOrders().subscribe(value => {
      this.orders = value as OrderModel[];
    });

    this.statusService.getAllStatuses().subscribe(value => {
      this.statuses = value as OrderstatusModel[];
    });
  }

  confirmOrder(order: OrderModel) {
    order.orderStatus = this.getAcceptedStatus();
    this.orderService.saveNewOrder(order).subscribe();
  }

  rejectOrder(order: OrderModel) {
    order.orderStatus = this.getRejectedStatus();
    this.orderService.saveNewOrder(order).subscribe();
  }

  public getAcceptedStatus(): OrderstatusModel {
    return this.statuses.find(obj => obj.name == 'accepted');
  }

  public getRejectedStatus(): OrderstatusModel {
    return this.statuses.find(obj => obj.name == 'rejected');
  }
}
