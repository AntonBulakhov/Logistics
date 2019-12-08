import { Component, OnInit } from '@angular/core';
import {DataService} from "../../../services/data/data.service";
import {Router} from "@angular/router";
import {UserModel} from "../../../models/user.model";
import {UserService} from "../../../services/user.service";

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements OnInit {

  private employees: UserModel[];

  constructor( private dataService: DataService,
               private router: Router,
               private userService: UserService) { }

  ngOnInit() {
    this.userService.getAllEmployees().subscribe(value => {
      this.employees = value as UserModel[];
    })
  }

  register(role: string) {
    this.dataService.saveRoleName(role);
    this.router.navigate(['/registration']);
  }

}
