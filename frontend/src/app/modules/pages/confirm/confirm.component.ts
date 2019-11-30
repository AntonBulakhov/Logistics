import { Component, OnInit } from '@angular/core';
import {DataService} from "../../../services/data/data.service";
import {OrderService} from "../../../services/order.service";
import {OrderModel} from "../../../models/order.model";
import {NewOrderModel} from "../../../models/dto/newOrder.model";
import {AlternativeRouteModel} from "../../../models/dto/alternativeRoute.model";
import {RouteService} from "../../../services/route.service";

@Component({
  selector: 'app-confirm',
  templateUrl: './confirm.component.html',
  styleUrls: ['./confirm.component.css']
})
export class ConfirmComponent implements OnInit {

  public newOrder: NewOrderModel;
  public order: OrderModel;

  public alternativeRoutes: AlternativeRouteModel[];

  constructor(private dataService: DataService,
              private orderService: OrderService,
              private routeService: RouteService) { }

  ngOnInit() {
    this.newOrder = this.dataService.getOrder();
    this.routeService.getAlternativeRoutes(this.newOrder).subscribe(value => {
      this.alternativeRoutes = value as AlternativeRouteModel[];
      console.log(this.alternativeRoutes);
    });
  }

}
