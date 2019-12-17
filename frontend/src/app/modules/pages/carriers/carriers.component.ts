import { Component, OnInit } from '@angular/core';
import {UserModel} from "../../../models/user.model";
import {DataService} from "../../../services/data/data.service";
import {Router} from "@angular/router";
import {UserService} from "../../../services/user.service";

@Component({
  selector: 'app-carriers',
  templateUrl: './carriers.component.html',
  styleUrls: ['./carriers.component.css']
})
export class CarriersComponent implements OnInit {

  private carriers: UserModel[];

  constructor( private dataService: DataService,
               private router: Router,
               private userService: UserService) { }

  ngOnInit() {
    this.userService.getAllByRoleId('4').subscribe(value => {
      this.carriers = value as UserModel[];
    });
  }

  register(role: string) {
    this.dataService.saveRoleName(role);
    this.router.navigate(['/registration']);
  }

  setBlocked(toBlock: string, carrier: UserModel): void {
    carrier.blocked = toBlock;
    this.userService.setUserStatus(carrier).subscribe(value => {
      this.ngOnInit();
    });
  }
}
