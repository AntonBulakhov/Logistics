import { Component, OnInit } from '@angular/core';
import {PointService} from "../../../services/point.service";
import {OrderService} from "../../../services/order.service";
import {PointModel} from "../../../models/point.model";
import {OrderModel} from "../../../models/order.model";
import {DataService} from "../../../services/data/data.service";
import {Router} from "@angular/router";
import {NewOrderModel} from "../../../models/dto/newOrder.model";
import {OrderstatusService} from "../../../services/orderstatus.service";
import {OrderstatusModel} from "../../../models/orderstatus.model";

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

  public statuses: OrderstatusModel[];

  public points: PointModel[];

  public order: OrderModel;

  constructor(private pointService: PointService,
              private dataService: DataService,
              private router: Router,
              private statusService: OrderstatusService) { }

  ngOnInit() {
    this.pointService.getAllPoints().subscribe(value => {
      this.points = value as PointModel[];
    });
    this.statusService.getAllStatuses().subscribe(value => {
      this.statuses = value as OrderstatusModel[];
    });
  }

  onMetricSelect(event) {
    this.selectedMetric = event.target.value;
  }


  createOrder() {
    let newOrder: NewOrderModel = new NewOrderModel();
    newOrder.order = this.order;
    newOrder.startPoint = this.startPoint;
    newOrder.endPoint = this.endPoint;
    newOrder.order.orderStatus = this.getNewStatus();
    this.dataService.saveOrder(newOrder);
    this.router.navigate(['/confirm']);
  }

  public getNewStatus(): OrderstatusModel{
    return this.statuses.find(obj=> obj.name == 'new');
  }
}
