import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../../services/security/auth.service";
import {UserService} from "../../../services/user.service";
import {UserModel} from "../../../models/user.model";
import {OrderModel} from "../../../models/order.model";
import {OrderService} from "../../../services/order.service";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  public user: UserModel = new UserModel();
  public orders: OrderModel[];

  constructor(private auth: AuthService,
              private userService: UserService,
              private orderService: OrderService) {
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
  }

}
