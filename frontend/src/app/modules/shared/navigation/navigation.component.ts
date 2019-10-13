import { Component, OnInit } from '@angular/core';
import {RoleService} from "../../../services/role.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  constructor(private roleService: RoleService) { }

  ngOnInit() {
  }

  getAllRoles() {
    this.roleService.getAllRoles().subscribe(value => {
      console.log(value);
    })
  }
}
