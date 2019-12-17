import {Component, OnInit} from '@angular/core';
import {PointModel} from "../../../models/point.model";
import {PointService} from "../../../services/point.service";
import {OrderService} from "../../../services/order.service";
import {DeliveryModel} from "../../../models/dto/delivery.model";
import {OrderstatusService} from "../../../services/orderstatus.service";
import {OrderstatusModel} from "../../../models/orderstatus.model";
import {OrderModel} from "../../../models/order.model";

@Component({
  selector: 'app-delivery',
  templateUrl: './delivery.component.html',
  styleUrls: ['./delivery.component.css']
})
export class DeliveryComponent implements OnInit {

  public route: OrderModel = new OrderModel();
  public points: PointModel[];
  public isPointsSame: boolean;

  public orders: DeliveryModel[];
  public statuses: OrderstatusModel[];

  constructor(private pointService: PointService,
              private orderService: OrderService,
              private orderstatusService: OrderstatusService) {
  }

  ngOnInit() {
    this.pointService.getAllPoints().subscribe(data => {
      this.points = data as PointModel[];
    });
    if (this.route.route.endPoint != undefined && this.route.route.startPoint != undefined) {
      this.orderService.getOrdersByRoute(this.route).subscribe(value => {
        this.orders = value as DeliveryModel[];
      });
      this.orderstatusService.getAllStatuses().subscribe(value => {
        this.statuses = value as OrderstatusModel[];
      });
    }
  }

  searchOrders(): void {
    this.isPointsSame = this.route.route.startPoint.name == this.route.route.endPoint.name;
    if (!this.isPointsSame) {
      this.ngOnInit();
    }
  }

  confirmOrder(order: OrderModel): void {
    order.orderStatus = this.getStatus("delivering");
    this.orderService.setOrdersStatus(order).subscribe(value => {
      this.ngOnInit()
    });
  }

  rejectOrder(order: OrderModel): void {
    order.orderStatus = this.getStatus("not delivered");
    this.orderService.setOrdersStatus(order).subscribe(value => {
      this.ngOnInit()
    });
  }

  public getStatus(name: string): OrderstatusModel {
    return this.statuses.find(obj => obj.name == name);
  }

}
