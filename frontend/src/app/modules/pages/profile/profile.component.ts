import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../../services/security/auth.service";
import {UserService} from "../../../services/user.service";
import {UserModel} from "../../../models/user.model";
import {OrderModel} from "../../../models/order.model";
import {OrderService} from "../../../services/order.service";
import {OrderstatusModel} from "../../../models/orderstatus.model";
import {OrderstatusService} from "../../../services/orderstatus.service";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  public user: UserModel = new UserModel();
  public orders: OrderModel[];

  public orderToPay: OrderModel = new OrderModel();

  public statuses: OrderstatusModel[];

  constructor(private auth: AuthService,
              private userService: UserService,
              private orderService: OrderService,
              private statusService: OrderstatusService) {
  }

  ngOnInit() {
    this.userService.getFullUserById(this.auth.user.id).subscribe(value => {
      this.user = value;
    });
    if (this.auth.user.role.name == 'client') {
      this.orderService.getOrdersByUserId(this.auth.user.id).subscribe(value => {
        this.orders = value as OrderModel[];
      })
    }
    this.statusService.getAllStatuses().subscribe(value => {
      this.statuses = value as OrderstatusModel[];
    });
  }


  payOrder(order: OrderModel): void {
    this.orderToPay = order;
  }

  onPaid(): void {
    this.orderToPay.orderStatus = this.getPaidStatus();

    this.orderService.setOrdersStatus(this.orderToPay).subscribe(value => {
      this.ngOnInit();
    });
  }

  public getPaidStatus(): OrderstatusModel {
    return this.statuses.find(obj => obj.name == 'paid');
    }

}
