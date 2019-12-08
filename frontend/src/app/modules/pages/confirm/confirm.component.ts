import {Component, OnInit} from '@angular/core';
import {DataService} from "../../../services/data/data.service";
import {OrderService} from "../../../services/order.service";
import {OrderModel} from "../../../models/order.model";
import {NewOrderModel} from "../../../models/dto/newOrder.model";
import {AlternativeRouteModel} from "../../../models/dto/alternativeRoute.model";
import {RouteService} from "../../../services/route.service";
import {OrderstatusModel} from "../../../models/orderstatus.model";
import {OrderstatusService} from "../../../services/orderstatus.service";
import {Router} from "@angular/router";
import {AuthService} from "../../../services/security/auth.service";

@Component({
  selector: 'app-confirm',
  templateUrl: './confirm.component.html',
  styleUrls: ['./confirm.component.css']
})
export class ConfirmComponent implements OnInit {

  public newOrder: NewOrderModel;
  public order: OrderModel = new OrderModel();

  public alternativeRoutes: AlternativeRouteModel[];

  public selectedAlternativeRoute: AlternativeRouteModel = new AlternativeRouteModel();

  public statuses: OrderstatusModel[];

  constructor(private dataService: DataService,
              private orderService: OrderService,
              private routeService: RouteService,
              private statusService: OrderstatusService,
              private router: Router,
              private auth: AuthService) {
  }

  ngOnInit() {
    this.newOrder = this.dataService.getOrder();
    this.routeService.getAlternativeRoutes(this.newOrder).subscribe(value => {
      this.alternativeRoutes = value as AlternativeRouteModel[];
      console.log(this.alternativeRoutes);
    });

    this.statusService.getAllStatuses().subscribe(value => {
      this.statuses = value as OrderstatusModel[];
    });
  }

  onChange(event) {
    this.selectedAlternativeRoute = this.getAltRouteByRouteId(event.target.value);
  }

  public getAltRouteByRouteId(id: string): AlternativeRouteModel {
    return this.alternativeRoutes.find(obj => obj.route.id == id);
  }

  onPaid() {
    this.order = this.newOrder.newOrder;
    this.order.route = this.selectedAlternativeRoute.route;
    this.order.orderStatus = this.getPaidStatus();
    this.order.cost = this.selectedAlternativeRoute.price;
    this.order.user = this.auth.user;

    this.orderService.saveNewOrder(this.order).subscribe(value => {
      if (value) {
        //redirect to congratulation page
        this.router.navigate(['/']);
      }
    })
  }

  public getPaidStatus(): OrderstatusModel {
    return this.statuses.find(obj => obj.name == 'paid');
  }

}
