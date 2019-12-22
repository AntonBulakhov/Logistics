import {Component, OnInit} from '@angular/core';
import {PointService} from "../../../services/point.service";
import {OrderService} from "../../../services/order.service";
import {PointModel} from "../../../models/point.model";
import {OrderModel} from "../../../models/order.model";
import {DataService} from "../../../services/data/data.service";
import {Router} from "@angular/router";
import {NewOrderModel} from "../../../models/dto/newOrder.model";
import {OrderstatusService} from "../../../services/orderstatus.service";
import {OrderstatusModel} from "../../../models/orderstatus.model";
import {OrderTypeModel} from "../../../models/ordertype.model";

@Component({
  selector: 'app-orderform',
  templateUrl: './orderform.component.html',
  styleUrls: ['./orderform.component.css']
})
export class OrderformComponent implements OnInit {

  public selectedMetric: string = 'M';

  public height: number;
  public width: number;
  public length: number;
  public startPoint: PointModel;
  public endPoint: PointModel;
  public orderType: OrderTypeModel = new OrderTypeModel();

  public statuses: OrderstatusModel[] = [];
  public types: OrderTypeModel[] = [];

  public points: PointModel[];

  public order: OrderModel = new OrderModel();

  constructor(private pointService: PointService,
              private dataService: DataService,
              private router: Router,
              private statusService: OrderstatusService,
              private orderService: OrderService) {
  }

  ngOnInit() {
    this.pointService.getAllPoints().subscribe(value => {
      this.points = value as PointModel[];
    });
    this.statusService.getAllStatuses().subscribe(value => {
      this.statuses = value as OrderstatusModel[];
    });
    this.orderService.getAllTypes().subscribe(value => {
      this.types = value as OrderTypeModel[];
    });
  }

  onMetricSelect(event) {
    this.selectedMetric = event.target.value;
  }


  createOrder() {
    let newOrder: NewOrderModel = new NewOrderModel();
    this.order.value = this.getValue();
    newOrder.newOrder = this.order;
    newOrder.startPoint = this.startPoint;
    newOrder.endPoint = this.endPoint;
    newOrder.newOrder.orderStatus = this.getNewStatus();
    newOrder.newOrder.orderType = this.orderType;
    this.dataService.saveOrder(newOrder);
    this.router.navigate(['/confirm']);
  }

  public getValue(): string {
    let value : number = this.height * this.width * this.length;
    if (this.selectedMetric == 'M') {
      value = value * 0.001;
    } else {
      value = value * 0.016387064;
    }
    return value.toString();
  }

  public getNewStatus(): OrderstatusModel {
    return this.statuses.find(obj => obj.name == 'new');
  }
}
